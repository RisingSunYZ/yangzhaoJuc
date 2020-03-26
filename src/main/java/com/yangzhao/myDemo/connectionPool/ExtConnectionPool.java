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
 */
public final class ExtConnectionPool {

    private ExtConnectioonPoolConfiguration extConnectioonPoolConfiguration = new ExtConnectioonPoolConfiguration();

    private List<Connection> activeList = new CopyOnWriteArrayList<>();

    private AtomicInteger freeSize = new AtomicInteger(extConnectioonPoolConfiguration.getInitialSize());

    private List freeList = new CopyOnWriteArrayList<>();

    public ExtConnectionPool() throws Exception{
        initPool();
    }

    private synchronized void initPool() throws Exception{

        Integer initialSize = extConnectioonPoolConfiguration.getInitialSize();
        for(int i=0;i<initialSize;i++){
            Connection getConnection = getConnection();
            freeList.add(getConnection);
        }

//        for(int i=0;i<freeList.size();i++){
//            System.out.println(freeList.get(i));
//        }

    };

    public synchronized Connection getCon() throws Exception{
        while(freeSize.get() == extConnectioonPoolConfiguration.getMaxSize()){
//            throw new Exception("可用链接以超过最大连接数，无法获取,请等待");
//            TimeUnit.SECONDS.sleep(extConnectioonPoolConfiguration.getTime());
            wait(extConnectioonPoolConfiguration.getTime());
            System.out.println("到达最大连接数"+Thread.currentThread().getName()+"等待"+extConnectioonPoolConfiguration.getTime());
            getCon();
        }
        Connection remove = (Connection)freeList.remove(0);
        activeList.add(remove);
        freeSize.getAndIncrement();
        notifyAll();
        return remove;
    }

    public synchronized void release(Connection conn) throws Exception{

        while(freeSize.get() == extConnectioonPoolConfiguration.getInitialSize()){
            wait(extConnectioonPoolConfiguration.getTime());
            System.out.println("到达最小连接数"+Thread.currentThread().getName()+"等待"+extConnectioonPoolConfiguration.getTime());
        }
        activeList.remove(conn);
        freeList.add(conn);
        freeSize.getAndDecrement();
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
