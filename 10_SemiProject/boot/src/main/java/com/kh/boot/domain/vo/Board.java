package com.kh.boot.domain.vo;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Board {

    private int boardNo;
    private String boardTitle;
    private String boardWriter;
    private String boardContent;
    private String originName;
    private String changeName;
    private int count;
    private int boardType;
    private String createDate;
    private String status;

    //사진게시판 추가 컬럼
    private String photoOriginName1;
    private String photoChangeName1;
    private String photoOriginName2;
    private String photoChangeName2;
    private String photoOriginName3;
    private String photoChangeName3;
    private String photoOriginName4;
    private String photoChangeName4;

}
