package app.api.user.interfaces.controller;

import app.api.base.dto.ApiResponse;
import app.api.base.dto.SearchCriteria;
import app.api.user.application.UserSearchService;
import app.api.user.interfaces.criteria.UserPredicateBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                                                   @RequestParam(value = "search", defaultValue = "", required = false) String search) {
        UserPredicateBuilder builder = new UserPredicateBuilder();
        if (search != null) {
            Pattern pattern = Pattern.compile("(\\w+?)(=|!=|:|<|>|<=|>=)(\\w+?),", Pattern.UNICODE_CHARACTER_CLASS);
            Matcher matcher = pattern.matcher(SearchCriteria.replaceAllToCompilable(search) + ",");
            while (matcher.find()) {
                builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
            }
        }
        BooleanExpression exp = builder.build();

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ApiResponse.fromSuccessResult(this.userSearchService.searchUsers(exp, pageable)));
    }

    @GetMapping("users/matches")
    public ResponseEntity<ApiResponse> searchUsersMatchedByNameOrEmail(Pageable pageable,
                                                                       @RequestParam(defaultValue = "") String nameOrEmail) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ApiResponse.fromSuccessResult(this.userSearchService.searchUsers(pageable, nameOrEmail)));
    }

}
