package com.kh.boot.service;

import com.kh.boot.domain.vo.Board;
import com.kh.boot.domain.vo.PageInfo;
import com.kh.boot.domain.vo.Reply;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface BoardService {
    //총게시글 수
    int selectBoardCount();

    //게시글정보(페이징)
    ArrayList<Board> selectBoardList(PageInfo pi);
    
    //게시글 추가
    int insertBoard(Board board);
    
    //게시글 가져오기
    int increaseCount(int boardNo);

    //게시글 가져오기
    Board selectBoard(int boardNo);

    //댓글 추가
    int insertReply(Reply reply);

    ArrayList<Reply> selectReplyList(int bno);

    int updateBoard(Board b);

    ArrayList<Board> selectTopList();

    int insertPhotoBoard(Board board);

    int selectPhotoCount();

    ArrayList<Board> selectPhotoList(PageInfo pi);

    Board selectPhoto(int bno);
}
