package com.s1.ventasGstion.service.impl;


import com.s1.ventasGstion.dto.request.VentaRequestDTO;
import com.s1.ventasGstion.dto.response.VentaResponseDTO;
import com.s1.ventasGstion.mapper.VentaMapper;
import com.s1.ventasGstion.model.Venta;
import com.s1.ventasGstion.repository.VentaRepository;
import com.s1.ventasGstion.service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaServiceImpl implements VentaService {

    private final VentaMapper ventaMapper; //para transformar
    private final VentaRepository ventaRepository; //para buscar

    @Override
    public VentaResponseDTO guardarVenta(VentaRequestDTO dto) {
        Venta v= ventaMapper.DTOaEntidad(dto);
        Venta ventaInsesrtada = ventaRepository.save(v);
        return ventaMapper.entidadaDTO(ventaInsesrtada);
    }

    @Override
    public VentaResponseDTO actualizarVenta(VentaRequestDTO dto, Long id) {
        Venta v= ventaRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No existe la venta"));

        ventaMapper.actualizarEntidadDesdeDTO(v,dto);
        Venta ventaActualizada = ventaRepository.save(v);
        return ventaMapper.entidadaDTO(ventaActualizada);
    }

    @Override
    public List<VentaResponseDTO> listaVenta() {
        List<Venta> ventas= ventaRepository.findAll();
        return ventas.stream().map(ventaMapper::entidadaDTO).toList();
    }

    @Override
    public VentaResponseDTO buscarPorID(Long id) {
        Venta v = ventaRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No existe la venta"));
        return ventaMapper.entidadaDTO(v);
    }
}
