package com.example.sl_tech.Service;

import com.example.sl_tech.Entity.Form;
import com.example.sl_tech.Mapper.FormMapper;
import com.example.sl_tech.Service.Interface.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class FormServiceImpl implements FormService {
    @Autowired
    private FormMapper formMapper;
    @Value("D://java-program//SL_Tech//file//")
    private String file_path_prefix;
    @Override
    public int addForm(Form form) {
        int i = formMapper.addForm(form);
        return i;
    }



    @Override
    public String uploadFile(MultipartFile form_file,String user_email) throws IOException {
        String time = String.valueOf(new Date().getTime());
        String path = file_path_prefix+user_email+time;
        File file = new File(file_path_prefix+user_email+time);
//        if (!file.exists()){
//            file.mkdirs();
//        }
        form_file.transferTo(file);

        return path;
    }
}
