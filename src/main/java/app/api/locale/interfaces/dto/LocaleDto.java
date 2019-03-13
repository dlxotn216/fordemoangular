package app.api.locale.interfaces.dto;

import app.api.locale.domain.model.LocaleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by taesu at : 2019-03-13
 *
 * 여기에 LocaleDto 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
public class LocaleDto {

    public static SearchLocalesResponse asSearchLocalesResponse(LocaleType localeType) {
        return new SearchLocalesResponse(localeType.getLocale().getLanguage(), localeType.getLabel());
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class SearchLocalesResponse {
        private String value;
        private String label;
    }
}
