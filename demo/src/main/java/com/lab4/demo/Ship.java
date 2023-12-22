package com.lab4.demo;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "ships")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Ship implements IShip{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ID;
    double fuel;
    @ManyToOne
    @JoinColumn(name = "port_id")
    Port currentPort;
    int totalWeightCapacity;
    int maxNumberOfAllContainers;
    int maxNumberOfHeavyContainers;
    int maxNumberOfRefrigeratedContainers;

    public void setMaxNumberOfLiquidContainers(int maxNumberOfLiquidContainers) {
        this.maxNumberOfLiquidContainers = maxNumberOfLiquidContainers;
    }

    int maxNumberOfLiquidContainers;

    double fuelConsumptionPerKM;



    public Ship(Long ID, double fuel, Port currentPort, int totalWeightCapacity, int maxNumberOfAllContainers, int maxNumberOfHeavyContainers, int maxNumberOfLiquidContainers, int maxNumberOfRefrigeratedContainers, double fuelConsumptionPerKM) {
        this.ID = ID;
        this.fuel = fuel;
        this.currentPort = currentPort;
        this.totalWeightCapacity = totalWeightCapacity;
        this.maxNumberOfAllContainers = maxNumberOfAllContainers;
        this.maxNumberOfHeavyContainers = maxNumberOfHeavyContainers;
        this.maxNumberOfLiquidContainers = maxNumberOfLiquidContainers;
        this.maxNumberOfRefrigeratedContainers = maxNumberOfRefrigeratedContainers;
        this.fuelConsumptionPerKM = fuelConsumptionPerKM;
    }

    @ElementCollection
    @OneToMany(mappedBy = "ship", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Container> containers = new HashSet<>();


    @Override
  public boolean sailTo(Port p) {
      if(currentPort.equals(p)){
          return false;
      }
      double distance = currentPort.getDistance(p);
      double fuelRequired = distance * fuelConsumptionPerKM;
      if(fuelRequired> fuel) {
          System.out.println("Not enough fuel for the trip!!!");
          return false;
      }
      fuel -= fuelRequired;
      currentPort.outgoingShip(this);
      p.incomingShip(this);
      currentPort = p;
      System.out.println("The ship successfully completed the voyage and arrived at the port" + p.getID());
      System.out.println("The rest of the fuel : " + fuel);
      return true;
    }

    @Override
    public void reFuel(double newFuel) {
      if(newFuel>0){
          fuel+=newFuel;
          System.out.println("Fuel added succsessfuly!!!");
      } else {
          System.out.println("There is no new fuel, so it is not added ((((");
      }
    }

    @Override
    public boolean load(Container cont) {
        if (containers.size() >= maxNumberOfAllContainers) {
            System.out.println("The ship is too full, so it will not take container with ID " + cont.getID());
            return false;
        }

        for (Container existingContainer : containers) {
            if (existingContainer.equals(cont)) {
                System.out.println("A container with the same type, ID, and weight already exists on the ship.");
                return false;
            }
        }

        if (cont instanceof HeavyContainer && containers.size() >= maxNumberOfHeavyContainers) {
            System.out.println("The ship is too full, so it will not take Heavy container with ID " + cont.getID());
            return false;
        }

        if (cont instanceof RefrigeratedContainer && containers.size() >= maxNumberOfRefrigeratedContainers) {
            System.out.println("The ship is too full, so it will not take Refrigerated container with ID: " + cont.getID());
            return false;
        }

        if (cont.weight > totalWeightCapacity) {
            System.out.println("This container with ID: " + cont.getID() + " is too heavy for the ship.");
            return false;
        }

        // Видалення контейнера зі списку контейнерів у порту
        if (currentPort != null) {
            currentPort.removeContainer(cont);
        }

        containers.add(cont);
        System.out.println("Container with ID: " + cont.getID() + " was successfully loaded onto the ship with ID: " + ID);
        return true;
    }

    @Override
    public boolean unLoad(Container cont) {
        if (containers.contains(cont)) {
            containers.remove(cont);
            System.out.println("Container with ID: " + cont.getID() + " has been successfully unloaded from the ship.");
            if (currentPort != null) {
                currentPort.addContainer(cont); // Додайте контейнер до списку контейнерів у порту
                System.out.println("Container with ID: " + cont.getID() + " has been added to the port storage.");
            } else {
                System.out.println("Warning: The ship is not currently at any port, so the container is not added to any port storage.");
            }
            return true;
        } else {
            System.out.println("Container with ID: " + cont.getID() + " does not exist on the ship.");
            return false;
        }
    }



    public List<Container> getCurrentContainers() {
        List<Container> currentContainersCopy = new ArrayList<>(containers);
        currentContainersCopy.sort(Comparator.comparingLong((Container container) -> container.ID));
        return currentContainersCopy;

      }

    public Long getID() {
        return ID;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setCurrentPort(Port port) {
        currentPort = port;
    }

    public Port getCurrentPort() {
     //   currentPort = currentPort.getID();
        return currentPort;
    }

    public int getTotalWeightCapacity() {
        return totalWeightCapacity;
    }

    public void setTotalWeightCapacity(int totalWeightCapacity) {
        this.totalWeightCapacity = totalWeightCapacity;
    }

    public int getMaxNumberOfAllContainers() {
        return maxNumberOfAllContainers;
    }

    public void setMaxNumberOfAllContainers(int maxNumberOfAllContainers) {
        this.maxNumberOfAllContainers = maxNumberOfAllContainers;
    }

    public int getMaxNumberOfHeavyContainers() {
        return maxNumberOfHeavyContainers;
    }

    public void setMaxNumberOfHeavyContainers(int maxNumberOfHeavyContainers) {
        this.maxNumberOfHeavyContainers = maxNumberOfHeavyContainers;
    }

    public int getMaxNumberOfRefrigeratedContainers() {
        return maxNumberOfRefrigeratedContainers;
    }

    public void setMaxNumberOfRefrigeratedContainers(int maxNumberOfRefrigeratedContainers) {
        this.maxNumberOfRefrigeratedContainers = maxNumberOfRefrigeratedContainers;
    }

    public double getFuelConsumptionPerKM() {
        return fuelConsumptionPerKM;
    }

    public void setFuelConsumptionPerKM(double fuelConsumptionPerKM) {
        this.fuelConsumptionPerKM = fuelConsumptionPerKM;
    }

    public Set<Container> getContainers() {
        return containers;
    }

    public void setContainers(Set<Container> containers) {
        this.containers = containers;
    }

    public int getMaxNumberOfLiquidContainers() {
        return maxNumberOfLiquidContainers;
    }
}
