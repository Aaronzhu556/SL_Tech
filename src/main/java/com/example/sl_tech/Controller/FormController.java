package com.example.sl_tech.Controller;

import com.example.sl_tech.DTO.FormDTO;
import com.example.sl_tech.Entity.Form;
import com.example.sl_tech.Response.MyResponse;
import com.example.sl_tech.Service.Interface.FormService;
import com.example.sl_tech.Utils.JwtUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/form")
public class FormController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private FormService formService;
    @RequestMapping("/addform")
    @ResponseBody
    public MyResponse addForm(@RequestParam("form_title")String form_title,@RequestParam("form_content") String form_content,@RequestParam("form_file") MultipartFile form_file, @RequestHeader("Authorization")String token) throws IOException {
        if (JwtUtil.verifyToken(token)){
            String file_path = formService.uploadFile(form_file, JwtUtil.getInfoFromToken(token));
            formService.addForm(new Form(form_title,form_content,file_path,JwtUtil.getInfoFromToken(token)));

            logger.info(form_content);
            return MyResponse.builder().res_code("200").res_msg("添加表单成功").res_object(null).build();

        }
        return MyResponse.builder().res_code("201").res_msg("添加表单失败，token验证不通过").res_object(null).build();
    }
    @RequestMapping("/getallform")
    @ResponseBody
    public MyResponse getAllForm(@RequestHeader("Authorization")String token){

        if (JwtUtil.verifyToken(token)){
            List<Form> formList = formService.getAllForm(JwtUtil.getInfoFromToken(token));
            return MyResponse.builder().res_code("200").res_msg("查询成功").res_object(formList).build();
        }
        return MyResponse.builder().res_code("201").res_msg("查询失败，token验证失败").res_object(null).build();
    }
}
