package app.api.board.interfaces.controller;

import app.api.base.dto.ApiResponse;
import app.api.board.service.BoardSearchService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by taesu at : 2019-03-07
 *
 * 여기에 BoardController 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
@RestController
public class BoardSearchController {

    private BoardSearchService boardSearchService;

    public BoardSearchController(BoardSearchService boardSearchService) {
        this.boardSearchService = boardSearchService;
    }

    @GetMapping("boards")
    public ResponseEntity<ApiResponse> searchBoards(@PageableDefault(page = 0, size = 20)
                                                        @SortDefault.SortDefaults({
                                                                @SortDefault(sort = "createdDateTime", direction = Sort.Direction.DESC)
                                                        })Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.fromSuccessResult(this.boardSearchService.searchBoards(pageable)));
    }
    
    @GetMapping("boards/{boardKey}")
    public ResponseEntity<ApiResponse> searchBoard(@PathVariable("boardKey") Long boardKey) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.fromSuccessResult(this.boardSearchService.searchBoard(boardKey)));
    } 
}
