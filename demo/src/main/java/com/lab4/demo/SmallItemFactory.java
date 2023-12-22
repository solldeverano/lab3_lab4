package com.lab4.demo;

public class SmallItemFactory implements ItemFactory{

    @Override
    public Item createItem(Long ID, double weight, int count, int containerID) {
        return new Small(ID, weight, count, containerID, "Small");
    }

}
