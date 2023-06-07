package com.rky.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {
    private Integer id;
    private String projectId;
    private String roomId;
    private String fileId;
    private String fileName;
    private String fileType;
    private String filePathSrc;
    private String filePathPdf;
    private String fileSizeSrc;
    private String fileSizePdf;
    private Integer version;
    private String uploadName;
    private String uploadTime;
    private String folder;
    private Double creatorWorkHour;
    private Integer proofPerson;
    private Integer examinePerson;
    private Integer approvePerson;
    private Double proofPersonWorkHour;
    private Double examinePersonWorkHour;
    private Double approvePersonWorkHour;
    private Double difficultyDegree;
    private Double contributeDegree;
    private String documentType;
    private String fileDesc;
    private Integer isPublish;
    private Integer isGiveOut;

    private Double giveOutLife;
    private String note1;
    private String note2;
    private String note3;
    private Integer isApprove;



}
