package com.atguigu.springcloud.dao;


import com.atguigu.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper  //勿漏！！！！！
public interface DeptDao
{
    public boolean addDept(Dept dept);
    Dept findById(Long id);
    List<Dept> findAll();
}
