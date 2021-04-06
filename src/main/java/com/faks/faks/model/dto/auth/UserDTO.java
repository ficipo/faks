package com.faks.faks.model.dto.auth;

import com.faks.faks.model.entity.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDTO {

    private Long id;
    private String firstName;
    private String email;
    private String position;
    private Boolean active;
    private String userRole;

    public static UserDTO fromEntity(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setEmail(user.getEmail());
        userDTO.setUserRole(user.getRole().getName());
        userDTO.setActive(user.getActive());

        return userDTO;
    }

    public static List<UserDTO> fromList(List<User> users) {
        return users.stream().map(UserDTO::fromEntity).collect(Collectors.toList());
    }

}
