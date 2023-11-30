package com.example.sl_tech.Controller;

import com.example.sl_tech.Response.MyResponse;
import com.example.sl_tech.Utils.JwtUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/form")
public class FormController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/addform")
    @ResponseBody
    public MyResponse addForm(@RequestBody String str, @RequestHeader("Authorization")String token){
        if (JwtUtil.verifyToken(token)){

            logger.info(str);

        }
        return null;
    }
}
