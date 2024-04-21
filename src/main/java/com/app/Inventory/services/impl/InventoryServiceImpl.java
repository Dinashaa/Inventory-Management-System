package com.app.Inventory.services.impl;

import com.app.Inventory.model.Inventory;
import com.app.Inventory.repository.InventoryRepository;
import com.app.Inventory.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public Inventory addInventoryItem(Inventory inventoryItem) {
        inventoryItem.setCreatedDate(LocalDateTime.now());
        return inventoryRepository.insert(inventoryItem);
    }

    @Override
    public Inventory updateInventoryItem(Inventory inventoryItem) {
        inventoryItem.setUpdatedDate(LocalDateTime.now());
        return inventoryRepository.save(inventoryItem);
    }

    @Override
    public String deleteInventoryItem(String id) {
        inventoryRepository.deleteById(id);
        return id;
    }

    @Override
    public Inventory getInventoryItemById(String id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Inventory> getAllInventoryItems() {
        return inventoryRepository.findAll();
    }

}

