package app.api.board.interfaces.controller;

import app.api.base.dto.ApiResponse;
import app.api.board.service.BoardDeleteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by taesu at : 2019-03-08
 *
 * 여기에 BoardDeleteController 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
@RestController
public class BoardDeleteController {
    private BoardDeleteService boardDeleteService;

    public BoardDeleteController(BoardDeleteService boardDeleteService) {
        this.boardDeleteService = boardDeleteService;
    }

    @DeleteMapping("boards/{boardKey}")
    public ResponseEntity<ApiResponse> deleteBoard(@PathVariable("boardKey") Long boardKey) {
        this.boardDeleteService.deleteBoard(boardKey);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.fromSuccessResult(true));
    }
}
