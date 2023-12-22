package com.lab4.demo;

public class MediumShip extends Ship{
    public MediumShip(Long ID, double fuel, Port currentPort, int totalWeightCapacity, int maxNumberOfAllContainers, int maxNumberOfHeavyContainers, int maxNumberOfLiquidContainers, int maxNumberOfRefrigeratedContainers, double fuelConsumptionPerKM) {
        super(ID, fuel, currentPort, totalWeightCapacity, maxNumberOfAllContainers, maxNumberOfHeavyContainers, maxNumberOfLiquidContainers, maxNumberOfRefrigeratedContainers, fuelConsumptionPerKM);
    }
}
