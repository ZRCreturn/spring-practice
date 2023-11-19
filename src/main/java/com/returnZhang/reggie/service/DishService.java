package com.returnZhang.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.returnZhang.reggie.dto.DishDto;
import com.returnZhang.reggie.entity.Dish;

public interface DishService extends IService<Dish> {
    //新增菜品，同时插入菜品对应的口味数据, 需要操作两张表
    public void saveWithFlavor(DishDto dishDto);
}
