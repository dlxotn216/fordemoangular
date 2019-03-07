package app.api.board.service;

import app.api.board.domain.repository.BoardRepository;
import app.api.board.interfaces.dto.BoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * Created by taesu at : 2019-03-07
 *
 * 여기에 BoardSearchService 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
@Component
public class BoardSearchService {
    private BoardRepository boardRepository;

    public BoardSearchService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Page<BoardDto.BoardsSearchResponse> searchBoards(Pageable pageable) {
        return this.boardRepository.findAll(pageable)
                .map(BoardDto::asBoardsSearchResponse);
    }

    public BoardDto.BoardSearchResponse searchBoard(Long boardKey) {
        return this.boardRepository.findById(boardKey)
                .map(BoardDto::asBoardSearchResponse)
                .orElseThrow(IllegalArgumentException::new);
    }
}
