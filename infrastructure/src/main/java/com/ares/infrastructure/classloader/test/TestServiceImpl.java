package com.ares.infrastructure.classloader.test;

import com.ares.service.test.TestService;
import org.springframework.stereotype.Service;

/**
 * 测试服务
 *
 * @author 0xZzzz
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public String test(String str) {
        return str;
    }

}
