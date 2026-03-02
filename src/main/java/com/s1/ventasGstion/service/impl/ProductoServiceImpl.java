package com.s1.ventasGstion.service.impl;

import com.s1.ventasGstion.dto.request.ProductoRequestDTO;
import com.s1.ventasGstion.dto.response.ProductoResponseDTO;
import com.s1.ventasGstion.mapper.ProductoMapper;
import com.s1.ventasGstion.model.Producto;
import com.s1.ventasGstion.repository.ProductoRepository;
import com.s1.ventasGstion.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor

public class ProductoServiceImpl implements ProductoService {
    private final ProductoMapper productoMapper;
    private final ProductoRepository productoRepository;

    @Override
    public ProductoResponseDTO guardarProducto(ProductoRequestDTO dto) {

        Producto p= productoMapper.DTOaEntidad(dto);
        Producto productoInsertado = productoRepository.save(p);
        return productoMapper.entidadaDTO(productoInsertado);
    }

    @Override
    public ProductoResponseDTO actualizarProducto(ProductoRequestDTO dto, Long id) {
        Producto p= productoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No existe el producto"));

        productoMapper.actualizarEntidadDesdeDTO(p,dto);
        Producto productoActualizado = productoRepository.save(p);
        return productoMapper.entidadaDTO(productoActualizado);

    }

    @Override
    public List<ProductoResponseDTO> listaProducto() {
        List<Producto> productos= productoRepository.findAll();
        return productos.stream().map(productoMapper::entidadaDTO).toList();
    }

    @Override
    public ProductoResponseDTO buscarPorID(Long id) {
        Producto p = productoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No existe el producto"));
        return productoMapper.entidadaDTO(p);
    }

    @Override
    public void eliminarPorID(Long id) {

        //mapper si transforma
        //repository para buscar

        Producto p= productoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No existe el producto"));
        productoRepository.delete(p);
    }
}
