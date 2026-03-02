package com.s1.ventasGstion.service.impl;

import com.s1.ventasGstion.dto.request.DetalleVentaRequestDTO;
import com.s1.ventasGstion.dto.response.DetalleVentaResponseDTO;
import com.s1.ventasGstion.service.DetalleVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class DetalleVentaServiceImpl implements DetalleVentaService {
    @Override
    public DetalleVentaResponseDTO guardarDetalleVenta(DetalleVentaRequestDTO dto) {
        return null;
    }

    @Override
    public DetalleVentaResponseDTO actualizarDetalleVenta(DetalleVentaRequestDTO dto, Long id) {
        return null;
    }

    @Override
    public List<DetalleVentaResponseDTO> listaDetalleVenta() {
        return List.of();
    }

    @Override
    public DetalleVentaResponseDTO buscarPorID(Long id) {
        return null;
    }
}
