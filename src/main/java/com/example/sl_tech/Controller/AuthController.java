package com.example.sl_tech.Controller;

import com.example.sl_tech.DTO.UserDTO;
import com.example.sl_tech.Entity.User;
import com.example.sl_tech.Response.MyResponse;
import com.example.sl_tech.Service.Interface.AuthService;
import com.example.sl_tech.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @RequestMapping("/login")
    @ResponseBody
    public MyResponse userLogin(@RequestBody UserDTO userDTO){
        Integer code = authService.userLogin(userDTO);
        if (code==200){
            String token = JwtUtil.createToken(userDTO.getUser_email()); //可以再考虑token的过期问题，最后写
            return MyResponse.builder().res_code(String.valueOf(code)).res_msg("登录成功").res_object(token).build();
        }
        else if (code==201) return MyResponse.builder().res_code(String.valueOf(code)).res_code("登录失败，密码错误").res_object(null).build();
        else if (code==202) return MyResponse.builder().res_code(String.valueOf(code)).res_msg("登录失败，用户不存在").res_object(null).build();
        else if (code==203) return MyResponse.builder().res_code(String.valueOf(code)).res_msg("验证码错误").res_object(null).build();
        else  return MyResponse.builder().res_code("204").res_msg("登录出错").res_object(null).build();
    }

    @ResponseBody
    @RequestMapping("/getcaptcha")
    public MyResponse getCaptcha(@RequestParam String user_email){
        String captcha = authService.getCaptcha(user_email);
        return MyResponse.builder()
                .res_code("200")
                .res_msg("获取验证码成功")
                .res_object(captcha).build();

    }
}
