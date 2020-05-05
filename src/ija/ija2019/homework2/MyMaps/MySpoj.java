package ija.ija2019.homework2.MyMaps;

import ija.ija2019.homework2.maps.Spoj;

import java.util.ArrayList;
import java.util.List;

public class MySpoj implements Spoj {
    private String id;
    private List<String> times = new ArrayList<String>();


    public MySpoj(String id){
        this.id = id;
    }


    @Override
    public void addTime(String time) {
        times.add(time);

    }
}
