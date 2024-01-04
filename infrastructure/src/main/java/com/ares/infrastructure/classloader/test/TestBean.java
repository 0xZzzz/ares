package com.ares.infrastructure.classloader.test;

import org.springframework.stereotype.Service;

/**
 * 测试bean
 *
 * @author 0xZzzz
 * @since 2019/01/27
 */
@Service
public class TestBean {

    public TestBean() {
        System.err.println("TestBean init");
    }

    public void test() {
        System.err.println("test invoke");
    }

    @Override
    public String toString() {
        return "TestBean toString";
    }
}
