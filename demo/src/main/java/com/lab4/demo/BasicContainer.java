package com.lab4.demo;

public class BasicContainer extends Container {
    public BasicContainer(Long ID, int weight, String type) {
        super(ID, weight, type);
    }

    @Override
    public double consumption() {
        return 2.50 * weight;
    }
}
