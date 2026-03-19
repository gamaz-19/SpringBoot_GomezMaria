package com.s1.ventasGstion.controller;

import com.s1.ventasGstion.dto.request.VentaRequestDTO;
import com.s1.ventasGstion.dto.response.VentaResponseDTO;
import com.s1.ventasGstion.service.impl.VentaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venta")
@RequiredArgsConstructor
@Tag(name = "Ventas", description = "API para la gestión de ventas del sistema")
public class VentaController {

    private final VentaServiceImpl ventaService;

    @Operation(
            summary = "Registrar una venta",
            description = "Crea un nuevo registro de venta en el sistema"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Venta registrada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping
    public ResponseEntity<VentaResponseDTO> guardar(
            @RequestBody(
                    description = "Datos de la venta a registrar",
                    required = true
            )
            @org.springframework.web.bind.annotation.RequestBody VentaRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ventaService.guardarVenta(dto));
    }

    @Operation(
            summary = "Actualizar venta",
            description = "Actualiza la información de una venta existente mediante su ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Venta actualizada correctamente"),
            @ApiResponse(responseCode = "404", description = "Venta no encontrada"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PutMapping("/{id}")
    public ResponseEntity<VentaResponseDTO> actualizar(
            @RequestBody(
                    description = "Datos actualizados de la venta",
                    required = true
            )
            @org.springframework.web.bind.annotation.RequestBody VentaRequestDTO dto,

            @Parameter(description = "ID de la venta a actualizar", example = "1")
            @PathVariable Long id) {

        return ResponseEntity
                .ok()
                .body(ventaService.actualizarVenta(dto, id));
    }

    @Operation(
            summary = "Listar ventas",
            description = "Obtiene la lista de todas las ventas registradas"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de ventas obtenida correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public ResponseEntity<List<VentaResponseDTO>> listarTodos() {

        return ResponseEntity
                .ok()
                .body(ventaService.listaVenta());
    }

    @Operation(
            summary = "Buscar venta por ID",
            description = "Obtiene una venta específica mediante su ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Venta encontrada"),
            @ApiResponse(responseCode = "404", description = "Venta no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<VentaResponseDTO> buscarId(
            @Parameter(description = "ID de la venta", example = "1")
            @PathVariable Long id) {

        return ResponseEntity
                .ok()
                .body(ventaService.buscarPorID(id));
    }
}