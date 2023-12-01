package com.example.sl_tech.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
public class Form implements Serializable {
    private int form_id;
    private String form_content;
    private String form_file; //存放地址
    private String form_user_email;

    public Form(String form_content, String form_file, String form_user_email) {
        this.form_content = form_content;
        this.form_file = form_file;
        this.form_user_email = form_user_email;
    }
}
