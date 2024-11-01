package com.escass.springbootbasicproject.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class User {
    private String id;
    private String password;
    private String nickname;
    private Date registerDate;
}
