package app.api.runner;

import app.api.board.domain.model.Board;
import app.api.board.domain.repository.BoardRepository;
import app.api.user.domain.model.User;
import app.api.user.domain.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by taesu at : 2019-03-07
 *
 * 여기에 MockDataRunner 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
@Component
public class MockDataRunner implements ApplicationRunner {
    private UserRepository userRepository;
    private BoardRepository boardRepository;

    public MockDataRunner(UserRepository userRepository, BoardRepository boardRepository) {
        this.userRepository = userRepository;
        this.boardRepository = boardRepository;
    }

    @Transactional
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        this.userRepository.saveAll(Arrays.asList(
                User.builder().id("dlxotn").name("이태수").email("dlxotn@naver.com").age(21).phone("010-9478-2343").build(),
                User.builder().id("taesu").name("이태수").email("taesu@naver.com").age(27).phone("010-9999-2873").build(),
                User.builder().id("lambda").name("람다").email("lambda@naver.com").age(34).phone("010-9945-2163").build(),
                User.builder().id("method").name("메소드").email("method@naver.com").age(22).phone("010-9456-8673").build(),
                User.builder().id("object").name("객체").email("object@naver.com").age(25).phone("010-9324-2313").build(),
                User.builder().id("user").name("사용자").email("user@naver.com").age(44).phone("010-9769-1313").build(),
                User.builder().id("common").name("일반").email("common@naver.com").age(14).phone("010-9346-4513").build(),
                User.builder().id("base").name("기반").email("base@naver.com").age(45).phone("010-9567-2313").build(),
                User.builder().id("default").name("기본").email("default@naver.com").age(23).phone("010-5679-1313").build(),
                User.builder().id("apple").name("사과").email("apple@naver.com").age(32).phone("010-2359-2123").build(),
                User.builder().id("home").name("집").email("home@naver.com").age(19).phone("010-5689-4653").build(),
                User.builder().id("kim").name("김").email("kim@naver.com").age(71).phone("010-9457-2713").build(),
                User.builder().id("lee").name("이").email("lee@naver.com").age(14).phone("010-9325-2313").build()
        ));
        
        this.boardRepository.saveAll(
                this.userRepository.findAll()
                        .stream()
                        .map(user -> Board.builder().title("Test "+user.getKey()).content("test article writed by "+user.getId())
                                .createdBy(user).createdDateTime(LocalDateTime.now()).build())
                        .collect(Collectors.toList())
        );
        
    }
}
