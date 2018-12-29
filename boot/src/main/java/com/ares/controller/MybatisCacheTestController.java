package com.ares.controller;

import com.ares.dao.CompanyDAO;
import com.ares.dao.PersonDAO;
import com.ares.model.Company;
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
@RequestMapping("/mybatis/cache")
public class MybatisCacheTestController {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/level1")
    public String level1() {

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        PersonDAO personDAO1 = sqlSession1.getMapper(PersonDAO.class);
        Person person1 = personDAO1.getById(1L);
        System.err.println("sqlSession1 query：" + person1);

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        PersonDAO personDAO2 = sqlSession2.getMapper(PersonDAO.class);
        System.err.println("sqlSession2 query：" + personDAO2.getById(1L));

        person1.setName("lia");
        personDAO1.update(person1);
        System.err.println("sqlSession1 update：" + personDAO1.getById(1L));

        System.err.println("sqlSession2 query： " + personDAO2.getById(1L));

        return "OK";
    }

    @RequestMapping("/level2")
    public String level2() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CompanyDAO companyDAO = sqlSession.getMapper(CompanyDAO.class);
        Company company = companyDAO.getById(1L);
        sqlSession.commit();
        System.err.println("CompanyDAO query company：" + company);

        PersonDAO personDAO = sqlSession.getMapper(PersonDAO.class);
        Person person = personDAO.joinCompanyById(1L);
        sqlSession.commit();
        System.err.println("PersonDAO query person join company：" + person);

        company.setName("B");
        companyDAO.update(company);
        sqlSession.commit();
        System.err.println("CompanyDAO update company：" + companyDAO.getById(1L));

        System.err.println("PersonDAO query person join company：" + personDAO.joinCompanyById(1L));
        sqlSession.commit();

        return "OK";
    }

}
