package com.s1.ventasGstion.service;

import com.s1.ventasGstion.dto.request.VentaRequestDTO;
import com.s1.ventasGstion.dto.response.ProductoResponseDTO;
import com.s1.ventasGstion.dto.response.VentaResponseDTO;

import java.util.Date;
import java.util.List;

public interface VentaService {


    // Se hace el crud


    //GUARDAR
    // retorna          nombre del metodo       lo que se necesita
    VentaResponseDTO guardarVenta(VentaRequestDTO dto);

    //ACTUALIZAR
    VentaResponseDTO actualizarVenta(VentaRequestDTO dto,Long id);

    //LISTAR

    List<VentaResponseDTO> listaVenta();

    //BUSCAR POR ID

    VentaRequestDTO buscarPorID(Long id);
}
