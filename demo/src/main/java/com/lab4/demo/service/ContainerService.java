package com.lab4.demo.service;

import com.lab4.demo.Container;
import com.lab4.demo.repository.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainerService {
    private final ContainerRepository containerRepository;

    @Autowired
    public ContainerService(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    public List<Container> getAllContainers() {
        return containerRepository.findAll();
    }

    public Container getContainerById(Long containerId) {
        return containerRepository.findById(containerId).orElse(null);
    }

    public Container saveContainer(Container container) {
        return containerRepository.save(container);
    }

    public void deleteContainer(Long containerId) {
        containerRepository.deleteById(containerId);
    }
}
