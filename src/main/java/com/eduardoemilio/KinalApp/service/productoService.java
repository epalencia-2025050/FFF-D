package com.eduardoemilio.KinalApp.service;

import com.eduardoemilio.KinalApp.entity.Producto;
import com.eduardoemilio.KinalApp.entity.Venta;
import com.eduardoemilio.KinalApp.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class productoService implements IProductosService{

    private final ProductoRepository productoRepository;

    public productoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarProducto() {
        return productoRepository.findAll();
    }

    @Override
    public List<Producto> listarPorEstadoP(int estado) {
        return productoRepository.findByEstado(estado);
    }

    @Override
    public Producto guardarP(Producto producto) {
        ValidarProducto(producto);
        if(producto.getEstado()==0);
        producto.setEstado(1);
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> buscarPorCode(int code) {
        return productoRepository.findById(code);
    }

    @Override
    public Producto actualizarP(int code, Producto producto) {
        if(!productoRepository.existsById(code)){

        }
        producto.setCodigoProducto(code);
        ValidarProducto(producto);
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarP(int code) {
        if(!productoRepository.existsById(code)){
            throw new RuntimeException("No se Encontro El producto");
        }
        productoRepository.deleteById(code);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existPcode(int code) {
        return productoRepository.existsById(code);
    }

    private void ValidarProducto(Producto producto){
        if(producto == null)
            throw new IllegalArgumentException("Producto no puede ser null");
        if(producto.getNombreProducto() == null || producto.getNombreProducto().trim().isEmpty() )
            throw new IllegalArgumentException("El nombre no puede ser null");
        if(producto.getPrecio() == 0)
            throw new IllegalArgumentException("el Precio no puede ser cero");
        if(producto.getEstado() > 1)
            throw new IllegalArgumentException("el estado no puede ser mayor a uno");
        if(producto.getStock() <= 0)
            throw new IllegalArgumentException("el Stock no puede ser menor a cero o igual a cero");
    }

}
