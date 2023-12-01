package com.example.sl_tech.Entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@Builder
public class Form implements Serializable {
    private int form_id;
    private String form_content;
    private String form_file;
    private String form_user_email;
}
