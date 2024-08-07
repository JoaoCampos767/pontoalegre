package com.pontoalegre.pontoalegre.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserRecordDto(@NotBlank String name, @NotBlank String password, @NotBlank String email, @NotBlank String phone) {
}
