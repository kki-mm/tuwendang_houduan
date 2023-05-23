package com.rky.mapper;

import com.rky.pojo.Project;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectMapper {


    @Insert("insert into project (project_name, project_id, project_create, create_time, end_time, project_members, project_approves, document_type, contract_date, sale_manager, contract_money, design_manager, serve_person, deliver_way, order_unit, receive_unit, receive_address, arrive_station, mail, contact_people, contact_people_phone, fax, send_unit, send_condition, time_dy, time_sb, update_time) VALUES " +
            "(#{projectName},#{projectId},#{projectCreate},#{createTime},#{endTime},#{projectMembers},#{projectApproves},#{documentType},#{contractDate},#{saleManager},#{contractMoney},#{designManager},#{servePerson},#{deliverWay},#{orderUnit},#{receiveUnit},#{receiveAddress},#{arriveStation},#{mail},#{contactPeople},#{contactPeoplePhone},#{fax},#{sendUnit},#{sendCondition},#{timeDy},#{timeSb},#{updateTime})")
    void add(Project project);
}
