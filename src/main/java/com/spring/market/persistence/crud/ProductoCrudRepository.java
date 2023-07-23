package com.spring.market.persistence.crud;

import com.spring.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Long> {

    List<Producto> findByIdCategoriaOrderByNombreAsc(long idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(long cantidadStock, boolean estado);

}
