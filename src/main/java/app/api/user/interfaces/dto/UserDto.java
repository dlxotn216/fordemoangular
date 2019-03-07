package app.api.user.interfaces.dto;

import app.api.user.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by taesu at : 2019-03-07
 *
 * 여기에 UserDto 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
public final class UserDto {
    
    public static UserSearchResponse asSearchResponse(User user){
        return new UserSearchResponse(user.getKey(), user.getId(), user.getEmail(), user.getName(), user.getAge(), user.getPhone());
    } 

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserSearchResponse {
        private Long key;

        private String id;

        private String email;

        private String name;

        private Integer age;

        private String phone;
    }
}
