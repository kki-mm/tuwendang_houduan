package com.rky.pojo;

import com.aspose.cad.internal.C.T;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileApprovePerson {
    private Integer id;
    private String fileId;
    private Integer proofPerson;
    private Integer proofPersonStat;
    private Integer isViewProofPerson;
    private LocalDateTime proofPersonTime;
    private Integer examinePerson;
    private Integer examinePersonStat;
    private LocalDateTime examinePersonTime;
    private Integer isViewExaminePerson;
    private Integer approvePerson;
    private Integer approvePersonStat;
    private LocalDateTime approvePersonTime;
    private Integer isViewApprovePerson;
    private LocalDateTime updateTime;
    private String errorReason;
    private Integer isApprove;
}
