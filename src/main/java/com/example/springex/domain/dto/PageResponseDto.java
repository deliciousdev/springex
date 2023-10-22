package com.example.springex.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;



@ToString
@Data
public class PageResponseDto<E> {

    private int page;
    private int pageSize;

    private final int NAVI_SIZE=10;
    private int total; //db 테이블 데이터 총개수 : count(*)

    private int startOnNavi;
    private int endOnNavi;

    private boolean prev;
    private boolean next;

    private List<E> articleDtoList;

    @Builder(builderMethodName="withAll")
    public PageResponseDto(PageRequestDto pageRequestDto, List<E> articleDtoList, int total) {
        this.page= pageRequestDto.getPage();
        this.pageSize = pageRequestDto.getSize();

        this.articleDtoList=articleDtoList;
        this.total=total;

        int tempEndOnNavi = (int)Math.ceil((this.page / (double) NAVI_SIZE) )* NAVI_SIZE;
        int lastOnNavi = (int)(Math.ceil(total / (double) pageSize));

        this.endOnNavi = Math.min(tempEndOnNavi, lastOnNavi);
        this.startOnNavi = endOnNavi - (NAVI_SIZE-1);

        this.prev = this.startOnNavi>1;
        this.next = total > this.endOnNavi * this.pageSize;
    }








}
