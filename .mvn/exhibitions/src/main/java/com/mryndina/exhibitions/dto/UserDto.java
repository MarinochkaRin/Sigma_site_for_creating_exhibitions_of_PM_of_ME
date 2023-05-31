package com.mryndina.exhibitions.dto;

import com.mryndina.exhibitions.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private long id;
    private String username;
    private Role role;
    private String photoId;

    private String firstName;
    private String secondName;

    private String locationPerson;
}
