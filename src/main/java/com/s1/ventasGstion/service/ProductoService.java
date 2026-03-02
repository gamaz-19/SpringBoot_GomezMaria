package com.s1.ventasGstion.service;

import com.s1.ventasGstion.dto.request.ProductoRequestDTO;
import com.s1.ventasGstion.dto.request.VentaRequestDTO;
import com.s1.ventasGstion.dto.response.ProductoResponseDTO;
import com.s1.ventasGstion.dto.response.VentaResponseDTO;

import java.util.List;

public interface ProductoService {

    // Se hace el crud


    //GUARDAR
    // retorna          nombre del metodo       lo que se necesita
    ProductoResponseDTO guardarProducto( ProductoRequestDTO dto);

    //ACTUALIZAR

    ProductoResponseDTO actualizarProducto(ProductoRequestDTO dto,Long id);

    //LISTAR

    List<ProductoResponseDTO> listaProducto();

    //BUSCAR POR ID

    ProductoResponseDTO buscarPorID(Long id);

    //ELIMINAR PRODUCTO

    void eliminarPorID(Long id);

}
