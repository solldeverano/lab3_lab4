package com.lab4.demo;

public interface ShipBuilder {
    void buildID(Long ID);
    void buildFuel(double fuel);
    void buildCurrentPort(Port currentPort);
    void buildTotalWeightCapacity(int totalWeightCapacity);
    void buildMaxNumberOfAllContainers(int maxNumberOfAllContainers);
    void buildMaxNumberOfHeavyContainers(int maxNumberOfHeavyContainers);
    void buildMaxNumberOfRefrigeratedContainers(int maxNumberOfRefrigeratedContainers);
    void buildMaxNumberOfLiquidContainers(int maxNumberOfLiquidContainers);
    void buildFuelConsumptionPerKM(double fuelConsumptionPerKM);

    Ship getShip(); // Доданий метод
}
