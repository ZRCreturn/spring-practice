package com.returnZhang.reggie.controller;

import com.returnZhang.reggie.common.R;
import com.returnZhang.reggie.dto.SetmealDto;
import com.returnZhang.reggie.service.SetMealDishService;
import com.returnZhang.reggie.service.SetMealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 套餐管理
 */
@RestController
@Slf4j
@RequestMapping("/setmeal")
public class SetMealController {

    @Autowired
    private SetMealService setMealService;
    @Autowired
    private SetMealDishService setMealDishService;

    /**
     * 新增套餐
     * @param setmealDto
     * @return
     */
    @PostMapping
    public R<String> save (@RequestBody SetmealDto setmealDto){
        setMealService.saveWithDish(setmealDto);
        return R.success("新增套餐成功");
    }
}
