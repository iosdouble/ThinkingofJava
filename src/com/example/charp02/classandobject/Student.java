package com.example.charp02.classandobject;

/**
 * @ClassName Student
 * @Author nihui
 * @Date 2019/4/21 15:53
 * @Version 1.0
 * @Description TODO
 */
//abstract 抽象 不能被创建只能被继承

//final 如果加上这个关键字表示这个类 不能被继承了
//strictfp 类中的所有方法在处理浮点数的时候使用某种规则
public class Student {




    /**
     * 构造函数不需要编写返回值类型
     * 构造函数必须与类名相同
     */
    public Student() {
    }

    public Student(String name, String sex, String no, float height, float weight) {
        this.name = name;
        this.sex = sex;
        this.no = no;
        this.height = height;
        this.weight = weight;
    }

    //成员变量
    String name;
    String sex;
    String no;
    float height;
    float weight;
   // A aobj = new A();

    //成员方法

    void setStudent(String name,String sex,String no){
        this.name = name;
        this.sex = sex;
        this.no = no;
    }
    void setHW(float height,float weight){
        this.height = height;
        this.weight = weight;
    }


   public static void main(String[] args) {
       Student student = new Student();
       student.setStudent("倪辉","男","12312");
       student.setHW(170.00f,65);
   }
}

//abstract class A{
//
//}
//class B /*extends String*/ {
//
//}
