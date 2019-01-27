package com.ares.service.test;

import com.ares.common.utils.SpringContextUtils;

/**
 * 测试工具类
 *
 * @author 0xZzzz
 * @since 2019/01/27
 */
public class TestUtils {

    public static TestBean testBean = SpringContextUtils.getBean(TestBean.class);

    public static void test() {
        testBean.test();
    }

}
