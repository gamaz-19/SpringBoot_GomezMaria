package com.s1.ventasGstion.mapper;


import com.s1.ventasGstion.dto.request.VentaRequestDTO;
import com.s1.ventasGstion.dto.response.VentaResponseDTO;
import com.s1.ventasGstion.model.Venta;
import org.springframework.stereotype.Component;


//Los mapas siempre tienen que ser componentes para usarse en la converision y manipulacion de entidades y DTO
@Component
public class VentaMapper {

    //conversion de entidad(modelo desde la base de datos) a dto( la estructura y data manipulada)
    public VentaResponseDTO entidadaDTO(Venta ventaMapper){
        if (ventaMapper == null) return null;
        return new VentaResponseDTO(
                ventaMapper.getId(),ventaMapper.getFecha(), ventaMapper.getTotal()
        );

    }


    //Conversion de DTO a entidad

    public Venta DTOaEntidad (VentaRequestDTO dto){

        if (dto == null) return null;
        Venta v= new Venta();
        v.setFecha(dto.fecha());
        v.setTotal(dto.total());
        return v;
    }

    // Actualizacion de entidad desde DTO

    public void actualizarEntidadDesdeDTO(Venta ventaMapper, VentaRequestDTO dto ){

        if (ventaMapper == null || dto == null) return;
        ventaMapper.setFecha(dto.fecha());
        ventaMapper.setTotal(dto.total());
    }
}
