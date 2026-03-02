package com.s1.ventasGstion.service.impl;


import com.s1.ventasGstion.dto.request.VentaRequestDTO;
import com.s1.ventasGstion.dto.response.VentaResponseDTO;
import com.s1.ventasGstion.service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaServiceImpl implements VentaService {

    @Override
    public VentaResponseDTO guardarVenta(VentaRequestDTO dto) {
        return null;
    }

    @Override
    public VentaResponseDTO actualizarVenta(VentaRequestDTO dto, Long id) {
        return null;
    }

    @Override
    public List<VentaResponseDTO> listaVenta() {
        return List.of();
    }

    @Override
    public VentaRequestDTO buscarPorID(Long id) {
        return null;
    }
}
