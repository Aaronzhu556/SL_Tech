package com.example.sl_tech.Mapper;

import com.example.sl_tech.Entity.Form;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FormMapper {
    List<Form> getAllForm(String user_email);
    int addForm(Form form);
    String getFormDetails(int form_id);
    List<Form> searchForm(String form_title);
}
