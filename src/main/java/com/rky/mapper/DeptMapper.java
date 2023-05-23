package com.rky.mapper;

import com.rky.pojo.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select * from depart")
    List<Dept> selectAll();

    @Update("update depart set depart_name = #{departName} ,update_time = #{updateTime} where depart_id = #{departId}")
    void updata(Dept dept);

    @Insert("insert into depart (depart_id,depart_name,create_time,update_time)values (#{departId},#{departName},#{createTime},#{updateTime})")
    void add(Dept dept);
}
