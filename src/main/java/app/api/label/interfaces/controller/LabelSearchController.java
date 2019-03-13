package app.api.label.interfaces.controller;

import app.api.base.dto.ApiResponse;
import app.api.label.service.LabelSearchService;
import app.api.locale.domain.model.LocaleType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by taesu at : 2019-03-13
 *
 * 여기에 LabelController 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
@RestController
public class LabelSearchController {

    private LabelSearchService labelSearchService;

    public LabelSearchController(LabelSearchService labelSearchService) {
        this.labelSearchService = labelSearchService;
    }

    @GetMapping("/labels")
    public ResponseEntity<ApiResponse> getLabels(@RequestParam(name = "locale", required = false) Locale locale) {
        if (locale == null) {
            locale = LocaleType.ENGLISH.getLocale();
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.fromSuccessResult(this.labelSearchService.searchLabels(LocaleType.fromLocale(locale))));
    }

    @GetMapping("/labels/entries")
    public ResponseEntity<ApiResponse> getLabelEntries(@RequestParam(name = "locale", required = false) Locale locale,
                                                       @RequestParam(name = "labelIds", required = false) List<String> labelIds) {
        if (locale == null) {
            locale = LocaleType.ENGLISH.getLocale();
        }

        if (labelIds == null) {
            labelIds = Collections.emptyList();
        }
        
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.fromSuccessResult(this.labelSearchService.searchLabelEntries(LocaleType.fromLocale(locale), labelIds)));
    }
}
