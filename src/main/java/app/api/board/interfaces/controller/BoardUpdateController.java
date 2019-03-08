package app.api.board.interfaces.controller;

import app.api.base.dto.ApiResponse;
import app.api.board.interfaces.dto.BoardDto;
import app.api.board.service.BoardUpdateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by taesu at : 2019-03-08
 *
 * 여기에 BoardUpdateController 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
@RestController
public class BoardUpdateController {
    
    private BoardUpdateService boardUpdateService;

    public BoardUpdateController(BoardUpdateService boardUpdateService) {
        this.boardUpdateService = boardUpdateService;
    }

    @PutMapping("boards/{boardKey}")
    public ResponseEntity<ApiResponse> updateBoard(
            @PathVariable("boardKey") Long boardKey,
            @RequestBody BoardDto.BoardUpdateRequest request) {
        request.setKey(boardKey);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.fromSuccessResult(this.boardUpdateService.updateBoard(request)));
    }
}
