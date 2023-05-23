package com.rky.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private Integer roomId;
    private String roomName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
