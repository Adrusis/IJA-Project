package ija.ija2019.homework2.MyMaps;

import ija.ija2019.homework2.maps.Coordinate;
import ija.ija2019.homework2.maps.Stop;
import ija.ija2019.homework2.maps.Street;

import java.util.Objects;

public class MyStop implements Stop {
    private final String id;
    private Coordinate coordinate;
    private Street street;

    public MyStop(String id, Coordinate c) {
        this.id = id;
        this.coordinate = c;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Coordinate getCoordinate() {
        if (coordinate.equals(null)){
            return null;
        }
        return coordinate;
    }

    @Override
    public void setStreet(Street s) {
        street = s;
    }

    @Override
    public Street getStreet() {
        if (street==null){
            return null;
        }
        return street;
    }

    @Override
    public String toString() {
        return "stop("+this.id+")" ;
    }
}
