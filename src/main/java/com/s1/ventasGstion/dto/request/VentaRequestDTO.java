package com.s1.ventasGstion.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.Date;

public record VentaRequestDTO(
        @NotBlank(message = "La fecha no puede estar vacia")
        @Future(message = "La fecha debe tener este formato (dd/mm/aaaa)")
        Date fecha,

        @NotBlank
        @PositiveOrZero
        BigDecimal total


) {


}
