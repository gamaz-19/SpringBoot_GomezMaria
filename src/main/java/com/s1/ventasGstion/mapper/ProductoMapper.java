package com.s1.ventasGstion.mapper;

import com.s1.ventasGstion.dto.request.ProductoRequestDTO;
import com.s1.ventasGstion.dto.request.VentaRequestDTO;
import com.s1.ventasGstion.dto.response.ProductoResponseDTO;
import com.s1.ventasGstion.dto.response.VentaResponseDTO;
import com.s1.ventasGstion.model.Producto;
import org.springframework.stereotype.Component;


@Component
public class ProductoMapper {

    //conversion de entidad(modelo desde la base de datos) a dto( la estructura y data manipulada)
    public ProductoResponseDTO entidadaDTO(Producto productoMapper){
        if (productoMapper == null) return null;
        return new ProductoResponseDTO(
                productoMapper.getNombre(), productoMapper.getDescripcion(), productoMapper.getPrecio(), productoMapper.getStock()
        );

    }


    //Conversion de DTO a entidad

    public Producto DTOaEntidad (ProductoResponseDTO dto){

        if (dto == null) return null;
        Producto p= new Producto();
        p.setNombre(dto.nombre());
        p.setDescripcion(dto.descripcion());
        p.setPrecio(dto.precio());
        p.setStock(dto.stock());
        return p;
    }

    // Actualizacion de entidad desde DTO

    public void actualizarEntidadDesdeDTO(Producto productoMapper, ProductoRequestDTO dto ){

        if (productoMapper == null || dto == null) return;
        productoMapper.setNombre(dto.nombre());
        productoMapper.setDescripcion(dto.descripcion());
        productoMapper.setPrecio(dto.precio());
        productoMapper.setStock(dto.stock());
    }
}
