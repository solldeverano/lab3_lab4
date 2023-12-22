package com.lab4.demo;

public class HeavyItemFactory implements ItemFactory {

    @Override
    public Item createItem(Long ID, double weight, int count, int containerID) {
        return new Heavy(ID, weight, count, containerID, "Heavy");
    }
}
