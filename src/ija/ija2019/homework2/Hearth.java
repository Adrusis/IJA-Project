package ija.ija2019.homework2;

import ija.ija2019.homework2.MyMaps.MySpoj;
import ija.ija2019.homework2.maps.Line;
import ija.ija2019.homework2.maps.Spoj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Hearth {
    private static List<Line> lines = new ArrayList<Line>();

    public static void move(){
        long time = 0;
        String clock;
        while (true){
            time++;
            clock = getTime(60,time);
        }
    }
    // za jednu sec 285991
   public static String getTime (int modifier, long time){
        int base = 285991;
        long hour = base*(3600/modifier);
        long min = base*(60/modifier);
        long hours = (time/hour)%24;
        long minutes = (time/min)%60;
        if (hours < 10){
            if (minutes < 10){
                return "0"+Long.toString(hours)+":"+"0"+Long.toString(minutes);
            }
            return "0"+Long.toString(hours)+":"+Long.toString(minutes);
        }
        if (minutes < 10){
            return "0"+Long.toString(hours)+":"+"0"+Long.toString(minutes);
        }
       return Long.toString(hours)+":"+Long.toString(minutes);
    }

    public static void setup() throws IOException {
        File file = new File("C:\\Users\\Martin Mikuš\\Desktop\\Skola\\IJA\\Hearth\\src\\ija\\ija2019\\homework2\\Linky.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        String[] times;
        int counter = -1;
        int counter2 = 0;
        while ((line = reader.readLine()) != null) {
            if (line.contains("Linka")) {
                Line linka = Line.defaultLine(line);
                lines.add(linka);
                counter++;
                counter2 = 0;
            } else {
                times = line.split(",");
                Spoj spoj = new MySpoj(Integer.toString(counter2));
                for (int i = 0; i < times.length; i++) {
                    //Stop stop = new MyStop()
                    spoj.addTime(times[i]);

                }
                lines.get(counter).addSpoj(spoj);
            }
            counter2++;
        }

    }

    public static void main(String[] argc) throws IOException {
        setup();
        move();
    }

}
