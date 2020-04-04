package ija.ija2019.homework2.maps;

import java.util.Objects;


public class Coordinate {
    private final int x;
    private final int y;


    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }



    public static Coordinate create(int x, int y) {
        if(x<0 || y<0){
            return null;
        }
        return new Coordinate(x,y);
    }

    public int diffX(Coordinate c){
        return Math.abs(this.x-c.getX());
    }

    public int diffY(Coordinate c){
        return Math.abs(this.y-c.getY());
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return getX() == that.getX() &&
                getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}


