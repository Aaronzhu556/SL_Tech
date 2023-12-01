package com.example.sl_tech.Controller;

import com.example.sl_tech.DTO.FormDTO;
import com.example.sl_tech.Response.MyResponse;
import com.example.sl_tech.Utils.JwtUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/form")
public class FormController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/addform")
    @ResponseBody
    public MyResponse addForm(@RequestParam("form_content") String form_content,@RequestParam("form_file") MultipartFile form_file, @RequestHeader("Authorization")String token){
        if (JwtUtil.verifyToken(token)){
   
            logger.info(form_content);


        }
        return null;
    }
}
