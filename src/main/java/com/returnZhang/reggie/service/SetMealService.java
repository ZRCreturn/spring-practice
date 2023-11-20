package com.returnZhang.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.returnZhang.reggie.dto.SetmealDto;
import com.returnZhang.reggie.entity.Setmeal;

public interface SetMealService extends IService<Setmeal> {
    public void saveWithDish (SetmealDto setmealDto);
}
