package app.api.label.domain.model;

import app.api.locale.domain.model.LocaleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by taesu at : 2019-03-13
 *
 * 여기에 AppLabel 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "", columnNames = {"LOCALE", "LABEL_ID"})
})
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@SequenceGenerator(name = "LABEL_SEQ", sequenceName = "LABEL_SEQ")
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "LABEL_SEQ")
    private Long labelKey;

    @Column(name = "LOCALE")
    @Enumerated(value = EnumType.STRING)
    private LocaleType localeType;

    @Column(name = "LABEL_ID")
    private String labelId;

    @Column
    private String value;
}
