package com.toad.repositories;
 
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.toad.entities.Inventory;
 
public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
 
    @Query(value ="SELECT inventory.store_id, inventory.film_id, film.title, store.address_id, address.address, address.district, COUNT(*) FROM inventory INNER JOIN film ON inventory.film_id = film.film_id INNER JOIN store ON inventory.store_id = store.store_id INNER JOIN address ON store.address_id = address.address_id GROUP BY inventory.store_id, inventory.film_id, film.title, store.address_id, address.address, address.district;", nativeQuery = true)
 
    List<Object[]> findGroupedInventory();
}