package com.rky.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer departId;
    private String departName;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
}
