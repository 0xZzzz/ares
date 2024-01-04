package com.ares.infrastructure.classloader;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

public class Test {

    public static void main(String[] args) {
        String str = "notifyId=2020070600222205656083451410597730, notifyType=open_app_auth_notify, "
            + "status=execute_auth, notifyTime=2020-07-06 20:56:56, charset=UTF-8, version=1.0, "
            + "appId=2017042106866215, authAppId=2021001172619424, "
            + "sign=ieGVCUrP/MxJyxIIMeF9WDWUb4zn/x1+UxLVksvW3vuOtDE2ZBlCqR/2LH5/ueZEVmZ2VG8m2Sitkp/O93Z"
            + "/jVPoqKqtcsdG8Lt1b4iVnB1myRo64L4eNM/8b39s+PsLpC7EnHp6461G0yy5kdXJ6iHrmJNt1onj"
            +
            "+S91G7xaVYkntMs9ow7Y8APZrz1TGWJK2I6EIgCBryP1Ha1DOrq9Ag0Kecz7tAXfTSBeJutSv1un3uOftcU74mDZBkuSUOzWTykieWYO6jQOLpStQG3wQU1k9bDrI2K1X6E7OVTqVJXA/qN9oGTEuaphsy+1sqqb+WpAl4TKEUx4yn/KtzIp8A==, signType=RSA2, bizContent={\"notify_context\":{\"trigger\":\"mrchiscore\",\"trigger_context\":{\"out_biz_no\":\"2020070620455448400097477\"}},\"detail\":{\"app_auth_token\":\"202007BBbf2c01e84b464234910c43ff65c54X09\",\"user_id\":\"2088222154382090\",\"re_expires_in\":32140800,\"auth_time\":1594040216726,\"app_refresh_token\":\"202007BBd81538093e464582934c51dfb9d18X09\",\"auth_app_id\":\"2021001172619424\",\"app_id\":\"2017042106866215\",\"expires_in\":31536000,\"app_auth_code\":\"aae0477c3c014c44b11b240fbebbbX09\"},\"error\":{}}";
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