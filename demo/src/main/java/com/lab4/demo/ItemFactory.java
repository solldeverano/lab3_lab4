package com.lab4.demo;

public interface ItemFactory {
    Item createItem(Long ID, double weight, int count, int containerID);
}
