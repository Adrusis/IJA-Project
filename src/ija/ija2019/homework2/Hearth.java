package ija.ija2019.homework2;

import ija.ija2019.homework2.MyMaps.MySpoj;
import ija.ija2019.homework2.maps.*;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the hearth of project, and contains main function. It combines all class and function.
 */
public class Hearth {
    private static List<Line> lines = new ArrayList<Line>();
    private static List<Street> streets = new ArrayList<Street>();

    /**
     * Function move is for simulation movement of Bus thought map. It contains infinite cycle that contains
     * clock variable which is used for calculating time in the app
     */
    public static void move(){
        long clock = 0;
        String time;
        while (true){
            clock++;
            time = getTime(60,clock);
        }
    }

    // za jednu sec 285991

    /**
     * getTime is basically internal clock that guides bus departures and arrivel to and from the Stops
     * @param modifier how quickly user wants time to pass in app
     * @param time number of times that cycle in the move function has been passed
     * @return return relative time of day in the app
     */
   @NotNull
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

    /**
     * Setup functions as staging ground for app it reads input file and create Object that will be used in the app
     * @throws IOException exception if opening of the file fails
     */
    public static void setup() throws IOException {
        File file = new File("C:\\Users\\Martin Mikuš\\Desktop\\Skola\\IJA\\Hearth\\src\\ija\\ija2019\\homework2\\Linky.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        int counter = -1;
        int counter2 = 0;
        while ((line = reader.readLine()) != null) {
            if (line.contains("Linka")) {
               Line linka = Line.defaultLine(line);
               lines.add(linka);
               counter++;
               counter2 = 0;
            } else {
                String[] times;
                times = line.split(",");
                Spoj spoj = new MySpoj(Integer.toString(counter2));
                for (int i = 0; i < times.length; i++) {
                    //Stop stop = new MyStop();
                    spoj.addTime(times[i]);

                }
                lines.get(counter).addSpoj(spoj);
           }
            counter2++;
        }
        file = new File("C:\\Users\\Martin Mikuš\\Desktop\\Skola\\IJA\\Hearth\\src\\ija\\ija2019\\homework2\\Streets.txt");
        reader = new BufferedReader(new FileReader(file));
        counter = 0;
        while ((line= reader.readLine()) != null){
            boolean checker;
            String[] street_name;
            ArrayList<Coordinate> coordinate = new ArrayList<>();
            String[] coordinates;
            street_name = line.split(":");
            coordinates = street_name[1].split(";");
            for (int i = 0; i < coordinates.length;i++){
                String[] c;
                Coordinate c1;
                c = coordinates[i].split(",");
                c1 = Coordinate.create(Integer.valueOf(c[0]),Integer.valueOf(c[1]));
                coordinate.add(c1);
            }
            Street street = Street.defaultStreet(street_name[0],coordinate.get(0),coordinate.get(1));
            streets.add(street);
            counter++;
        }
        file = new File("C:\\Users\\Martin Mikuš\\Desktop\\Skola\\IJA\\Hearth\\src\\ija\\ija2019\\homework2\\Stops.txt");
        reader = new BufferedReader(new FileReader(file));
        counter = 0;
        while((line = reader.readLine()) !=null){
            String[] stop_name;
            boolean checker;
            Coordinate coordinate;
            String[] coordinates;
            stop_name = line.split(":");
            coordinates = stop_name[1].split(",");
            coordinate = Coordinate.create(Integer.valueOf(coordinates[0]),Integer.valueOf(coordinates[1]));
            if(counter < 4){
                Stop stop = Stop.defaultStop(stop_name[0],coordinate);
                if (counter%4 == 0 || counter%4 == 3){
                    stop.addType("konečná");
                }else{
                    stop.addType("prechodná");
                }
                stop.setStreet(streets.get(counter));
                checker = lines.get(0).addStop(stop);
            }else if (counter >= 4 && counter < 8){
                Stop stop = Stop.defaultStop(stop_name[0],coordinate);
                if (counter%4 == 0 || counter%4 == 3){
                    stop.addType("konečná");
                }else{
                    stop.addType("prechodná");
                }
                stop.setStreet(streets.get(counter));
                checker = lines.get(1).addStop(stop);
            }else if (counter >= 8 && counter < 12){
                Stop stop = Stop.defaultStop(stop_name[0],coordinate);
                if (counter%4 == 0 || counter%4 == 3){
                    stop.addType("konečná");
                }else{
                    stop.addType("prechodná");
                }
                stop.setStreet(streets.get(counter));
                checker = lines.get(2).addStop(stop);
            }
            counter++;
        }
    }

    /**
     * Main fuction from where setup and movement begins
     * @param argc argument of the program
     * @throws IOException exeption if file fails to open
     */
    public static void main(String[] argc) throws IOException {
        setup();
        //move();
    }

}
