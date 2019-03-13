package app.api.locale.interfaces.controller;

import app.api.base.dto.ApiResponse;
import app.api.locale.domain.model.LocaleType;
import app.api.locale.interfaces.dto.LocaleDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by taesu at : 2019-03-13
 *
 * 여기에 LocaleController 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
@RestController
public class LocaleSearchController {

    @GetMapping("locales")
    public ResponseEntity<ApiResponse> searchLocales() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.fromSuccessResult(Stream.of(LocaleType.values())
                                                            .map(LocaleDto::asSearchLocalesResponse)
                                                            .collect(Collectors.toList())));
    }
}
