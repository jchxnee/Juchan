package com.kh.boot.service;

import com.kh.boot.domain.vo.Board;
import com.kh.boot.domain.vo.PageInfo;
import com.kh.boot.domain.vo.Reply;
import com.kh.boot.mappers.BoardMapper;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;



    @Override
    public int selectBoardCount() {
        return boardMapper.selectBoardCount();
    }

    @Override
    public ArrayList<Board> selectBoardList(PageInfo pi) {
        int offset = (pi.getCurrentPage() -1) * pi.getBoardLimit();
        RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
        return boardMapper.selectBoardList(rowBounds);
    }

    @Override
    public int insertBoard(Board board) {
        return boardMapper.insertBoard(board);
    }

    @Override
    public int increaseCount(int boardNo) {
        return boardMapper.increaseCount(boardNo);
    }

    @Override
    public Board selectBoard(int boardNo) {
        return boardMapper.selectBoard(boardNo);
    }

    @Override
    public int insertReply(Reply reply) {
        return boardMapper.insertReply(reply);
    }

    @Override
    public ArrayList<Reply> selectReplyList(int bno) {
        return boardMapper.selectReplyList(bno);
    }

    @Override
    public int updateBoard(Board b) {
        return boardMapper.updateBoard(b);
    }

    @Override
    public ArrayList<Board> selectTopList() {
        RowBounds rowBounds = new RowBounds(0, 5);
        return boardMapper.selectTopList(rowBounds);
    }

    @Override
    public int insertPhotoBoard(Board board) {
        return boardMapper.insertPhotoBoard(board);
    }

    @Override
    public int selectPhotoCount() {
        return boardMapper.selectPhotoCount();
    }

    public ArrayList<Board> selectPhotoList(PageInfo pi) {
        int offset = (pi.getCurrentPage() -1) * pi.getBoardLimit();
        RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
        return boardMapper.selectPhotoList(rowBounds);
    }

    @Override
    public Board selectPhoto(int bno) {
        return boardMapper.selectPhoto(bno);
    }


}



