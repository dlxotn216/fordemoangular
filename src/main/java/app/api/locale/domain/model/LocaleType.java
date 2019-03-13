package app.api.locale.domain.model;

import lombok.Getter;

import java.util.Locale;
import java.util.stream.Stream;

/**
 * Created by taesu at : 2019-03-13
 *
 * 여기에 LocaleType 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
@Getter
public enum LocaleType {
    ENGLISH(Locale.ENGLISH, "English"),
    KOREAN(Locale.KOREAN, "한국어"),
    JAPANESE(Locale.JAPANESE, "Japanese"),;

    private Locale locale;
    private String label;

    LocaleType(Locale locale, String label) {
        this.locale = locale;
        this.label = label;
    }

    public static LocaleType fromLocale(Locale locale) {
        return Stream.of(values())
                .filter(localeType -> localeType.getLocale() == locale)
                .findFirst()
                .orElse(LocaleType.ENGLISH);
    }
}
