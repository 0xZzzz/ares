package com.ares.infrastructure.dal.mapper;

import com.ares.infrastructure.dal.entity.Company;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author 0xZzzz
 */
@CacheNamespace
public interface CompanyDAO {

    /**
     * 主键查询
     *
     * @param id pk
     * @return row
     */
    @Select("select * from company where id = #{id}")
    Company getById(Long id);

    /**
     * 更新
     *
     * @param company row
     * @return effect rows
     */
    @Update("update company set name = #{name} where id = #{id}")
    int update(Company company);

}
