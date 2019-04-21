package com.example.charp02.classandmember.app;

/**
 * @ClassName MyClass
 * @Author nihui
 * @Date 2019/4/21 16:47
 * @Version 1.0
 * @Description TODO
 */
public class MyClass {

    //实例变量
    private String mPrivateStirng;//最小范围
    public String mPublicString; //最大范围
    protected String mProtectedString; //当前类内可以，同一个包内的其他类也可以，还有他的子类也可以访问
    String mFriendlyString; //自己类和同包下的类可以访问

    //全局变量
    public static String mStaticString;

    public void mPulbicMethod(){
        System.out.println("我的方法被调用了！");
    }
    private void mPrivateMethod(){
        System.out.println("我的方法被调用了！");
    }
    protected void mProtectedMethod(){
        System.out.println("我的方法被调用了！");
    }

    void mFriendlyMethod(){
        System.out.println("我的方法被调用！");
    }

    public static void mStaticMethod(){
        System.out.println("调用了我的静态方法");
    }


}
