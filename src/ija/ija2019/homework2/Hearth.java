package ija.ija2019.homework2;

import ija.ija2019.homework2.MyMaps.MySpoj;
import ija.ija2019.homework2.maps.Line;
import ija.ija2019.homework2.maps.Spoj;
import javafx.scene.effect.Light;

import java.util.ArrayList;
import java.util.List;

public class Hearth {
    private static List<Line> lines = new ArrayList<Line>();


    public static void setup(){
        int id = 1;
        String zero = "0";
        String whole = ":00";
        String quarter = ":15";
        String half = ":30";
        String treeQuart = ":45";
        for(int i = 0; i <= 3;i++ ){
            Line line = Line.defaultLine(Integer.toString(id));
            id++;
            for (int j = 1; j <= 10;j++){
                Spoj spoj = new MySpoj(Integer.toString(j));
                if(5+j >= 10) {
                    spoj.addTime(Integer.toString(5 + j) + whole);
                    spoj.addTime(Integer.toString(5 + j) + quarter);
                    spoj.addTime(Integer.toString(5 + j) + half);
                    spoj.addTime(Integer.toString(5 + j) + treeQuart);
                    line.addSpoj(spoj);
                }else {
                    spoj.addTime(zero + Integer.toString(5 + j) + whole);
                    spoj.addTime(zero + Integer.toString(5 + j) + quarter);
                    spoj.addTime(zero + Integer.toString(5 + j) + half);
                    spoj.addTime(zero + Integer.toString(5 + j) + treeQuart);
                    line.addSpoj(spoj);
                }
            }
        lines.add(line);
        }
    }

    public static void main(String[] argc){
        setup();
        System.out.println();
    }

}
