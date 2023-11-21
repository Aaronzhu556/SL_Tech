package com.example.sl_tech.Controller;

import com.example.sl_tech.DTO.UserDTO;
import com.example.sl_tech.Entity.User;
import com.example.sl_tech.Response.MyResponse;
import com.example.sl_tech.Service.Interface.AuthService;
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
    public void userLogin(@RequestBody UserDTO userDTO){

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
