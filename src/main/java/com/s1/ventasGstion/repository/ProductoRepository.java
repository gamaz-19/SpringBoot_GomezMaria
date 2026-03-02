package com.s1.ventasGstion.repository;

import com.s1.ventasGstion.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    //Consultas para la base de datos, no son obligatorias, ya trae unaas por defecto

    List<Producto>  findByPrecioGreaterThan(BigDecimal precioLimite);
    Producto  findByTopByprecioDesc();

}
