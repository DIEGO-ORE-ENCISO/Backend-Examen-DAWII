package com.diego.backend.service;

import com.diego.backend.interfaces.IVehiculo;
import com.diego.backend.models.Vehiculo;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehiculoServiceImpl implements IVehiculo {


    @Override
    public Optional<Vehiculo> buscarVehiculoPorPlaca(String placa) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream("vehiculos.txt")))) {
            List<Vehiculo> vehiculos = reader.lines()
                    .map(line -> {
                        String[] data = line.split(";");
                        return new Vehiculo(data[1], data[2], data[3],
                                Integer.parseInt(data[4]), Double.parseDouble(data[5]), data[6]);
                    })
                    .collect(Collectors.toList());

            return vehiculos.stream()
                    .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                    .findFirst();

        } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo de vehículos", e);
        }
    }
}
