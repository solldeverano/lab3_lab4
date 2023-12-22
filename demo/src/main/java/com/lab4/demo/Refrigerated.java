package com.lab4.demo;

public class Refrigerated extends Item{


    public Refrigerated(Long ID, double weight, int count, int containerID, String type) {
        super(ID, weight, count,  type);
    }

    @Override
    public double getTotalWeight() {
        return 0;
    }
}
