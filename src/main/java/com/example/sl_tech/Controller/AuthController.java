package com.example.sl_tech.Controller;

import com.example.sl_tech.DTO.UserDTO;
import com.example.sl_tech.Entity.User;
import com.example.sl_tech.Response.MyResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping("/login")
    @ResponseBody
    public MyResponse userLogin(@RequestBody UserDTO userDTO){

    }
}
