package app.api.user.interfaces.controller;

import app.api.base.dto.ApiResponse;
import app.api.user.application.UserSearchService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by taesu at : 2019-03-07
 *
 * 여기에 UserSearchController 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
@RestController
public class UserSearchController {
    private UserSearchService userSearchService;

    public UserSearchController(UserSearchService userSearchService) {
        this.userSearchService = userSearchService;
    }

    @GetMapping("users")
    public ResponseEntity<ApiResponse> searchUsers(Pageable pageable,
                                                   @RequestParam(defaultValue = "") String nameOrEmail) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ApiResponse.fromSuccessResult(this.userSearchService.searchUsers(pageable, nameOrEmail)));
    }

}
