package com.example.springex.domain.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class TestDto {

    private String stringParam;
    private int intParam;
    private LocalDate localDateParam;
    private boolean booleanParam;
}
