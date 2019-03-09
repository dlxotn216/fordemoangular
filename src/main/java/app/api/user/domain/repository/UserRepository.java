package app.api.user.domain.repository;

import app.api.user.domain.model.QUser;
import app.api.user.domain.model.User;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
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
public interface UserRepository extends JpaRepository<User, Long>,
        QuerydslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser> {
    Page<User> findAllByNameLikeOrEmailLike(@Param("name") String name, @Param("email") String email, Pageable pageable);


    @Override
    default void customize(QuerydslBindings bindings, QUser root) {
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
        bindings.excluding(root.email);
    }
}
