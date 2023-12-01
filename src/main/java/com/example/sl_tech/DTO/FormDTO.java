package com.example.sl_tech.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class FormDTO implements Serializable {
    private String form_content;
    private MultipartFile form_file;

}
