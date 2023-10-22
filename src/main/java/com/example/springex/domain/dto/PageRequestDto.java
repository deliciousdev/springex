package com.example.springex.domain.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDto {

    private int page=1;
    private int size=10;

    public int getSkip(){
        return (page-1)*size;
    }

    public static PageRequestDto of(int page, int size){
        return new PageRequestDto(page,size);
    }

    public static PageRequestDto of(){
        return new PageRequestDto();
    }

    public static PageRequestDto of(int page){
        return new PageRequestDto(page,10);
    }


}
