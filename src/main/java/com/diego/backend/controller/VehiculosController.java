package com.diego.backend.controller;

import com.diego.backend.dto.BuscarVehiculoRequest;
import com.diego.backend.models.Vehiculo;
import com.diego.backend.service.VehiculoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculosController {

    @Autowired
    private VehiculoServiceImpl service;

    @PostMapping("/buscar")
    public ResponseEntity<?> buscar(@RequestBody BuscarVehiculoRequest request) {
        Optional<Vehiculo> vehiculoOpt = service.buscarVehiculoPorPlaca(request.getPlaca());

        if (vehiculoOpt.isPresent()) {
            return ResponseEntity.ok(vehiculoOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró un vehículo para la placa ingresada.");
        }
    }


}
