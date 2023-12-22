package com.lab4.demo.controller;

import com.lab4.demo.Container;
import com.lab4.demo.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/containers")
public class ContainerController {
    private final ContainerService containerService;

    @Autowired
    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @GetMapping
    public List<Container> getAllContainers() {
        return containerService.getAllContainers();
    }

    @GetMapping("/{containerId}")
    public Container getContainerById(@PathVariable Long containerId) {
        return containerService.getContainerById(containerId);
    }

    @PostMapping
    public Container saveContainer(@RequestBody Container container) {
        return containerService.saveContainer(container);
    }

    @DeleteMapping("/{containerId}")
    public void deleteContainer(@PathVariable Long containerId) {
        containerService.deleteContainer(containerId);
    }
}
