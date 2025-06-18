package com.kh.boot.controller;

import com.kh.boot.domain.vo.Board;
import com.kh.boot.domain.vo.Member;
import com.kh.boot.domain.vo.PageInfo;
import com.kh.boot.service.BoardService;
import com.kh.boot.utils.Template;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

import static com.kh.boot.utils.Template.saveFile;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("list.bo")
    public String selectBoardList(@RequestParam(defaultValue = "1") int cpage, Model model) {
        int boardCount = boardService.selectBoardCount();

        PageInfo pi = new PageInfo(boardCount, cpage, 10, 5);
        ArrayList<Board> list = boardService.selectBoardList(pi);

        model.addAttribute("list", list);
        model.addAttribute("pi", pi);
        return "board/boardListView";
    }

    @GetMapping("enrollForm.bo")
    public String enrollForm() {
        return "board/boardEnrollForm";
    }

    @PostMapping("insert.bo")
    public String insertBoard(@ModelAttribute Board board, MultipartFile upfile, HttpSession session, Model model) {
        System.out.println(board);
        System.out.println(upfile);

        if (!upfile.getOriginalFilename().equals("")) {
            String changeName = saveFile(upfile, session, "/resources/uploadfile/");

            board.setChangeName("/resources/uploadfile/" + changeName);
            board.setOriginName(upfile.getOriginalFilename());
        }

        int result = boardService.insertBoard(board);
        if (result > 0) {
            session.setAttribute("alertMsg", "게시글 작성 성공");
            return "redirect:/list.bo";
        } else {
            model.addAttribute("errorMsg", "게시글 작성 실패");
            return "common/errorPage";
        }
    }

    @GetMapping("detail.bo")
    public String selectBoardDetail(int bno, Model model) {
        int result = boardService.increaseCount(bno);
        if (result > 0) {
            Board b = boardService.selectBoard(bno);
            model.addAttribute("b", b);

            return "board/boardDetailView";
        } else {
            model.addAttribute("errorMsg", "게시글 조회 실패");
            return "common/errorPage";
        }

    }

    @GetMapping("updateForm.bo")
    public String updateForm(int bno, Model model) {
        Board b = boardService.selectBoard(bno);
        model.addAttribute("b", b);
        return "board/boardUpdateForm";
    }

    @PostMapping("update.bo")
    public String updateBoard(@ModelAttribute Board b, HttpSession session, Model model) {
        int result = boardService.updateBoard(b);
        if (result > 0) {
            session.setAttribute("alertMsg", "게시글 수정 성공!");
            Board updatedBoard = boardService.selectBoard(b.getBoardNo());
            model.addAttribute("b", updatedBoard);
            return "board/boardDetailView";
        } else {
            model.addAttribute("errorMsg", "게시글 수정이 실패하였습니다.");
            return "board/boardUpdateForm";
        }


    }

    @GetMapping("photo.bo")
    public String selectPhotoBoard(@RequestParam(defaultValue = "1") int cpage, Model model) {
        int photoCount = boardService.selectPhotoCount();

        PageInfo pi = new PageInfo(photoCount, cpage, 10, 5);
        ArrayList<Board> photoList = boardService.selectPhotoList(pi);
        model.addAttribute("photoList", photoList);
        model.addAttribute("pi", pi);
        return "board/thumbnailListView";
    }

    @GetMapping("photoUpload.bo")
    public String photoUpload() {
        return "board/photoEnrollForm";
    }

    @PostMapping("insertPhoto.bo")
    public String insertPhotoBoard(@ModelAttribute Board board,
                                   @RequestParam(value = "photoFile1", required = false) MultipartFile photoFile1,
                                   @RequestParam(value = "photoFile2", required = false) MultipartFile photoFile2,
                                   @RequestParam(value = "photoFile3", required = false) MultipartFile photoFile3,
                                   @RequestParam(value = "photoFile4", required = false) MultipartFile photoFile4,
                                   HttpSession session, Model model) {

        Member loginUser = (Member) session.getAttribute("loginUser");
        String loggedInUserId = (loginUser != null) ? loginUser.getUserId() : "defaultId";

        board.setBoardWriter(loggedInUserId);

        String uploadPath = "/resources/uploadfile/";

        if (photoFile1 != null && !photoFile1.isEmpty()) {
            String changeName1 = Template.saveFile(photoFile1, session, uploadPath);
            board.setPhotoChangeName1(uploadPath + changeName1);
            board.setPhotoOriginName1(photoFile1.getOriginalFilename());
        } else {
            board.setPhotoChangeName1("");  // 빈 문자열 설정
            board.setPhotoOriginName1("");
        }
        if (photoFile2 != null && !photoFile2.isEmpty()) {
            String changeName2 = Template.saveFile(photoFile2, session, uploadPath);
            board.setPhotoChangeName2(uploadPath + changeName2);
            board.setPhotoOriginName2(photoFile2.getOriginalFilename());
        } else {
            board.setPhotoChangeName2("");  // 빈 문자열 설정
            board.setPhotoOriginName2("");
        }
        if (photoFile3 != null && !photoFile3.isEmpty()) {
            String changeName3 = Template.saveFile(photoFile3, session, uploadPath);
            board.setPhotoChangeName3(uploadPath + changeName3);
            board.setPhotoOriginName3(photoFile3.getOriginalFilename());
        } else {
            board.setPhotoChangeName3("");  // 빈 문자열 설정
            board.setPhotoOriginName3("");
        }
        if (photoFile4 != null && !photoFile4.isEmpty()) {
            String changeName4 = Template.saveFile(photoFile4, session, uploadPath);
            board.setPhotoChangeName4(uploadPath + changeName4);
            board.setPhotoOriginName4(photoFile4.getOriginalFilename());
        } else {
            board.setPhotoChangeName4("");  // 빈 문자열 설정
            board.setPhotoOriginName4("");
        }
        int result = boardService.insertPhotoBoard(board);


        if (result > 0) {
            session.setAttribute("alertMsg", "사진 게시글 작성 성공");
            return "redirect:/photo.bo";
        } else {
            model.addAttribute("errorMsg", "사진 게시글 작성 실패");
            return "common/errorPage";
        }
    }

    @GetMapping("detailPhoto.bo")
    public String selectPhotoDetail(int bno, Model model) {
        int result = boardService.increaseCount(bno);
        if (result > 0) {
            Board b = boardService.selectPhoto(bno);
            System.out.println(b);
            model.addAttribute("b", b);
            return "board/photoDetailView";
        } else {
            model.addAttribute("errorMsg", "사진게시글 조회 실패");
            return "common/errorPage";
        }

    }

    @PostMapping("updatePhoto.bo")
    public String updatePhoto(){
        return "board/photoUpdateForm";
    }



}
