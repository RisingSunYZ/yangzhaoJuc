package com.yangzhao.myDemo.mybatis;

import com.yangzhao.myDemo.connectionPool.ExtConnectionPool;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/27 13:31
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class MapperProxy implements InvocationHandler {

    private Map<String,Object> paramMap = new ConcurrentHashMap<>();



    private Object obj;

    public MapperProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("=========代理comein=================");
        ExtConnectionPool ExtConnectionPool = new ExtConnectionPool();
        if(method.isAnnotationPresent(ExtInstert.class)){
            ExtInstert annotation = method.getAnnotation(ExtInstert.class);
            String value = annotation.value();
            Parameter[] parameters = method.getParameters();
            for(int i=0;i<parameters.length;i++){
                if(parameters[i].isAnnotationPresent(ExtParam.class)){
                    ExtParam annotation1 = parameters[i].getAnnotation(ExtParam.class);
                    String value1 = annotation1.value();
                    paramMap.put(value1,args[i]);
                }
            }
            return insert(value,ExtConnectionPool);
        }else if(method.isAnnotationPresent(ExtSelect.class)){
            ExtSelect annotation = method.getAnnotation(ExtSelect.class);
            String value = annotation.value();
            Parameter[] parameters = method.getParameters();
            for(int i=0;i<parameters.length;i++){
                if(parameters[i].isAnnotationPresent(ExtParam.class)){
                    ExtParam annotation1 = parameters[i].getAnnotation(ExtParam.class);
                    String value1 = annotation1.value();
                    paramMap.put(value1,args[i]);
                }
            }
            Class<?> returnType = method.getReturnType();
            return query(value,ExtConnectionPool,returnType);
        }


        System.out.println("=========代理comeout=================");
        return null;
    }

    private int insert(String sql,ExtConnectionPool ExtConnectionPool) throws Exception{
        Connection connection = ExtConnectionPool.getCon();
        connection.setAutoCommit(false);
        int i = - 1;
        try{
            sql = sql.replace("{","").replace("}","").replace("#","");
            String[] values = sql.split("values");
            for(Map.Entry<String,Object> map:paramMap.entrySet()){
                String key = map.getKey();
                values[1] = values[1].replace(key,"?");
            }
            sql = values[0] + "values "+values[1];
            System.out.println(sql);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int index = paramMap.size();
            for(Map.Entry<String,Object> map:paramMap.entrySet()){
                Object value = map.getValue();
                preparedStatement.setObject(index,value);
                index --;
            }
            i = preparedStatement.executeUpdate();
//            int a = 1/0;
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
            connection.rollback();
        }finally {
            ExtConnectionPool.release(connection);
//            paramMap
        }
        return i;
    }


    private Object query(String sql,ExtConnectionPool ExtConnectionPool,Class<?> clazz) throws Exception{
        Object o = clazz.newInstance();
        Connection connection = ExtConnectionPool.getCon();
        connection.setAutoCommit(false);
        int i = - 1;
        try{
            sql = sql.replace("{","").replace("}","").replace("#","");
            String[] values = sql.split("=");
            for(Map.Entry<String,Object> map:paramMap.entrySet()){
                String key = map.getKey();
                values[1] = values[1].replace(key,"?");
            }
            sql = values[0] + "= "+values[1];
            System.out.println(sql);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int index = paramMap.size();
            for(Map.Entry<String,Object> map:paramMap.entrySet()){
                Object value = map.getValue();
                preparedStatement.setObject(index,value);
                index --;
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            Field[] declaredFields = clazz.getDeclaredFields();
            while(resultSet.next()){
                for(int j=0;j<declaredFields.length;j++){
                    declaredFields[j].setAccessible(true);
                    declaredFields[j].set(o,resultSet.getObject(declaredFields[j].getName()));
                }
            }
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
            connection.rollback();
        }finally {
            ExtConnectionPool.release(connection);
        }
        return o;
    }

}
