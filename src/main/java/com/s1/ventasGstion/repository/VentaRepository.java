package com.s1.ventasGstion.repository;

import com.s1.ventasGstion.model.Producto;
import com.s1.ventasGstion.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//Es el JPA, transforma o genera codigo SQL con texto entendible
//Hibernate es el   ueq hace el puente con el JPA y la base de datos

@Repository
public interface VentaRepository  extends JpaRepository<Venta, Long> {
    //select * from venta where fecha fecha1 between fecha2;
    List<Venta> findByFechaBetween(Date fecha1, Date fecha2);
    // Lo que retorna, que necesito que JPA haga con base a su estructura, parametros
    //camelCase = JPA | mysql= snakecase | Clases PascalCase
    Venta findBytotalGreaterThan(BigDecimal totalBusqueda);



}
