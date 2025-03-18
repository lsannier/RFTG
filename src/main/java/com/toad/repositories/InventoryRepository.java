package com.toad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.toad.entities.Inventory;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface InventoryRepository extends CrudRepository<Inventory, Integer> {

    
    @Query(value ="SELECT inventory.store_id, inventory.film_id, film.title, store.address_id, address.address, address.district, COUNT(*) FROM inventory INNER JOIN film ON inventory.film_id = film.film_id INNER JOIN store ON inventory.store_id = store.store_id INNER JOIN address ON store.address_id = address.address_id GROUP BY inventory.store_id, inventory.film_id, film.title, store.address_id, address.address, address.district;", nativeQuery = true)

    List<Object[]> findGroupedInventory();

    @Query(value = "SELECT i.film_id, "
            + "COUNT(i.inventory_id) AS total_stock, "
            + "COUNT(DISTINCT r.inventory_id) AS total_loues, "
            + "COUNT(i.inventory_id) - COUNT(DISTINCT r.inventory_id) AS films_disponibles "
            + "FROM inventory i "
            + "LEFT JOIN rental r ON i.inventory_id = r.inventory_id AND r.return_date IS NULL "
            + "GROUP BY i.film_id "
            + "ORDER BY i.film_id ASC", nativeQuery = true)
    List<Object[]> findInventoryStockInfo();

}