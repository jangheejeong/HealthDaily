package com.jang.healthdaily.payload.User;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class SignUpRequest {
    @NotBlank
    @Size(min = 3, max = 15)
    private String userName;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    @NotBlank
    @Size(max = 11)
    private String cell;

    @Size(max = 11)
    private String phone;

    @NotBlank
    @Size(max = 100)
    private String address;

    @NotBlank
    @Size(max = 100)
    private String street;

}
