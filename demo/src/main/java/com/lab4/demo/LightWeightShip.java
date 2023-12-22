package com.lab4.demo;

public class LightWeightShip extends Ship{
    public LightWeightShip(Long ID, double fuel, Port currentPort, int totalWeightCapacity, int maxNumberOfAllContainers, int maxNumberOfHeavyContainers, int maxNumberOfLiquidContainers, int maxNumberOfRefrigeratedContainers, double fuelConsumptionPerKM) {
        super(ID, fuel, currentPort, totalWeightCapacity, maxNumberOfAllContainers, maxNumberOfHeavyContainers, maxNumberOfLiquidContainers, maxNumberOfRefrigeratedContainers, fuelConsumptionPerKM);
    }
}
