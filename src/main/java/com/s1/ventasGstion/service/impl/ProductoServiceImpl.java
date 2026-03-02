package com.s1.ventasGstion.service.impl;

import com.s1.ventasGstion.dto.request.ProductoRequestDTO;
import com.s1.ventasGstion.dto.response.ProductoResponseDTO;
import com.s1.ventasGstion.mapper.ProductoMapper;
import com.s1.ventasGstion.repository.ProductoRepository;
import com.s1.ventasGstion.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor

public class ProductoServiceImpl implements ProductoService {
    private final ProductoMapper productoMappper;
    private final ProductoRepository productoRepository;

    @Override
    public ProductoResponseDTO guardarProducto(ProductoRequestDTO dto) {
        return null;
    }

    @Override
    public ProductoResponseDTO actualizarProducto(ProductoRequestDTO dto, Long id) {
        return null;
    }

    @Override
    public List<ProductoResponseDTO> listaProducto() {
        return List.of();
    }

    @Override
    public ProductoResponseDTO buscarPorID(Long id) {
        return null;
    }

    @Override
    public void eliminarPorID(Long id) {

    }
}
