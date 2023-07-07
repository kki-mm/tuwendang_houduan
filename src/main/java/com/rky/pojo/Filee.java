package com.rky.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filee {


    private Integer id;
    private String projectId;
    private Integer roomId;
    private String fileId;
    private String fileName;
    private String fileType;
    private String filePathSrc;
    private String filePathPdf;
    private String fileSizeSrc;
    private String fileSizePdf;
    private Integer version;
    private String uploadName;
    private LocalDateTime uploadTime;
    public Double creatorWorkHour;
    private Integer proofPerson;
    private Integer examinePerson;
    private Integer approvePerson;
    private Double proofPersonWorkHour;
    private Double examinePersonWorkHour;
    private Double approvePersonWorkHour;
    public Double difficultyDegree;
    public Double contributeDegree;
    private String documentType;
    private String fileDesc;
    private Integer isPublish;
    private Integer isGiveOut;

    private Double giveOutLife;
    private String note1;
    private String note2;
    private String note3;
    private Integer isApprove;

    private LocalDateTime updateTime;




}

