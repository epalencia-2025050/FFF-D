package com.eduardoemilio.KinalApp.controller;

import com.eduardoemilio.KinalApp.service.IProductosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Productos")
public class ProductoController {

    private final IProductosService productosService;

    public ProductoController(IProductosService productosService) {
        this.productosService = productosService;
    }


}
