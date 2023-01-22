package com.example.board.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String username; // 아이디

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(length = 100)
    private String password;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Role role;

    /**
     * 회원정보 수정
     * @param nickname
     * @param password
     */
    public void modify(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }


}
