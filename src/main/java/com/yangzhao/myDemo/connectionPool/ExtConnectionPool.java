package com.yangzhao.myDemo.connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/26 13:52
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 *
 * freeSize 控制是否超过最大连接数 100
 *
 * 1 和 10  是 池大小边界
 *
 * relase 如果小于 10  归还池 ，大于10  close
 *
 * getConn 如果 池子没有 new ，有的话 从池子取
 *
 * get 有阻塞，release 没有
 *
 * release 需要唤醒 get的阻塞
 *
 * 也不是完全的生产者消费者
 *
 *
 *
 */
public final class ExtConnectionPool {

    private ExtConnectioonPoolConfiguration extConnectioonPoolConfiguration = new ExtConnectioonPoolConfiguration();

    private List<Connection> activeList = new CopyOnWriteArrayList<>();

    private AtomicInteger freeSize = new AtomicInteger();

    private List<Connection> freeList = new CopyOnWriteArrayList<>();

    public ExtConnectionPool() throws Exception{
        initPool();
    }

    private synchronized void initPool() throws Exception{

        Integer initialSize = extConnectioonPoolConfiguration.getInitialSize();
        for(int i=0;i<initialSize;i++){
            Connection getConnection = getConnection();
            freeList.add(getConnection);
            freeSize.incrementAndGet();
        }
    };

    public synchronized Connection getCon() throws Exception{
        while(freeSize.get() == extConnectioonPoolConfiguration.getActiveSize()){
            wait(extConnectioonPoolConfiguration.getTime());
            System.out.println("到达最大连接数"+Thread.currentThread().getName()+"等待"+extConnectioonPoolConfiguration.getTime());
            getCon();
        }



        Connection conn = null;
        if(freeList.size() > 0){

            conn = freeList.remove(0);
            System.out.println(Thread.currentThread().getName()+"从池中获取连接===============");
        }else{
            conn = getConnection();
            System.out.println(Thread.currentThread().getName()+"新创建链接===============");
        }

        if(validateConn(conn)){
            activeList.add(conn);
            freeSize.incrementAndGet();
            notifyAll();
        }else{
            getCon();
        }
        return conn;
    }


    private boolean validateConn(Connection conn) throws Exception{
        if(null == conn || conn.isClosed()){
            return false;
        }
        return true;

    }

    public synchronized void release(Connection conn) throws Exception{
        if(freeList.size() > extConnectioonPoolConfiguration.getMaxSize()){
            conn.close();
            System.out.println(Thread.currentThread().getName()+"关闭连接===============");
        }else{
            freeList.add(conn);
            System.out.println(Thread.currentThread().getName()+"归还池中===============");
        }
        activeList.remove(conn);
        freeSize.decrementAndGet();
        notifyAll();
    }


    private synchronized Connection getConnection() throws Exception{
        String driverClassName = extConnectioonPoolConfiguration.getDriverClassName();
        String username = extConnectioonPoolConfiguration.getUsername();
        String password = extConnectioonPoolConfiguration.getPassword();
        String jdbcUrl = extConnectioonPoolConfiguration.getJdbcUrl();
        Class.forName(driverClassName);
        Connection connection = DriverManager.getConnection(jdbcUrl,username, password);
        return connection;
    };

}
