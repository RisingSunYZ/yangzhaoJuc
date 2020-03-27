package com.yangzhao.myDemo.mybatis;

import com.yangzhao.myDemo.connectionPool.ExtConnectioonPoolConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/27 15:01
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class JdbcUtils {

    private static final ExtConnectioonPoolConfiguration extConnectioonPoolConfiguration = new ExtConnectioonPoolConfiguration();

    public static Connection getConnection() throws Exception{
        String driverClassName = extConnectioonPoolConfiguration.getDriverClassName();
        String username = extConnectioonPoolConfiguration.getUsername();
        String password = extConnectioonPoolConfiguration.getPassword();
        String jdbcUrl = extConnectioonPoolConfiguration.getJdbcUrl();
        Class.forName(driverClassName);
        Connection connection = DriverManager.getConnection(jdbcUrl,username, password);
        return connection;
    };
}
