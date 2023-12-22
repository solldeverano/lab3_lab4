package com.lab4.demo;

public class LiquidContainer extends HeavyContainer {
    public LiquidContainer(Long ID, int weight, String type) {
        super(ID, weight, type);
    }

    @Override
    public double consumption() {
        return 4.00 * weight;
    }
}
