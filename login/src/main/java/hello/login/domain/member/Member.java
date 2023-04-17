package hello.login.domain.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Member {

    private Long id;

    @NotEmpty
    private String loginId; // 로그안 아이디
    @NotEmpty
    private String name;
    @NotEmpty
    private String password;
}
