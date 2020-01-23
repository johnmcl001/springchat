package com.jmcl.springchat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@RequiredArgsConstructor
public class Chat {

    @NotBlank(message="Please specify a user")
    private final String user;

    @Size(min=5, max=120, message="Message must be 5 to 120 characters long")
    private final String message;

}
