package com.rky.mapper;

import com.rky.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select * from depart")
    List<Dept> selectAll();
}
