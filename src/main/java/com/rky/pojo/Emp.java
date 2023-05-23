package com.rky.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer personId;
    private String name;
    private String phone;
    private Integer departId;
    private Integer roomId;
    private String job;
    private String password;
    private String username;
    private Integer gender;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isRoot;


}
