package com.s1.ventasGstion.controller;

import com.s1.ventasGstion.dto.request.ProductoRequestDTO;
import com.s1.ventasGstion.dto.response.ProductoResponseDTO;
import com.s1.ventasGstion.service.impl.ProductoServiceImpl;
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
@RequestMapping("/api/producto")
@RequiredArgsConstructor
@Tag(name = "Productos", description = "API para la gestión de productos del sistema")
public class ProductoController {

    private final ProductoServiceImpl productoService;

    @Operation(
            summary = "Crear un producto",
            description = "Registra un nuevo producto en el sistema"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping
    public ResponseEntity<ProductoResponseDTO> guardar(
            @RequestBody(
                    description = "Datos del producto a crear",
                    required = true
            )
            @org.springframework.web.bind.annotation.RequestBody ProductoRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productoService.guardarProducto(dto));
    }

    @Operation(
            summary = "Actualizar producto",
            description = "Actualiza la información de un producto existente mediante su ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizar(
            @RequestBody(
                    description = "Datos actualizados del producto",
                    required = true
            )
            @org.springframework.web.bind.annotation.RequestBody ProductoRequestDTO dto,

            @Parameter(description = "ID del producto a actualizar", example = "1")
            @PathVariable Long id) {

        return ResponseEntity
                .ok()
                .body(productoService.actualizarProducto(dto, id));
    }

    @Operation(
            summary = "Listar productos",
            description = "Obtiene la lista de todos los productos registrados"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de productos obtenida correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> listarTodos() {

        return ResponseEntity
                .ok()
                .body(productoService.listaProducto());
    }

    @Operation(
            summary = "Buscar producto por ID",
            description = "Obtiene un producto específico mediante su ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto encontrado"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> buscarId(
            @Parameter(description = "ID del producto", example = "1")
            @PathVariable Long id) {

        return ResponseEntity
                .ok()
                .body(productoService.buscarPorID(id));
    }

    @Operation(
            summary = "Eliminar producto",
            description = "Elimina un producto del sistema mediante su ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Producto eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "ID del producto a eliminar", example = "1")
            @PathVariable Long id) {

        productoService.eliminarPorID(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}