package com.returnZhang.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.returnZhang.reggie.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.core.annotation.Order;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
