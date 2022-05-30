package com.ares.service;

import org.apache.commons.lang3.StringUtils;

/**
 * @author fansheng
 * @date 2022/5/30
 */
public class Main {

    public static void main(String[] args) {
        String str = "1,2，3,4，5";
        System.out.println(StringUtils.split(str, ",，").length);
    }

}
