package com.ares.infrastructure.dal.mapper;

import com.ares.infrastructure.dal.entity.Person;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author 0xZzzz
 */
@CacheNamespace
public interface PersonDAO {

    /**
     * 主键查询
     *
     * @param id pk
     * @return person
     */
    @Select("select * from person where id = #{id}")
    Person getById(Long id);

    /**
     * 关联company
     *
     * @param id pk
     * @return person join company
     */
    @Select("select t1.*, t2.id as company_id, t2.id as \"company.id\", t2.name as \"company.name\" "
        + "from person t1 left join company t2 on t1.company_id = t2.id "
        + "where t1.id = #{id}")
    Person joinCompanyById(Long id);

    /**
     * 更新
     *
     * @param person row
     * @return effect rows
     */
    @Update("update person set name = #{name} where id = #{id}")
    int update(Person person);

}
