package com.rky.service;

import com.rky.pojo.Emp;
import com.rky.pojo.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmpService {
    List<Emp> selectAll();

    PageBean selectPage(Integer start, Integer pageSize);

    Emp login(Emp emp);
}
