package com.example.sl_tech.Service.Interface;

import com.example.sl_tech.DTO.FormDetailDTO;
import com.example.sl_tech.Entity.Form;
import com.example.sl_tech.Mapper.FormMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface FormService {
    int addForm(Form form);
    String uploadFile(MultipartFile form_file,String user_email) throws IOException;

    List<Form> getAllForm(String user_email);

    List<FormDetailDTO> getFormDetails(int form_id);
    List<Form> searchForm(String form_title);
}
