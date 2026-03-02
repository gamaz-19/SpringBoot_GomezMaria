package com.s1.ventasGstion.controller;

import com.s1.ventasGstion.dto.request.VentaRequestDTO;
import com.s1.ventasGstion.dto.response.VentaResponseDTO;
import com.s1.ventasGstion.service.impl.VentaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venta")
@RequiredArgsConstructor
//@Tag(name = "Ventas", description = "API para la gestion de ventas del sistema")

public class VentaController {
    private final VentaServiceImpl ventaService;

    @PostMapping
    public ResponseEntity<VentaResponseDTO> guardar(
            @RequestBody VentaRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ventaService.guardarVenta(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaResponseDTO> actualizar(
            @RequestBody VentaRequestDTO dto,
            @PathVariable Long id) {

        return ResponseEntity
                .ok()
                .body(ventaService.actualizarVenta(dto, id));
    }

    @GetMapping
    public ResponseEntity<List<VentaResponseDTO>> listarTodos() {

        return ResponseEntity
                .ok()
                .body(ventaService.listaVenta());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaResponseDTO> buscarId(
            @PathVariable Long id) {

        return ResponseEntity
                .ok()
                .body(ventaService.buscarPorID(id));
    }
}
