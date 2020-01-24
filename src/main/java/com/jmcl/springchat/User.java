package com.jmcl.springchat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@RequiredArgsConstructor
public class User {

    @NotBlank(message="Please enter your name")
    private final String realName;

    @Size(min=3, max=10, message="Please enter a valid username")
    private final String userName;
}
