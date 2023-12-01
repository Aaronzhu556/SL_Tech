package com.example.sl_tech.Service.Interface;

import com.example.sl_tech.Entity.Form;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface FormService {
    int addForm(Form form);
    String uploadFile(MultipartFile form_file,String user_email) throws IOException;

    List<Form> getAllForm(String user_email);
}
