package com.returnZhang.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.returnZhang.reggie.entity.Orders;
import com.returnZhang.reggie.mapper.OrderMapper;
import com.returnZhang.reggie.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders> implements OrderService {
}
