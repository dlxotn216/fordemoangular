package app.api.board.domain.repository;

import app.api.board.domain.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by taesu at : 2019-03-07
 *
 * 여기에 BoardRepository 인터페이스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
public interface BoardRepository extends JpaRepository<Board, Long> {
}
