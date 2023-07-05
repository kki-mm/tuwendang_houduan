package com.rky.mapper;

import com.rky.pojo.Filee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.io.File;

@Mapper
//暂时未上传两种文件大小
public interface UploadMapper {
    @Insert("insert into filee (project_id,room_id,file_id,file_name,file_type,file_path_src,file_path_pdf,file_size_src,version,upload_name,upload_time,creator_work_hour,proof_person,examine_person,approve_person,proof_person_work_hour,examine_person_work_hour,approve_person_work_hour,difficulty_degree,contribute_degree,document_type,file_desc,is_publish,is_give_out,give_out_life,note_1,note_2,note_3,is_approve,update_time)" +
            "values (#{projectId},#{roomId},#{fileId},#{fileName},#{fileType},#{filePathSrc},#{filePathPdf},#{fileSizeSrc},#{version},#{uploadName},#{uploadTime},#{creatorWorkHour},#{proofPerson},#{examinePerson},#{approvePerson},#{proofPersonWorkHour},#{examinePersonWorkHour},#{approvePersonWorkHour},#{difficultyDegree},#{contributeDegree},#{documentType},#{fileDesc},#{isPublish},#{isGiveOut},#{giveOutLife},#{note1},#{note2},#{note3},#{isApprove},#{updateTime})")
    void add(Filee filee);

}
