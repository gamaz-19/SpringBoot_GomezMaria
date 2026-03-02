package com.s1.ventasGstion.dto.response;

import java.math.BigDecimal;

public record ProductoResponseDTO(
        String nombre, String descripcion, BigDecimal precio, Integer stock

) {
}
