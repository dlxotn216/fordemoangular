package app.api.board.domain.repository;

import app.api.board.domain.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
    /**
     * N+! 쿼리를 방지하기 위해 JPQL 사용
     * count query에는 fetch가 명시되어있지 않음을 주의
     *
     * @param pageable page request
     * @return Board Entities
     */
    @Query(value = "select a from Board a inner join fetch a.createdBy",
            countQuery = "select COUNT(a.key) from Board a inner join a.createdBy")
    Page<Board> findAllWithJoinUser(Pageable pageable);
}
