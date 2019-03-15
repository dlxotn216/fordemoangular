package app.api.user.application;

import app.api.user.domain.repository.UserRepository;
import app.api.user.interfaces.dto.UserDto;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * Created by taesu at : 2019-03-07
 *
 * 여기에 UserSearchService 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
@Component
public class UserSearchService {
    private UserRepository userRepository;

    public UserSearchService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<UserDto.UserSearchResponse> searchUsers(Predicate predicate, Pageable pageable) {
        return this.userRepository.findAll(predicate, pageable)
                .map(UserDto::asSearchResponse);
    }

    public Page<UserDto.UserSearchResponse> searchUsers(Pageable pageable, String nameOrEmail) {
        nameOrEmail = "%" + nameOrEmail + "%";
        return this.userRepository.findAllByNameLikeOrEmailLike(nameOrEmail, nameOrEmail, pageable)
                .map(UserDto::asSearchResponse);
    }

}
