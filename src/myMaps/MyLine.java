package ija.ija2019.homework2.MyMaps;

import ija.ija2019.homework2.maps.Line;
import ija.ija2019.homework2.maps.Stop;
import ija.ija2019.homework2.maps.Street;

import java.util.*;

public class MyLine implements Line {
    private String id;
    private List<Stop> stops = new ArrayList<Stop>();
    private List<Street> streets = new ArrayList<>();
    private final List<AbstractMap.SimpleImmutableEntry<Street,Stop>> route = new ArrayList<>();

    public MyLine(String id) {
        this.id = id;
    }

    @Override
    public boolean addStop(Stop stop) {
        if(stop.getStreet()==null){
            return false;
        }
        if(stops.isEmpty()){
            stops.add(stop);
            streets.add(stop.getStreet());
            if(streets.get(streets.size()-1).getStops().size()==0)
                route.add(new AbstractMap.SimpleImmutableEntry<Street, Stop>(streets.get(streets.size()-1),null));
            else{
                route.add(new AbstractMap.SimpleImmutableEntry<Street,Stop>(streets.get(streets.size()-1),stops.get(stops.size()-1)));
            }
            return true;
        }
        if(stop.getStreet().follows(stops.get(stops.size()-1).getStreet()) || stop.getStreet().follows(streets.get(streets.size()-1))){
            stops.add(stop);
            streets.add(stop.getStreet());
            if(streets.get(streets.size()-1).getStops().size()==0)
                route.add(new AbstractMap.SimpleImmutableEntry<Street, Stop>(streets.get(streets.size()-1),null));
            else{
                route.add(new AbstractMap.SimpleImmutableEntry<Street,Stop>(streets.get(streets.size()-1),stops.get(stops.size()-1)));
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean addStreet(Street street) {
        if(street.follows(streets.get(streets.size()-1))){
            streets.add(street);
            if(streets.get(streets.size()-1).getStops().size()==0)
                route.add(new AbstractMap.SimpleImmutableEntry<Street, Stop>(streets.get(streets.size()-1),null));
            else{
                route.add(new AbstractMap.SimpleImmutableEntry<Street,Stop>(streets.get(streets.size()-1),stops.get(stops.size()-1)));
            }
            return  true;
        }
        return false;
    }


    @Override
    public final List<AbstractMap.SimpleImmutableEntry<Street, Stop>> getRoute() {
        return Collections.unmodifiableList(route);
    }
}
