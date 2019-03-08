package app.api.board.domain.model;

import app.api.user.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by taesu at : 2019-03-07
 *
 * 여기에 Board 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
@Entity
@SequenceGenerator(name = "BOARD_SEQ", sequenceName = "BOARD_SEQ")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ")
    private Long key;
    
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_KEY")
    private User createdBy;

    @Column(nullable = false)
    private LocalDateTime createdDateTime;
        
}
