package app.api.label.domain.repository;

import app.api.label.domain.model.Label;
import app.api.locale.domain.model.LocaleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Locale;

/**
 * Created by taesu at : 2019-03-13
 *
 * 여기에 LabelRepository 인터페이스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
public interface LabelRepository extends JpaRepository<Label, Long> {
    List<Label> findAllByLocaleType(@Param("locale") LocaleType locale);

    List<Label> findAllByLocaleTypeAndLabelIdIn(@Param("local") LocaleType locale, @Param("labelIds") List<String> labelIds);
}
