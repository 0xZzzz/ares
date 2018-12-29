package com.ares.controller;

import com.ares.dao.PersonDAO;
import com.ares.model.Person;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mybatis 缓存测试
 *
 * @author 0xZzzz
 */
@RestController
public class MybatisCacheTestController {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/cache/test")
    public String test() {

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        PersonDAO personDAO1 = sqlSession1.getMapper(PersonDAO.class);
        Person person1 = personDAO1.getById(1L);
        System.err.println("sqlSession1 query  ------ " + person1);

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        PersonDAO personDAO2 = sqlSession2.getMapper(PersonDAO.class);
        System.err.println("sqlSession2 query  ------ " + personDAO2.getById(1L));

        person1.setName("mike");
        personDAO1.update(person1);
        System.err.println("sqlSession1 update ------ " + personDAO1.getById(1L));

        System.err.println("sqlSession2 query  ------ " + personDAO2.getById(1L));

        return "OK";
    }

}
