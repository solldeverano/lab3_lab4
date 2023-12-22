package com.lab4.demo;

public class Liquid extends Item{
    public Liquid(Long ID, double weight, int count, String type) {
        super(ID, weight, count,  type);
    }

    @Override
    public double getTotalWeight() {
        return 0;
    }
}
