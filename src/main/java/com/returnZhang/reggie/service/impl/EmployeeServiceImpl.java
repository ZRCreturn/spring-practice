package com.returnZhang.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.returnZhang.reggie.entity.Employee;
import com.returnZhang.reggie.mapper.EmployedMapper;
import com.returnZhang.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployedMapper, Employee> implements EmployeeService {

}
