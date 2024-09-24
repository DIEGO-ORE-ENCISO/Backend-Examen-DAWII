package com.diego.backend.interfaces;

import com.diego.backend.models.Vehiculo;

import java.util.Optional;


public interface IVehiculo {

    Optional<Vehiculo> buscarVehiculoPorPlaca(String placa) ;
}
