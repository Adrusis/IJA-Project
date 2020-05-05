package ija.ija2019.homework2.maps;

import ija.ija2019.homework2.MyMaps.MyStreet;

import java.util.List;

public interface Street {

    public String getId();

    public List<Coordinate> getCoordinates();

    public Coordinate begin();

    public Coordinate end();

    public boolean follows(Street s);

    public static Street defaultStreet(String id,Coordinate ... coordinates){
        if(coordinates.length == 3){
            int diffX = coordinates[2].diffX(coordinates[1]);
            int diffY = coordinates[2].diffY(coordinates[1]);
            if((diffX != 0) && (diffY != 0)){
                return null;
            }
        }
        return new MyStreet(id, coordinates);
    }

    public List<Stop> getStops();


    public boolean addStop(Stop stop);
}