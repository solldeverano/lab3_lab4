package com.lab4.demo;

public class RefrigeratedContainer extends HeavyContainer {
    public RefrigeratedContainer(Long ID, int weight, String type) {
        super(ID, weight, type);
    }

    @Override
    public double consumption() {
        return 5.00 * weight;
    }
}
