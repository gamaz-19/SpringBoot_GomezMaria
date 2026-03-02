package com.s1.ventasGstion.dto.response;

import java.math.BigDecimal;
import java.util.Date;

public record VentaResponseDTO(
        Long id, Date fecha, BigDecimal total

) {
}
