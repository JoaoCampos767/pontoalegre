package com.pontoalegre.pontoalegre.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.UUID;

public record ClockInRecordDto(@NotBlank UUID idUser, @NotBlank Date dtClock, @NotBlank String entryOrExit) {
}
