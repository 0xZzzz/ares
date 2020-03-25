package com.ares.service.classloading.process;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

public class Test {

    public static void main(String[] args) {
        String str = "";
        String[] arr1 = str.split(",\\s");
        JSONObject json = new JSONObject();
        for (String str1 : arr1) {
            String[] arr2 = StringUtils.split(str1, "=");
            if (arr2.length == 2) {
                json.put(arr2[0], arr2[1]);
            }
        }
        System.out.println("[" + json.toJSONString() + "]");
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