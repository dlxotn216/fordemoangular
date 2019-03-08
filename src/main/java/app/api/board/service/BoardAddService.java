package app.api.board.service;

import app.api.board.domain.model.Board;
import app.api.board.domain.repository.BoardRepository;
import app.api.board.interfaces.dto.BoardDto;
import app.api.user.domain.model.User;
import app.api.user.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by taesu at : 2019-03-08
 *
 * 여기에 BoardAddService 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
@Component
public class BoardAddService {
    private BoardRepository boardRepository;
    private UserRepository userRepository;

    public BoardAddService(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }
    
    public BoardDto.BoardSearchResponse addBoard(BoardDto.BoardAddRequest request){
        final User anyWriteUser = this.userRepository.findById(1L)
                .orElseGet(() -> this.userRepository.findAll().get(0));

        final Board added = this.boardRepository.save(Board.builder().title(request.getTitle())
                                                       .content(request.getContent())
                                                       .createdBy(anyWriteUser)
                                                       .createdDateTime(LocalDateTime.now()).build());
        
        return BoardDto.asBoardSearchResponse(added);
    }
}
