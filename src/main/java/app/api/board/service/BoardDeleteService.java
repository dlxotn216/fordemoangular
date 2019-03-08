package app.api.board.service;

import app.api.board.domain.repository.BoardRepository;
import org.springframework.stereotype.Component;

/**
 * Created by taesu at : 2019-03-08
 *
 * 여기에 BoardDeleteService 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
@Component
public class BoardDeleteService {
    private BoardRepository boardRepository;

    public BoardDeleteService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }
    
    public void deleteBoard(Long boardKey){
        this.boardRepository.deleteById(boardKey);
    }
}
