package com.rky.mapper;

import com.rky.pojo.ApprovePerson;
import com.rky.pojo.FileApprovePerson;
import com.rky.pojo.Filee;
import com.rky.pojo.Project;
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

   // void setFileApprMember(String fileId, List<Integer> approves);

    void setFileApprMember(String fileId, Integer proofPersonId, Integer examinePersonId, Integer approvePersonId);

    @Select("select id,proof_person,proof_person_stat,examine_person,examine_person_stat,approve_person,approve_person_stat from file_approve where file_id = #{fileId}")
    List<FileApprovePerson> selectAllFileApprovePerson(String fileId);


    //flag 1 proof 2 examine 3 approve
    void setFileAprrStat(String fileId, Integer flag, Integer result,String error_reason);

    @Update("update file_approve set is_approve = 1,update_time = now() where file_id = #{fileId} and create_time =(select time from (select MAX(create_time) as time from file_approve where file_id = #{fileId})as fat)")
    void setFileApprSucess(String fileId);


    //找到当前正在审批过程中的审批记录，并且返回审批人信息
    @Select("select id,person_1,person_1_stat,person_2,person_2_stat,person_3,person_3_stat,person_4,person_4_stat,person_5,person_5_stat from project_approve where project_id=#{projectId} and approve=0")
    ApprovePerson selectApprovePerson(String projectId);

    @Update("update project set is_approve = 1,update_time = NOW() where project_id = #{projectId}")
    void setProjectSucc(String projectId);

    @Update("update project_approve set approve = 2,update_time = NOW() where id = #{id}")
    void setProUnuse(Integer id);

    //得到最新的审批记录
    @Select("select id,person_1,person_1_stat,person_2,person_2_stat,person_3,person_3_stat,person_4,person_4_stat,person_5,person_5_stat,approve,error_reason,person_1_time,person_2_time,person_3_time,person_4_time,person_5_time,update_time from project_approve where project_id = #{projectId} and create_time = (select MAX(create_time) from project_approve where project_id = #{projectId})")
    ApprovePerson getLatestAppr(String projectId);

    @Select("update project_approve set error_reason = #{errorReason} where id = #{id}")
    void setErroReason(Integer id, String errorReason);

    @Select("select name from person where person_id = #{flag0}")
    String getUserNameByID(Integer flag0);

    @Select("select project_id from project_approve where approve=0 and (((person_1=#{personId})and (person_1_stat=2))or ((person_2=#{personId})and(person_2_stat=2))or ((person_3=#{personId})and(person_3_stat=2))or ((person_4=#{personId})and person_4_stat=2)or ((person_5=#{personId})and (person_5_stat=2)))")
    List<String> getNeedtoApprPro(Integer personId);

    List<Project> getProjectList(List<String> projects);

    List<ApprovePerson> getHaveApprPro(Integer personId);

    FileApprovePerson getFileApprovePartById(Integer personId, String fileId);
    @Select("select proof_person_stat from file_approve where file_id = #{fileId} and create_time = (select time from (select MAX(create_time) as time from file_approve where file_id = #{fileId})as fat)")
    Integer getProofStat(String fileId);
    @Select("select examine_person_stat from file_approve where file_id = #{fileId} and create_time = (select time from (select MAX(create_time) as time from file_approve where file_id = #{fileId})as fat)")
    Integer getExamineStat(String fileId);
    @Select("select approve_person_stat from file_approve where file_id = #{fileId} and create_time = (select time from (select MAX(create_time) as time from file_approve where file_id = #{fileId})as fat)")
    Integer getApproveStat(String fileId);

    @Update("update file_approve set is_view_proof_person = 1 where file_id = #{fileId} and create_time =(select time from (select MAX(create_time) as time from file_approve where file_id = #{fileId}) as fat)")
    void setProofView(String fileId);
    @Update("update file_approve set is_view_examine_person = 1 where file_id = #{fileId} and create_time = (select time from (select MAX(create_time) as time from file_approve where file_id = #{fileId})as fat)")
    void setExamineView(String fileId);
    @Update("update file_approve set is_view_approve_person = 1 where file_id = #{fileId} and create_time = (select time from (select MAX(create_time) as time from file_approve where file_id = #{fileId})as fat)")
    void setApproveView(String fileId);

    @Select("select * from file_approve where file_id = #{fileId} and create_time = (select time from (select MAX(create_time) as time from file_approve where file_id = #{fileId})as fat)")
    FileApprovePerson selectFileApproLatest(String fileId);

    @Update("update filee set is_approve = 1,update_time = now() where file_id = #{fileId} and upload_time = (select time from (select MAX(upload_time) as time from filee where file_id = #{fileId})as fat) and is_approve = 2")
    void setFileApprove(String fileId);

    @Update("update file_approve set is_approve = 2,update_time = now() where file_id = #{fileId} and create_time =(select time from (select MAX(create_time) as time from file_approve where file_id = #{fileId})as fat)")
    void setFileApprError(String fileId);

    @Select("select file_id from file_approve where is_approve=0 and (((proof_person=#{personId})and (proof_person_stat=2)and(is_view_proof_person=1))or ((examine_person=#{personId})and(examine_person_stat=2)and(is_view_examine_person=1))or ((approve_person=#{personId})and(approve_person_stat=2)and(is_view_approve_person=1)))")
    List<String> getNeedtoApprFileIds(Integer personId);

    List<Filee> getNeedtoApprFile(List<String> fileIdsList);

    @Select("select * from file_approve where ((proof_person = #{personId})and(proof_person_stat!=2))or ((examine_person = #{personId})and(examine_person_stat!=2))or((approve_person = #{personId})and(approve_person_stat!=2))")
    List<FileApprovePerson> getHaveApproFile(Integer personId);


    @Update("update filee set is_approve = 0,update_time = now() where file_id = #{fileId} and upload_time = (select time from (select MAX(upload_time) as time from filee where file_id = #{fileId})as fat) and is_approve = 2")
    void setFileError(String fileId);
}
