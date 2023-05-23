package com.rky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rky.mapper.EmpMapper;
import com.rky.pojo.Emp;
import com.rky.pojo.PageBean;
import com.rky.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public List<Emp> selectAll() {
        List<Emp> empList = empMapper.selectAll();
        return empList;
    }

    @Override
    public PageBean selectPage(Integer start, Integer pageSize) {
        PageHelper.startPage(start,pageSize);
        List<Emp> empList = empMapper.selectAll();
        Page<Emp> empPage = (Page<Emp>)empList;
        PageBean pageBean = new PageBean(empPage.getTotal(),empPage.getResult());
        return pageBean;
    }

    @Override
    public Emp login(Emp emp) {

        Emp e = empMapper.login(emp);
        return e;
    }
}
