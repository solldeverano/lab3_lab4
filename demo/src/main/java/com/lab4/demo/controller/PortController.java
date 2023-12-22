package com.lab4.demo.controller;

import com.lab4.demo.Port;
import com.lab4.demo.service.PortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ports")
public class PortController {
    private final PortService portService;
    @Autowired
    public PortController(PortService portService) {
        this.portService = portService;
    }
    @GetMapping
    public List<Port> getAllPorts() {
        return portService.getAllPorts();
    }

    @GetMapping("/{portId}")
    public Port getPortById(@PathVariable Long portId) {
        return portService.getPortById(portId);
    }

    @PostMapping
    public Port savePort(@RequestBody Port port) {
        return portService.savePort(port);
    }

    @DeleteMapping("/{portId}")
    public void deletePort(@PathVariable Long portId) {
        portService.deletePort(portId);
    }


}
