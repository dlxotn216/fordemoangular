package app.api.user.domain.repository;

import app.api.user.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by taesu at : 2019-03-07
 *
 * 여기에 UserRepository 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAllByNameLikeOrEmailLike(@Param("name") String name, @Param("email") String email, Pageable pageable);
}
