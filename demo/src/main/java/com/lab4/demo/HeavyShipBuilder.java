package com.lab4.demo;

public class HeavyShipBuilder implements ShipBuilder{

    private HeavyShip ship;
    public HeavyShipBuilder(Long ID, double fuel, Port currentPort, int totalWeightCapacity, int maxNumberOfAllContainers, int maxNumberOfHeavyContainers, int maxNumberOfLiquidContainers, int maxNumberOfRefrigeratedContainers, double fuelConsumptionPerKM) {
        this.ship = new HeavyShip(ID, fuel, currentPort, totalWeightCapacity, maxNumberOfAllContainers, maxNumberOfHeavyContainers, maxNumberOfLiquidContainers, maxNumberOfRefrigeratedContainers, fuelConsumptionPerKM);
    }
    @Override
    public void buildID(Long ID) {
        ship.setID(ID);
    }

    @Override
    public void buildFuel(double fuel) {
        ship.setFuel(fuel);
    }

    @Override
    public void buildCurrentPort(Port currentPort) {
        ship.setCurrentPort(currentPort);
    }

    @Override
    public void buildTotalWeightCapacity(int totalWeightCapacity) {
        ship.setTotalWeightCapacity(totalWeightCapacity);
    }

    @Override
    public void buildMaxNumberOfAllContainers(int maxNumberOfAllContainers) {
        ship.setMaxNumberOfAllContainers(maxNumberOfAllContainers);
    }

    @Override
    public void buildMaxNumberOfHeavyContainers(int maxNumberOfHeavyContainers) {
        ship.setMaxNumberOfHeavyContainers(maxNumberOfHeavyContainers);
    }

    @Override
    public void buildMaxNumberOfRefrigeratedContainers(int maxNumberOfRefrigeratedContainers) {
        ship.setMaxNumberOfRefrigeratedContainers(maxNumberOfRefrigeratedContainers);
    }

    @Override
    public void buildMaxNumberOfLiquidContainers(int maxNumberOfLiquidContainers) {
        ship.setMaxNumberOfLiquidContainers(maxNumberOfLiquidContainers);
    }

    @Override
    public void buildFuelConsumptionPerKM(double fuelConsumptionPerKM) {
        ship.setFuelConsumptionPerKM(fuelConsumptionPerKM);
    }

    @Override
    public Ship getShip() {
        return ship;
    }
}
