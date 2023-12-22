package com.lab4.demo.controller;

import com.lab4.demo.Ship;
import com.lab4.demo.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ships")
public class ShipController {
    private final ShipService shipService;

    @Autowired
    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping
    public List<Ship> getAllShips() {
        return shipService.getAllShips();
    }

    @GetMapping("/{shipId}")
    public Ship getShipById(@PathVariable Long shipId) {
        return shipService.getShipById(shipId);
    }

    @PostMapping
    public Ship saveShip(@RequestBody Ship ship) {
        return shipService.saveShip(ship);
    }

    @DeleteMapping("/{shipId}")
    public void deleteShip(@PathVariable Long shipId) {
        shipService.deleteShip(shipId);
    }
}
