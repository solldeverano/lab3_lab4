package com.lab4.demo;

public class Small extends Item{
    public Small(Long ID, double weight, int count, int containerID, String type) {

        super(ID, weight, count,type);
    }


    @Override
    public double getTotalWeight() {
        return 0;
    }
}
