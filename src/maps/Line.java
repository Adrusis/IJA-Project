package ija.ija2019.homework2.maps;

import ija.ija2019.homework2.MyMaps.MyLine;

import java.util.AbstractMap;
import java.util.List;

public interface Line {

    public boolean addStop(Stop stop);

    public boolean addStreet(Street street);

    public static Line defaultLine(String id){
        return new MyLine(id);
    }

    public  List<AbstractMap.SimpleImmutableEntry<Street,Stop>> getRoute();


}
