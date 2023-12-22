package com.lab4.demo.service;

import com.lab4.demo.Port;
import com.lab4.demo.repository.PortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortService {
    private final PortRepository  portRepository;
    @Autowired
    public PortService(PortRepository portRepository) {
        this.portRepository = portRepository;
    }
    public List<Port> getAllPorts() {
        return portRepository.findAll();
    }

    public Port getPortById(Long portId) {
        return portRepository.findById(portId).orElse(null);
    }

    public Port savePort(Port port) {
        return portRepository.save(port);
    }

    public void deletePort(Long portId) {
        portRepository.deleteById(portId);
    }
}
