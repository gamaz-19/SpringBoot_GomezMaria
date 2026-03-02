package com.s1.ventasGstion.mapper;


import com.s1.ventasGstion.dto.request.DetalleVentaRequestDTO;
import com.s1.ventasGstion.dto.response.DetalleVentaResponseDTO;
import com.s1.ventasGstion.model.DetalleVenta;
import com.s1.ventasGstion.model.Producto;
import com.s1.ventasGstion.model.Venta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DetalleVentaMapper {

    private final VentaMapper ventaMapper;
    private final ProductoMapper productoMapper;

    //conversion de entidad(modelo desde la base de datos) a dto( la estructura y data manipulada)
    public DetalleVentaResponseDTO entidadaDTO(DetalleVenta detalleventaMapper){
        if (detalleventaMapper == null) return null;
        return new DetalleVentaResponseDTO(
                detalleventaMapper.getCantidad(), detalleventaMapper.getSubtotal(),
                ventaMapper.entidadaDTO(detalleventaMapper.getVenta_id()),
                productoMapper.entidadaDTO(detalleventaMapper.getProducto_id())
        );

    }
    //Conversion de DTO a entidad

    public DetalleVenta DTOaEntidad (DetalleVentaRequestDTO dto, Producto p, Venta v){
        if (dto == null) return null;
        DetalleVenta dv= new DetalleVenta();
        dv.setCantidad(dto.cantidad());
        dv.setSubtotal(dto.subtotal());
        dv.setProducto_id(p);
        dv.setVenta_id(v);
        return dv;
    }

    public DetalleVenta DTOaEntidad(DetalleVentaRequestDTO dto) {
    return null;
    }
}
