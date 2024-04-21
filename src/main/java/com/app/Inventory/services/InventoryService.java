package com.app.Inventory.services;

import com.app.Inventory.model.Inventory;

import java.util.List;

public interface InventoryService {
    Inventory addInventoryItem(Inventory inventoryItem);

    Inventory updateInventoryItem(Inventory inventoryItem);

    String deleteInventoryItem(String id);

    Inventory getInventoryItemById(String id);

    List<Inventory> getAllInventoryItems();


}
