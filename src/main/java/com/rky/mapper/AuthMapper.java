package com.rky.mapper;

import com.rky.pojo.ApprovePerson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AuthMapper {
    void insert(@Param("projectId") String projectId, List<Integer> approveIds);

    void updataStat(String projectId, Integer result,Integer personFlag,Integer id);

    @Select("select id,person_1,person_1_stat,person_2,person_2_stat,person_3,person_3_stat,person_4,person_4_stat,person_5,person_5_stat from project_approve where project_id = #{projectId} order by id asc")
    List<ApprovePerson> selectAllPerson(String projectId);

    @Select("select id,person_1_stat,person_2_stat,person_3_stat,person_4_stat,person_5_stat from project_approve where id = #{id}")
    ApprovePerson getByIdProject(Integer id);

    @Update("update project_approve set approve = 1,update_time = now() where id = #{id}")
    void setProAutSuss(Integer id);

    @Select("select depart_id from depart where depart_name = #{departName}")
    Integer getRoomIdByName(String departName);

    @Select("select count(*) from project_person where project_id=#{projectId} and person_id=#{personId}")
    Integer isProjectMember(Integer personId, String projectId);
}
