package com.rky.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovePerson {
    private Integer id;
    private String projectId;
    private Integer person1;
    private Integer person1Stat;
    private LocalDateTime person1Time;
    private Integer person2;
    private Integer person2Stat;
    private LocalDateTime person2Time;
    private Integer person3;
    private Integer person3Stat;
    private LocalDateTime person3Time;
    private Integer person4;
    private Integer person4Stat;
    private LocalDateTime person4Time;
    private Integer person5;
    private Integer person5Stat;
    private LocalDateTime person5Time;
    private Integer approve;
    private String  errorReason;
    private LocalDateTime updateTime;
}
