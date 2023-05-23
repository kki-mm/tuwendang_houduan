package com.rky.mapper;

import com.rky.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select * from person")
    List<Emp> selectAll();

    @Select("select * from person where username = #{username} and password = #{password}")
    Emp login(Emp emp);
}
