package com.ares.biz.service.test;

import com.ares.api.service.test.TestService;
import org.springframework.stereotype.Service;

/**
 * 测试服务
 *
 * @author 0xzzzz
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public String test() {
        return "test";
    }

}
