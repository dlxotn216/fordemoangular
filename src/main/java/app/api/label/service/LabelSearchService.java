package app.api.label.service;

import app.api.label.domain.model.Label;
import app.api.label.domain.repository.LabelRepository;
import app.api.label.interfaces.dto.LabelDto;
import app.api.locale.domain.model.LocaleType;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by taesu at : 2019-03-13
 *
 * 여기에 LabelSearchService 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
@Component
public class LabelSearchService {
    private LabelRepository labelRepository;

    public LabelSearchService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public List<LabelDto.LabelsSearchResponse> searchLabels(LocaleType localeType) {
        return this.labelRepository.findAllByLocaleType(localeType)
                .stream().map(LabelDto::asLabelsSearchResponse)
                .collect(Collectors.toList());
    }

    public Map<String, String> searchLabelEntries(LocaleType localeType, List<String> labelIds) {
        return getLabelEntriesByParameter(localeType, labelIds)
                .stream().map(LabelDto::asLabelsSearchResponse)
                .collect(Collectors.groupingBy(LabelDto.LabelsSearchResponse::getLabelId,
                                               Collectors.mapping(LabelDto.LabelsSearchResponse::getValue, Collectors.joining())));
    }

    private List<Label> getLabelEntriesByParameter(LocaleType localeType, List<String> labelIds) {
        return CollectionUtils.isEmpty(labelIds)
                ? this.labelRepository.findAllByLocaleType(localeType)
                : this.labelRepository.findAllByLocaleTypeAndLabelIdIn(localeType, labelIds);
    }

}
