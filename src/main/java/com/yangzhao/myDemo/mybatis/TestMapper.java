package com.yangzhao.myDemo.mybatis;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/27 13:10
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public interface TestMapper {

    @ExtInstert("insert into tbl_test(id, name) values(#{id}, #{name})")
    public int insertLog(@ExtParam("id")String id, @ExtParam("name")String name);


    @ExtSelect("select * from tbl_test where id = #{id}")
    public Log selectLog(@ExtParam("id")String id);

}
