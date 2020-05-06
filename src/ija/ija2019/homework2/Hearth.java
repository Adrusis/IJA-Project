package ija.ija2019.homework2;

import ija.ija2019.homework2.MyMaps.MyLine;
import ija.ija2019.homework2.MyMaps.MySpoj;
import ija.ija2019.homework2.MyMaps.MyStop;
import ija.ija2019.homework2.maps.Line;
import ija.ija2019.homework2.maps.Spoj;
import ija.ija2019.homework2.maps.Stop;
import javafx.scene.effect.Light;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Hearth {
    private static List<Line> lines = new ArrayList<Line>();
    private static String time;

    public static void clock(){
        int seconds = 0;
        int minutes = -1;
        int hours = 0;
        while (true){
            long runtime = System.nanoTime();
            if((runtime%(1000000)) == 0){
                seconds++;
                if((seconds%60) == 0) {
                    minutes++;
                    if (hours < 10) {
                        if (minutes < 10) {
                            time = "0" + Integer.toString(hours) + ":" + "0" + Integer.toString(minutes);
                        } else {
                            time = "0" + Integer.toString(hours) + ":" + Integer.toString(minutes);
                        }
                    } else {
                        if (minutes < 10) {
                            time = Integer.toString(hours) + ":" + "0" + Integer.toString(minutes);
                        } else {
                            time = Integer.toString(hours) + ":" + Integer.toString(minutes);
                        }
                    }
                    if (((minutes + 1) % 60) == 0) {
                        hours++;
                        minutes = 0;
                        seconds = 0;
                        if (hours == 24) {
                            hours = 0;
                        }
                    }
                }
            }
        }
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
        clock();
    }

}
