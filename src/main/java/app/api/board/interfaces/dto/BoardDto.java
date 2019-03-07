package app.api.board.interfaces.dto;

import app.api.board.domain.model.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by taesu at : 2019-03-07
 *
 * 여기에 BoardDto 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
public final class BoardDto {

    public static BoardsSearchResponse asBoardsSearchResponse(Board board) {
        return new BoardsSearchResponse(board.getKey(), board.getTitle(), board.getCreatedBy().getName(), board.getCreatedDateTime());
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BoardsSearchResponse {
        private Long key;
        private String title;
        private String createdBy;
        private LocalDateTime createdDateTime;
    }

    public static BoardSearchResponse asBoardSearchResponse(Board board) {
        return new BoardSearchResponse(board.getKey(), board.getTitle(),
                                        board.getContent(),
                                        board.getCreatedBy().getName(), board.getCreatedDateTime());
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BoardSearchResponse {
        private Long key;
        private String title;
        private String content;
        private String createdBy;
        private LocalDateTime createdDateTime;
    }
}
