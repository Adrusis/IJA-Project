package ija.ija2019.homework2.MyMaps;

import ija.ija2019.homework2.maps.Coordinate;
import ija.ija2019.homework2.maps.Stop;
import ija.ija2019.homework2.maps.Street;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyStreet implements Street {
    private String id;
    private List<Coordinate> coordinates = new ArrayList<>();
    private List<Stop> stops = new ArrayList<Stop>();


    public MyStreet(String id, Coordinate[] coordinates) {
        this.id = id;
        for(int i=0; i<coordinates.length;i++){
            this.coordinates.add(coordinates[i]);
        }
    }


    @Override
    public String getId() {

        return id;
    }

    @Override
    public List<Coordinate> getCoordinates() {
        return Collections.unmodifiableList(coordinates);
    }

    @Override
    public Coordinate begin() {
        return coordinates.get(0);
    }

    @Override
    public Coordinate end() {
        return coordinates.get(coordinates.size()-1);
    }

    @Override
    public boolean follows(Street s) {
        return (this.end().getX() == s.end().getX() && this.end().getY() == s.end().getY())
                || (this.begin().getX() == s.begin().getX() && this.begin().getY() == s.begin().getY())
                || (this.begin().getX() == s.end().getX() && this.begin().getY() == s.end().getY())
                || (this.end().getX() == s.begin().getX() && this.end().getY() == s.begin().getY());
    }

    @Override
    public List<Stop> getStops() {
        return stops;
    }

    @Override
    public boolean addStop(Stop stop) {
        if((stop.getCoordinate().getX() >= this.begin().getX() && stop.getCoordinate().getX() <= this.end().getX() &&
                stop.getCoordinate().getY() >= this.begin().getY() && stop.getCoordinate().getY() <= this.end().getY()) ||
                (stop.getCoordinate().getX() <= this.begin().getX() && stop.getCoordinate().getX() >= this.end().getX() &&
                stop.getCoordinate().getY() <= this.begin().getY() && stop.getCoordinate().getY() >= this.end().getY())){
            stops.add(stop);
            stop.setStreet(this);
            return true;
        }
        return false;
    }
}
