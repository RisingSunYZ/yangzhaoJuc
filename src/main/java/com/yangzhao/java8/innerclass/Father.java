package com.yangzhao.java8.innerclass;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/15 17:10
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Father {

    private String name = "zhangsan";
    private static String age = "45";

    public static Daughter getMyDaughter(){
        return new Daughter();
    }

    public static void sayMyStaticInfo(){
        System.out.println(age);
    }

    public void sayMyInfo(){
        System.out.println(this.name+age);
    }

    static class Daughter{
        private String name = "zhangwu";
        private static String  age = "12";

        public String getFatherAge(){
            return Father.age;//它不能使用任何外围类的非static成员变量和方法。
        }


        public static String getMyAge(){
            return age;
        }

        public void sayFatherInfo(){
            Father.sayMyStaticInfo();
        }

//        public String getMyAge(){
//            return age;
//        }

        public String getMyName(){
            return this.name;
        }

    }

     class Son{

        private String name = "zhangsi";

        public String getFatherName(){
            return Father.this.name;
        }

         public void sayFatherInfo(){
              Father.this.sayMyInfo();
         }

        public String getMyName(){
            return this.name;
        }

    }

}
