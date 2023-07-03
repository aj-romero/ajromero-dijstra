package com.dijstra.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class City {
    private String name;
    private int cost;

    public City(int cost){
        this.cost = cost;
    }
}
