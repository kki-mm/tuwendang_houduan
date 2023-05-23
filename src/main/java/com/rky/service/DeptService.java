package com.rky.service;

import com.rky.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> selectAll();

    void updata(Dept dept);

    void add(Dept dept);
}
