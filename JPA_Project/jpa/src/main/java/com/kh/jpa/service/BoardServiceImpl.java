package com.kh.jpa.service;

import com.kh.jpa.dto.BoardDto;
import com.kh.jpa.entity.Board;
import com.kh.jpa.entity.BoardTag;
import com.kh.jpa.entity.Member;
import com.kh.jpa.entity.Tag;
import com.kh.jpa.enums.CommonEnums;
import com.kh.jpa.repository.BoardRepositoryV2;
import com.kh.jpa.repository.BoardRespository;
import com.kh.jpa.repository.MemberRepository;
import com.kh.jpa.repository.TagRepository;
import jakarta.persistence.EntityNotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService {

//    private final BoardRespository boardRespository;
    private final BoardRepositoryV2 boardRespository;
    private final MemberRepository memberRepository;
    private final TagRepository tagRepository;
    private final String UPLOAD_PATH = "C:\\dev_tool";

    @Override
    public Page<BoardDto.Response> getBoardList(Pageable pageable) {

//        Page<Board> page = boardRespository.findByStatus(CommonEnums.Status.Y, pageable);
//
//        return page.map(BoardDto.Response::toSimpleDto);
        return null;
    }

    @Override
    public BoardDto.Response getBoardDetail(Long boardNo) {
        Board board = boardRespository.findById(boardNo)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));

        return BoardDto.Response.toDto(board);
    }

    @Transactional
    @Override
    public Long createBoard(BoardDto.Create createBoard) throws IOException {
        //게시글작성
        //작성자 찾기 -> 객체지향코드를 작성할 것이기때문에 key를 직접 외래키로 insert하지않고
        //작성자를 찾아 참조해준다.

        Member member = memberRepository.findOne(createBoard.getUser_id())
                .orElseThrow(() -> new EntityNotFoundException("회원을 찾을 수 없습니다."));

        String changeName = null;
        String originName = null;

        if (createBoard.getFile() != null && !createBoard.getFile().isEmpty()) {
            originName = createBoard.getFile()
                    .getOriginalFilename();
            changeName = UUID.randomUUID()
                    .toString() + "_" + originName;
            File uploadDir = new File(UPLOAD_PATH);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            createBoard.getFile()
                    .transferTo(new File(UPLOAD_PATH, changeName));
        }

        Board board = createBoard.toEntity();
        board.changeMember(member);
        board.changeFile(originName, changeName);

        if (createBoard.getTags() != null && !createBoard.getTags().isEmpty()) {

            for (String tagName : createBoard.getTags()) {
                Tag tag = tagRepository.findByTagName(tagName)
                        .orElseGet(() -> tagRepository.save(Tag.builder()
                                .tagName(tagName)
                                .build()));

                BoardTag boardTag = BoardTag.builder()
                        .tag(tag)
                        .build();

                boardTag.changeBoard(board);
            }
        }

        return boardRespository.save(board).getBoardNo();

    }

    @Override
    public void deleteBoard(Long boardNo) {
        Board board = boardRespository.findById(boardNo)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));

        if (board.getChangeName() != null && !board.getChangeName().isEmpty()) {
            new File(UPLOAD_PATH, board.getChangeName()).delete();
        }

        boardRespository.delete(board);
    }

    @Override
    public BoardDto.Response updateBoard(Long boardNo, BoardDto.Update boardUpdate) throws IOException {
        Board board = boardRespository.findById(boardNo)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));

        String changeName = board.getChangeName();
        String originName = board.getOriginName();

        if (boardUpdate.getFile() != null && !boardUpdate.getFile().isEmpty()) {
            originName = boardUpdate.getFile().getOriginalFilename();
            changeName = UUID.randomUUID().toString() + "_" + originName;
            File uploadDir = new File(UPLOAD_PATH);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            boardUpdate.getFile().transferTo(new File(UPLOAD_PATH, changeName));
        }

        board.changeContent(boardUpdate.getBoard_content());
        board.changeTitle(boardUpdate.getBoard_title());
        board.changeFile(originName, changeName);

        if (boardUpdate.getTags() != null && !boardUpdate.getTags()
                .isEmpty()) {
            //기존BoardTag -> 연결이 끊기면 필요가 있을까? X
            //연결된 boardTags의 영속성을 제거한다. -> orphanRemoval = true 설정이 되어있다면 실제 db에서 제거
            board.getBoardTags().clear();

            //tag가 왔다. ["kh","java","쉬움"]
            for (String tagName : boardUpdate.getTags()) {
                //tag를 이름으로 조회해서 없으면 새로 만들어라.
                Tag tag = tagRepository.findByTagName(tagName)
                        .orElseGet(() -> tagRepository.save(Tag.builder()
                                .tagName(tagName)
                                .build()));

                BoardTag boardTag = BoardTag.builder()
                        .tag(tag)
                        .build();

                boardTag.changeBoard(board);
            }
        }

        return BoardDto.Response.toDto(board);
    }





}
