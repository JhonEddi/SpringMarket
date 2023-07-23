package com.spring.market.persistence;

import com.spring.market.persistence.crud.ProductoCrudRepository;
import com.spring.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(long idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(long cantidad) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto(long idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

    public Producto saveProducto(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    public void deleteProducto(long idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}
