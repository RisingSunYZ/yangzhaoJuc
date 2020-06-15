package com.yangzhao.designPattern.builder;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/1/4 16:46
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class UserBuilder {

    private String name;
    private String adress;


    private UserBuilder(){}


    public static InnerUser getBuilder(){
        InnerUser InnerUser = new InnerUser();
        return InnerUser;
    }

    @Override
    public String toString() {
        return "UserBuilder{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }

    public static final class InnerUser{
        private String name;
        private String adress;

        public InnerUser setName(String name) {
            this.name = name;
            return this;
        }

        public InnerUser setAdress(String adress) {
            this.adress = adress;
            return this;
        }

        public UserBuilder build(){
            UserBuilder UserBuilder = new UserBuilder();
            UserBuilder.name = this.name;
            UserBuilder.adress = this.adress;
            return UserBuilder;
        }

    }

}
