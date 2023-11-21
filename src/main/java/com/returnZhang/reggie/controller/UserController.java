package com.returnZhang.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.returnZhang.reggie.common.R;
import com.returnZhang.reggie.entity.User;
import com.returnZhang.reggie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 发送短信验证码
     * @param user
     * @param session
     * @return
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg (@RequestBody User user, HttpSession session){
        String phone = user.getPhone();
        if(phone != null){
            session.setAttribute(phone,"1234");
            return R.success("短信发送成功");
        }
        return R.error("登录失败");
    }

    /**
     * 假登录
     * @param map
     * @return
     */
    @PostMapping("/login")
    public R<User> login (@RequestBody Map map, HttpSession session){
        String phone = map.get("phone").toString();
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone, phone);

        User user = userService.getOne(queryWrapper);
        if (user == null){
            user = new User();
            user.setPhone(phone);
            user.setStatus(1);
            userService.save(user);
        }
        session.setAttribute("user", user.getId());
        return R.success(user);
    }
}
