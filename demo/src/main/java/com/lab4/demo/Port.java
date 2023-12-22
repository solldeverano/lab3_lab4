package com.lab4.demo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "ports")
public class Port implements IPort{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ID;

    double latitude;
    double longitude;
    @OneToMany(mappedBy = "port")
    private List<Container> containers = new ArrayList<>();
    private ArrayList<Ship> history = new ArrayList<>();
    private ArrayList<Ship> current = new ArrayList<>();
    private List<Item> items = new ArrayList<>();





    public Port(int ID, double latitude, double longitude) {
        this.ID = ID;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public void addItem(Item item) {
        items.add(item);
    }

    public void loadItemsIntoContainers(List<Item> items) {
        List<Item> itemsToLoad = new ArrayList<>(items);

        for (Item item : itemsToLoad) {
            boolean loaded = false;
            for (Container container : containers) {
                if (container.canLoadItem(item) && !container.isFull()) {
                    container.addItemToContainer(item, this);
                    loaded = true;
                    break;
                }
            }
            if (loaded) {
                items.remove(item); // Видаляємо товар зі списку після завантаження в контейнер
            }
        }
    }




    public void unloadItemsFromContainers() {
        for (Container container : containers) {
            List<Item> itemsInContainer = container.getItems();
            for (Item item : itemsInContainer) {
                System.out.println("Розвантаження товару ID " + item.getID() + " з контейнера в порту " + this.getID());
                addItem(item);
            }
            itemsInContainer.clear(); // Очищаємо товари з контейнера після розвантаження
        }
    }


    public void removeItemFromPort(Item item) {
        items.remove(item); // Видаляємо товар з порту
    }

    @Override
    public void incomingShip(Ship s){
        s.setCurrentPort(this);
        current.add(s);

        // Додайте контейнери, які були розвантажені з корабля, до порту
        for (Container container : s.getCurrentContainers()) {
            containers.add(container);
        }

    }
    @Override
    public void outgoingShip(Ship s) {
        s.setCurrentPort(null);
        current.remove(s);
        history.add(s);
    }
    public void removeContainer(Container container) {
        containers.remove(container);
    }

    public double getDistance(Port other) {
        final int R = 6371;
        double latitude1 = Math.toRadians(this.latitude);
        double longitude1 = Math.toRadians(this.longitude);
        double latitude2 = Math.toRadians(other.latitude);
        double longitude2 = Math.toRadians(other.longitude);

        double deltaLat = latitude2 - latitude1;
        double deltaLong = longitude2 - longitude1;

        double a = Math.pow(Math.sin(deltaLat / 2), 2) + Math.cos(latitude1) * Math.cos(latitude2) * Math.pow(Math.sin(deltaLong / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = R*c;
        return distance;
    }









    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    // Додайте метод, який дозволить додавати контейнери до порту
    public void addContainer(Container container) {
        containers.add(container);
    }

    // Додайте метод, який дозволить отримувати список контейнерів у порту
    public List<Container> getContainers() {
        return containers;
    }


    public ArrayList<Ship> getCurrentShips() {
        return current;
    }




    public ArrayList<Ship> getHistory() {
        return history;
    }


    public ArrayList<Ship> getCurrent() {
        return current;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public List<Item> getItems() {
        return items;
    }

}
