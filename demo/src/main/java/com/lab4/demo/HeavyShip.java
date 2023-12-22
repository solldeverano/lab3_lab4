package com.lab4.demo;

public class HeavyShip extends Ship{
    public HeavyShip(Long ID, double fuel, Port currentPort, int totalWeightCapacity, int maxNumberOfAllContainers, int maxNumberOfHeavyContainers, int maxNumberOfLiquidContainers, int maxNumberOfRefrigeratedContainers, double fuelConsumptionPerKM) {
        super(ID, fuel, currentPort, totalWeightCapacity, maxNumberOfAllContainers, maxNumberOfHeavyContainers, maxNumberOfLiquidContainers, maxNumberOfRefrigeratedContainers, fuelConsumptionPerKM);
    }
}
