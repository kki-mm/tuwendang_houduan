package com.rky.mapper;

import com.rky.pojo.Project;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProjectMapper {


    @Insert("insert into project (project_name, project_id, project_create, create_time, end_time, project_members, project_approves, document_type, contract_date, sale_manager, contract_money, design_manager, serve_person, deliver_way, order_unit, receive_unit, receive_address, arrive_station, mail, contact_people, contact_people_phone, fax, send_unit, send_condition, time_dy, time_sb, update_time) VALUES " +
            "(#{projectName},#{projectId},#{projectCreate},#{createTime},#{endTime},#{projectMembers},#{projectApproves},#{documentType},#{contractDate},#{saleManager},#{contractMoney},#{designManager},#{servePerson},#{deliverWay},#{orderUnit},#{receiveUnit},#{receiveAddress},#{arriveStation},#{mail},#{contactPeople},#{contactPeoplePhone},#{fax},#{sendUnit},#{sendCondition},#{timeDy},#{timeSb},#{updateTime})")
    void add(Project project);

    @Select("select * from project")
    List<Project> selectAll();


    List<Project> selectClass(Integer classId);

    @Update("update project set project_name=#{projectName},project_id=#{projectId},project_create=#{projectCreate},project_members=#{projectMembers},project_approves=#{projectApproves},document_type=#{documentType},contract_date=#{contractDate},sale_manager=#{saleManager},contract_money=#{contractMoney},design_manager=#{designManager},serve_person=#{servePerson},deliver_way=#{deliverWay},order_unit=#{orderUnit},receive_unit=#{receiveUnit},receive_address=#{receiveAddress},arrive_station=#{arriveStation},mail=#{mail},contact_people=#{contactPeople},contact_people_phone=#{contactPeoplePhone},fax=#{fax},send_unit=#{sendUnit},send_condition=#{sendCondition},time_dy=#{timeDy},time_sb=#{timeSb},update_time=#{updateTime} where project_id = #{projectId}")
    void update(Project project);

    void delete(List<Integer> ids);
}
