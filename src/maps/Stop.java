package ija.ija2019.homework2.maps;

import ija.ija2019.homework2.MyMaps.MyStop;

public interface Stop {

    public String getId();


    public Coordinate getCoordinate();


    public void setStreet(Street s);

    public static Stop defaultStop(String id, Coordinate c) {
        return new MyStop(id, c);
    }


    public Street getStreet();
}

