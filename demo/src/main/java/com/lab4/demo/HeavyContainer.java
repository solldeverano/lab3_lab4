package com.lab4.demo;

public class HeavyContainer extends Container {
    public HeavyContainer(Long ID, int weight, String type) {
        super(ID, weight, type);
    }

    @Override
    public double consumption() {
        return 3.00 * weight;
    }
}
