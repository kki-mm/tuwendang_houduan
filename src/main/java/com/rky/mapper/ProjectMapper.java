package com.rky.mapper;

import com.rky.pojo.Project;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectMapper {


    @Insert("insert into project ")   //等连接上数据库做联想操作再来写
    void add(Project project);
}
