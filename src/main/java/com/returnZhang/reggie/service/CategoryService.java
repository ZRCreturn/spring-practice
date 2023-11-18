package com.returnZhang.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.returnZhang.reggie.entity.Category;


public interface CategoryService extends IService<Category> {
    public void remove (Long id);
}
