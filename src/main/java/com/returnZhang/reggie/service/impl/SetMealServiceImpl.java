package com.returnZhang.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.returnZhang.reggie.entity.Setmeal;
import com.returnZhang.reggie.mapper.SetMealMapper;
import com.returnZhang.reggie.service.SetMealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SetMealServiceImpl extends ServiceImpl<SetMealMapper, Setmeal> implements SetMealService {
}
