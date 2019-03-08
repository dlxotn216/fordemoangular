package app.api.board.interfaces.controller;

import app.api.base.dto.ApiResponse;
import app.api.board.interfaces.dto.BoardDto;
import app.api.board.service.BoardAddService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by taesu at : 2019-03-08
 *
 * 여기에 BoardAddController 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
@RestController
public class BoardAddController {
    private BoardAddService boardAddService;

    public BoardAddController(BoardAddService boardAddService) {
        this.boardAddService = boardAddService;
    }

    @PostMapping("boards")
    public ResponseEntity<ApiResponse> addBoard(@RequestBody BoardDto.BoardAddRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.fromSuccessResult(this.boardAddService.addBoard(request)));
    }
}
