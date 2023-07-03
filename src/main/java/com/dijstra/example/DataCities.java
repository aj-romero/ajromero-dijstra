package com.dijstra.example;


public class DataCities {
    private DataCities(){}
    public static City[][] c = new City[][]{
            {new City("San Salvador",0),new City("San Vicente",63), new City("Santa Tecla",22), new City("Sonsonate",0), new City("Santa Ana",0)},
            {new City(63),new City(0), new City(0), new City(0), new City(0)},
            {new City(22),new City(0), new City(0), new City(55), new City(53)},
            {new City(0),new City(0), new City(55), new City(0), new City(23)},
            {new City(0),new City(0), new City(53), new City(23), new City(0)}
    };

}
