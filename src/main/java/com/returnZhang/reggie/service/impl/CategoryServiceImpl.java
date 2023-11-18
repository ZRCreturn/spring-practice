package com.returnZhang.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.returnZhang.reggie.entity.Category;
import com.returnZhang.reggie.mapper.CategoryMapper;
import com.returnZhang.reggie.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
