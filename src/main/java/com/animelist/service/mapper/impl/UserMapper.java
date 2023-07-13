package com.animelist.service.mapper.impl;

import com.animelist.dto.request.UserRequestDto;
import com.animelist.dto.response.UserResponseDto;
import com.animelist.model.Role;
import com.animelist.model.User;
import com.animelist.service.OrderService;
import com.animelist.service.RoleService;
import com.animelist.service.mapper.MapperToDto;
import com.animelist.service.mapper.MapperToModel;
import org.springframework.stereotype.Component;
import java.util.Set;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UserMapper implements MapperToModel<UserRequestDto, User>,
        MapperToDto<User, UserResponseDto> {
    private final RoleService roleService;
    private final OrderService orderService;

    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setLogin(user.getLogin());
        return userResponseDto;
    }

    @Override
    public User mapToModel(UserRequestDto userRequestDto) {
        User user = new User();
        user.setLogin(user.getLogin());
        user.setRoles(Set.of(roleService.getByName(String.valueOf(Role.RoleName.USER))));
        user.setOrders(orderService.getOrdersByUserId(user.getId()));
        user.setPassword(user.getPassword());
        return user;
    }
}
