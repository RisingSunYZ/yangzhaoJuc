package com.yangzhao.myDemo.connectionPool;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/26 13:47
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class ExtConnectioonPoolConfiguration {

    private String driverClassName="com.mysql.cj.jdbc.Driver";

    private String  jdbcUrl="jdbc:mysql://10.10.20.49:3306/test_ysportal";

    private String  username="system";

    private String  password="!@#$56789";

    private Integer initialSize=5;

    private Integer maxSize=10;

    private Integer activeSize;

    private long time=5;


    public String getDriverClassName() {
        return driverClassName;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getInitialSize() {
        return initialSize;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public Integer getActiveSize() {
        return activeSize;
    }

    public long getTime() {
        return time;
    }
}
