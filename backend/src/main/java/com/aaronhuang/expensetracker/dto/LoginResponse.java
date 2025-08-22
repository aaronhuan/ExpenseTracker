package com.aaronhuang.expensetracker.dto;

public class LoginResponse {
    private String token;
    private UserDto userdto;

    public LoginResponse(String token, UserDto userdto) {
        this.token = token;
        this.userdto = userdto;
    }

    public String getToken() { return token; }
    public UserDto getUserDto() { return userdto; }
}
