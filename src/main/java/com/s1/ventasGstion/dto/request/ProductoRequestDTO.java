package com.s1.ventasGstion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductoRequestDTO(

        @NotBlank (message = "El nombre no puede estar vacio o solo contener espacios")
        @Size(min=20, max = 50, message = "El nombre debe ser ente 20 y 50 caracteres")
        String nombre,

        @NotBlank (message = "La descripcion no puede estar vacio o solo contener espacios")
        @Size(min=20, max = 50, message = "La descripcion debe ser ente 20 y 50 caracteres")
        String descripcion,

        @PositiveOrZero
        BigDecimal precio,

        @PositiveOrZero
        Integer stock

) {
}
