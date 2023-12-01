package com.example.sl_tech.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.sl_tech.DTO.FormDetailDTO;
import com.example.sl_tech.Entity.Form;
import com.example.sl_tech.Mapper.FormMapper;
import com.example.sl_tech.Service.Interface.FormService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FormServiceImpl implements FormService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private FormMapper formMapper;
    @Value("D:\\java-program\\SL_Tech\\src\\main\\resources\\static\\public\\file\\")
    private String file_path_prefix;
    @Value(".txt")
    private String file_path_endfix;
    @Override
    public int addForm(Form form) {
        int i = formMapper.addForm(form);
        return i;
    }



    @Override
    public String uploadFile(MultipartFile form_file,String user_email) throws IOException {
        String time = String.valueOf(new Date().getTime());
        String path = file_path_prefix+user_email+time;
        File file = new File(file_path_prefix+user_email+time+file_path_endfix);
//        if (!file.exists()){
//            file.mkdirs();
//        }
        form_file.transferTo(file);

        return user_email+time+file_path_endfix;
    }

    @Override
    public List<Form> getAllForm(String user_email) {
        return formMapper.getAllForm(user_email);
    }

    @Override
    public List<FormDetailDTO> getFormDetails(int form_id) {
        List<FormDetailDTO> list = new ArrayList<>();
        String formDetails = formMapper.getFormDetails(form_id);

        JSONObject json = JSONObject.parseObject(formDetails);
        String quz = "question";
        String an = "answer";
        int i=0;
        do {
            FormDetailDTO detailDTO = new FormDetailDTO(json.getString("question"+i),json.getString("answer"+i));
            list.add(detailDTO);
            i++;
        }while (json.containsKey("question"+i));



        return list;
    }

    @Override
    public List<Form> searchForm(String form_title) {
        return formMapper.searchForm(form_title);
    }
}
