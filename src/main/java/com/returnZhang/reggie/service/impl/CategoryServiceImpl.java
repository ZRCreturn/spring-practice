package com.returnZhang.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.returnZhang.reggie.entity.Category;
import com.returnZhang.reggie.entity.Dish;
import com.returnZhang.reggie.entity.Setmeal;
import com.returnZhang.reggie.mapper.CategoryMapper;
import com.returnZhang.reggie.service.CategoryService;
import com.returnZhang.reggie.service.DishService;
import com.returnZhang.reggie.service.SetMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private DishService dishService;
    @Autowired
    private SetMealService setMealService;
    /**
     * 根据id删除分类，不能删除已经关联菜品的分类
     * @param id
     */
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);
        int count = dishService.count(dishLambdaQueryWrapper);

        if(count > 0){
            //已经关联了菜品,抛出业务异常
        }

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        int count2 = setMealService.count(setmealLambdaQueryWrapper);
        if(count > 0){
            //已经关联了套餐,抛出业务异常
        }

        super.removeById(id);
    }
}
