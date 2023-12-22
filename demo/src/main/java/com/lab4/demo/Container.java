package com.lab4.demo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "containers")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ID;
    int weight;
    @Column(name = "type")
    String type;
    @OneToMany(mappedBy = "container", cascade = CascadeType.ALL)
    List<Item> items;

    @ManyToOne
    @JoinColumn(name = "port_id")
    private Port port;
    @ManyToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;


// Додайте список для зберігання товарів

    public Container(Long ID, int weight, String type) {
        this.ID = ID;
        this.weight = weight;
        this.type = type;
        this.items = new ArrayList<>();
    }

    public void addItemToContainer(Item item, Port port) {
        // Перевіряємо, чи можна завантажити даний товар до контейнера
        if (canLoadItem(item) && !isFull()) {
            items.add(item); // Додаємо товар до контейнера
            // Видаліть товар з порту, якщо він був раніше доданий до порту
            if (port != null) {
                port.removeItemFromPort(item);
            }
        } else {
            System.out.println("Помилка: Неможливо завантажити товар ID " + item.getID() + " до контейнера " + this.getID());
        }
    }

    public boolean canLoadItem(Item item) {
        // Перевіряємо, чи тип товару співпадає з типом контейнера (приклад загальної перевірки)
        return this.type.equals(item.getType());
    }

    public boolean isFull() {
        // Перевіряємо, чи кількість товарів у контейнері перевищує певний ліміт (приклад загальної перевірки)
        int maxCapacity = 2000; // Максимальна кількість товарів, яку контейнер може вмістити
        return items.size() >= maxCapacity;
    }

    public abstract double consumption();

    public Long getID() {
        return ID;
    }

    public int getWeight() {
        return weight;
    }

    public boolean equals(Container other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() == this.getClass() && other.ID == this.ID && other.weight == this.weight) {
            return true;
        }

        return false;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getType() {
        return type;
    }
}
