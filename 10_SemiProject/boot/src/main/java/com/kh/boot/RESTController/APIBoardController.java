package com.kh.boot.RESTController;

import com.kh.boot.domain.vo.Board;
import com.kh.boot.domain.vo.Reply;
import com.kh.boot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class APIBoardController {

    private final BoardService boardService;


    @PostMapping("/reply")
    public String insertReply(Reply r) {
     return boardService.insertReply(r) > 0 ? "success" : "fail";
    }

    @GetMapping("/replyList")
    public ArrayList<Reply> selectReplyList(int bno) {
        return boardService.selectReplyList(bno);
    }

    @GetMapping(value ="/topn", produces = "application/json; charset=UTF-8")
    public ArrayList<Board> selectTopList() {
        return boardService.selectTopList();
    }
}
