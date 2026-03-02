package com.s1.ventasGstion.service.impl;

import com.s1.ventasGstion.dto.request.DetalleVentaRequestDTO;
import com.s1.ventasGstion.dto.response.DetalleVentaResponseDTO;
import com.s1.ventasGstion.mapper.DetalleVentaMapper;
import com.s1.ventasGstion.mapper.ProductoMapper;
import com.s1.ventasGstion.mapper.VentaMapper;
import com.s1.ventasGstion.model.DetalleVenta;
import com.s1.ventasGstion.repository.DetalleVentaRepository;
import com.s1.ventasGstion.repository.ProductoRepository;
import com.s1.ventasGstion.repository.VentaRepository;
import com.s1.ventasGstion.service.DetalleVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor



public class DetalleVentaServiceImpl implements DetalleVentaService {
    private final ProductoMapper productoMapper;
    private final ProductoRepository productoRepository;

    private final VentaMapper ventaMapper;
    private final VentaRepository ventaRepository;

    private final DetalleVentaMapper detalleVentaMapper;
    private final DetalleVentaRepository detalleVentaRepository;

    @Override
    public DetalleVentaResponseDTO guardarDetalleVenta(DetalleVentaRequestDTO dto) {
        DetalleVenta dv= detalleVentaMapper.DTOaEntidad(dto);
        DetalleVenta dvGuardar = detalleVentaRepository.save(dv);
        return detalleVentaMapper.entidadaDTO(dvGuardar);
    }

    @Override
    public DetalleVentaResponseDTO actualizarDetalleVenta(DetalleVentaRequestDTO dto, Long id) {
        DetalleVenta dv= detalleVentaRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No existe el detalle"));
        return null;
    }

    @Override
    public List<DetalleVentaResponseDTO> listaDetalleVenta() {
        List<DetalleVenta> detalleVentas=detalleVentaRepository.findAll();
        return null;
    }

    @Override
    public DetalleVentaResponseDTO buscarPorID(Long id) {
        DetalleVenta dv = detalleVentaRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No existe el detalle"));
        return detalleVentaMapper.entidadaDTO(dv);
    }
}
