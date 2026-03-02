package com.s1.ventasGstion.dto.request;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record DetalleVentaRequestDTO(

        @Positive
        Integer cantidad,

        @PositiveOrZero
        BigDecimal subtotal,

        @Positive
        Integer venta_id,

        @Positive
        Integer producto_id


) {
}
