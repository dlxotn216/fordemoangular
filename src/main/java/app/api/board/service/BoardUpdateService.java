package app.api.board.service;

import app.api.board.domain.model.Board;
import app.api.board.domain.repository.BoardRepository;
import app.api.board.interfaces.dto.BoardDto;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

/**
 * Created by taesu at : 2019-03-08
 *
 * 여기에 BoardUpdateService 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
@Component
public class BoardUpdateService {
    private BoardRepository boardRepository;

    public BoardUpdateService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardDto.BoardSearchResponse updateBoard(@RequestBody BoardDto.BoardUpdateRequest request) {
        Board board = this.boardRepository.findById(request.getKey()).orElseThrow(IllegalArgumentException::new);

        Board savedBoard = this.boardRepository.save(Board.builder().key(board.getKey())
                                                       .title(request.getTitle())
                                                       .content(request.getContent())
                                                       .createdBy(board.getCreatedBy())
                                                       .createdDateTime(LocalDateTime.now()).build());
        
        return BoardDto.asBoardSearchResponse(savedBoard);
    }
}
