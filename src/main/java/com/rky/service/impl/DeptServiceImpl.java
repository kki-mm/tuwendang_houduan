package com.rky.service.impl;

import com.rky.mapper.DeptMapper;
import com.rky.pojo.Dept;
import com.rky.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;

    @Override
    public List<Dept> selectAll() {
        List<Dept>depts = deptMapper.selectAll();
        return depts;
    }

    @Override
    public void updata(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updata(dept);
    }

    @Override
    public void add(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        dept.setCreateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }
}
