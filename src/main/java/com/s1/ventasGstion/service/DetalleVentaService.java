package com.s1.ventasGstion.service;

import com.s1.ventasGstion.dto.request.DetalleVentaRequestDTO;
import com.s1.ventasGstion.dto.request.ProductoRequestDTO;
import com.s1.ventasGstion.dto.response.DetalleVentaResponseDTO;
import com.s1.ventasGstion.dto.response.ProductoResponseDTO;

import java.util.List;

public interface DetalleVentaService {

    //GUARDAR
    // retorna          nombre del metodo       lo que se necesita
    DetalleVentaResponseDTO guardarDetalleVenta(DetalleVentaRequestDTO dto);

    //ACTUALIZAR

    DetalleVentaResponseDTO actualizarDetalleVenta(DetalleVentaRequestDTO dto,Long id);

    //LISTAR

    List<DetalleVentaResponseDTO> listaDetalleVenta();

    //BUSCAR POR ID

    DetalleVentaResponseDTO buscarPorID(Long id);
}
