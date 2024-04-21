package com.app.Inventory.controller;

import com.app.Inventory.model.Inventory;
import com.app.Inventory.services.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/add")
    public ResponseEntity<Inventory> addInventoryItem(@RequestBody Inventory inventory) {
        try {
            return new ResponseEntity<>(inventoryService.addInventoryItem(inventory), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("An error has occurred: {}", e.getMessage(), e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteInventoryItem(@PathVariable(value = "id") String id) {
        try {
            return new ResponseEntity<>(inventoryService.deleteInventoryItem(id), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("An error has occurred: {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Inventory> updateInventoryItem(@RequestBody Inventory inventory) {
        try {
            return new ResponseEntity<>(inventoryService.updateInventoryItem(inventory), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("An error has occurred: {}", e.getMessage(), e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryItemById(@PathVariable(value = "id") String id) {
        try {
            return new ResponseEntity<>(inventoryService.getInventoryItemById(id), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("An error has occurred: {}", e.getMessage(), e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Inventory>> getAllInventoryItems() {
        try {
            return new ResponseEntity<>(inventoryService.getAllInventoryItems(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("An error has occurred: {}", e.getMessage(), e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
