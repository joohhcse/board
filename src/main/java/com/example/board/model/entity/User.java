package com.example.board.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    private Boolean enabled;

//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Role role;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    /**
     * 회원정보 수정
     * @param nickname
     * @param password`
     */
    public void modify(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    //cascade = CascadeType.ALL //orphanRemoval = true 부모가 없는 데이터 삭제
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    @JsonIgnore
    private List<Boards> boards = new ArrayList<>();
}
