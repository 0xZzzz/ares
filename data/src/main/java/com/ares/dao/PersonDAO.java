package com.ares.dao;

import com.ares.model.Person;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author 0xZzzz
 */
public interface PersonDAO {

    /**
     * 主键查询
     *
     * @param id pk
     * @return person
     */
    @Select("select * from person where id = #{id}")
    Person getById(Long id);

    @Update("update person set name = #{name} where id = #{id}")
    int update(Person person);

}
