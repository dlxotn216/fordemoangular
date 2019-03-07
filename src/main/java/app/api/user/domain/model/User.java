package app.api.user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by taesu at : 2019-03-07
 *
 * 여기에 User 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
@Table(name = "MST_USER")
@Entity
@SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "USER_KEY")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long key;

    @Column(name = "USER_ID", unique = true, nullable = false)
    private String id;

    @Column(name = "USER_EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "USER_NAME", nullable = false)
    private String name;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "PHONE")
    private String phone;

}
