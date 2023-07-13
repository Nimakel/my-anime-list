package com.animelist.dto.request;

import com.animelist.lib.FieldsValueMatch;
import com.animelist.lib.ValidLogin;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@FieldsValueMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "Password do not match!"
)
@Getter
public class UserRequestDto {
    @ValidLogin
    private String login;
    @Size(min = 8, max = 40)
    private String password;
    private String repeatPassword;
}
