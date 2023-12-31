package com.returnZhang.reggie.dto;

import com.returnZhang.reggie.entity.Setmeal;
import com.returnZhang.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
