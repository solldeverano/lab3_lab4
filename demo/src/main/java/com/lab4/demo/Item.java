package com.lab4.demo;


import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private double weight;
    private int count;

    // Одразу після додавання цих двох полів
    @ManyToOne
    @JoinColumn(name = "container_id")
    private Container container;

    @Column(name = "type")
    private String type;

    public Item(Long ID, double weight, int count, String type) {
        this.ID = ID;
        this.weight = weight;
        this.count = count;
        this.type = type;
    }

    // Інші методи, які вам потрібні для конкретного товару

    public Long getID() {
        return ID;
    }

    public double getWeight() {
        return weight;
    }

    public int getCount() {
        return count;
    }


    public String getType() {
        return type;
    }

    public double getTotalWeight() {
        return weight * count;
    }
}
