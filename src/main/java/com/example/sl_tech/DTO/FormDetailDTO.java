package com.example.sl_tech.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class FormDetailDTO implements Serializable {
    private String question;
    private String answer;
}
