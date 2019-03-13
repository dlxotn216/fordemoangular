package app.api.label.interfaces.dto;

import app.api.label.domain.model.Label;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by taesu at : 2019-03-13
 *
 * 여기에 LabelDto 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
public class LabelDto {

    public static LabelsSearchResponse asLabelsSearchResponse(Label label) {
        return new LabelsSearchResponse(label.getLocaleType().getLocale().getLanguage(), label.getLabelId(), label.getValue());
    }

    @Data
    @AllArgsConstructor
    public static class LabelsSearchResponse {
        private String locale;

        private String labelId;

        private String value;
    }
}
