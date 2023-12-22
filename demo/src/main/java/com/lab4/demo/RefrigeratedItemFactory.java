package com.lab4.demo;

public class RefrigeratedItemFactory implements ItemFactory{
    @Override
    public Item createItem(Long ID, double weight, int count, int containerID) {
        return new Refrigerated(ID, weight, count, containerID, "Refrigerated");
    }
}
