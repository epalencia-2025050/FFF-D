package com.eduardoemilio.KinalApp.service;

import com.eduardoemilio.KinalApp.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductosService {
    List<Producto> listarProducto();
    List<Producto> listarPorEstadoP(int estado);
    Producto guardarP(Producto producto);
    Optional<Producto> buscarPorCode(int code);
    Producto actualizarP(int code, Producto producto);
    void eliminarP(int code);
    boolean existPcode(int code);

}
