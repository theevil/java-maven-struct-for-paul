package com.example.vetclinic.application.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserDTO {
    private String username;
    private String email;
    private String password;
}
