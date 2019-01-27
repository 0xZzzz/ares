package com.ares.service.classloading.process;

public class Test {

    public static void main(String[] args) {
        C1.staticInvoke();
    }

}

class C1 {

    static {
        System.out.println("C1 static block execute");
    }

    public static C2 c2 = new C2();

    public C1() {
        System.out.println("C1 constructor execute");
    }

    {
        System.out.println("C1 free block execute");
    }

    public C3 c3 = new C3();

    public static void staticInvoke() {
        System.out.println("C1 static method invoke");
    }

}

class C2 {

    static {
        System.out.println("C2 static block execute");
    }

    {
        System.out.println("C2 free block execute");
    }

    public C2() {
        System.out.println("C2 constructor execute");
    }
}

class C3 {

    static {
        System.out.println("C3 static block execute");
    }

    {
        System.out.println("C3 free block execute");
    }

    public C3() {
        System.out.println("C3 constructor execute");
    }
}