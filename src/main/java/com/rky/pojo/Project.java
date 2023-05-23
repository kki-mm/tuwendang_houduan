package com.rky.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private String projectName;
    private String projectId;
    private String projectCreate;
    private LocalDateTime createTime;
    private LocalDateTime endTime;
    private String projectMembers;
    private String projectApproves;
    private Integer isApprove; //这个如果不行就用boolen
    private String documentType;
    private LocalDateTime contractDate;
    private String saleManager;
    private Double contractMoney;  //先使用double 后续如果有问题可以改
    private String designManager;
    private String servePerson;
    private String deliverWay;
    private String orderUnit;
    private String receiveUnit;
    private String receiveAddress;
    private String arriveStation;
    private String mail;
    private String contactPeople;
    private String contactPeoplePhone;
    private String fax;
    private String sendUnit;
    private String sendCondition;
    private LocalDateTime timeDy;
    private LocalDateTime timeSb;
    private LocalDateTime updateTime;



}
