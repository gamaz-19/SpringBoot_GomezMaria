package com.s1.ventasGstion.dto.response;

import java.math.BigDecimal;

public record DetalleVentaResponseDTO(

        Integer cantidad, BigDecimal subtotal, VentaResponseDTO producto, ProductoResponseDTO venta

) {
}
