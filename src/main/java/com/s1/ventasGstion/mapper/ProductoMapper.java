package com.s1.ventasGstion.mapper;

import com.s1.ventasGstion.dto.request.DetalleVentaRequestDTO;
import com.s1.ventasGstion.dto.request.ProductoRequestDTO;
import com.s1.ventasGstion.dto.request.VentaRequestDTO;
import com.s1.ventasGstion.dto.response.DetalleVentaResponseDTO;
import com.s1.ventasGstion.dto.response.ProductoResponseDTO;
import com.s1.ventasGstion.dto.response.VentaResponseDTO;
import com.s1.ventasGstion.model.Producto;
import org.springframework.stereotype.Component;


@Component
public class DetalleVentaMapper {

    //conversion de entidad(modelo desde la base de datos) a dto( la estructura y data manipulada)
    public DetalleVentaResponseDTO entidadaDTO(Producto DetalleVentaMapper){
        if (DetalleVentaMapper == null) return null;
        return new DetalleVentaResponseDTO(
                DetalleVentaMapper.getNombre(), DetalleVentaMapper.getDescripcion(), DetalleVentaMapper.getPrecio(), DetalleVentaMapper.getStock()
        );

    }


    //Conversion de DTO a entidad

    public Producto DTOaEntidad (DetalleVentaResponseDTO dto){

        if (dto == null) return null;
        Producto p= new Producto();
        p.setNombre(dto.nombre());
        p.setDescripcion(dto.descripcion());
        p.setPrecio(dto.precio());
        p.setStock(dto.stock());
        return p;
    }

    // Actualizacion de entidad desde DTO

    public void actualizarEntidadDesdeDTO(Producto DetalleVentaMapper, DetalleVentaRequestDTO dto ){

        if (DetalleVentaMapper == null || dto == null) return;
        DetalleVentaMapper.setNombre(dto.nombre());
        DetalleVentaMapper.setDescripcion(dto.descripcion());
        DetalleVentaMapper.setPrecio(dto.precio());
        DetalleVentaMapper.setStock(dto.stock());
    }
}
