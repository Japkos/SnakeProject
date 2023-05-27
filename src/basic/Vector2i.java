package basic;

import java.util.Objects;

public class Vector2i {

    private int x, y;

    public Vector2i() {
        x = 0;
        y = 0;
    }
    public Vector2i(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Vector2i(Vector2i vector2I){
        x = vector2I.x;
        y = vector2I.y;
    }
    public Vector2i add(Vector2i vector2I){
        return new Vector2i(x + vector2I.x, y + vector2I.y);
    }
    public Vector2i addX(int x){
        return new Vector2i(x + this.x, y);
    }
    public Vector2i addY(int y){
        return new Vector2i(x, y + this.y);
    }
    public Vector2i reverse(){
        return new Vector2i(-x, -y);
    }
    public boolean inArea(Vector2i v){
        return x >= 0 && y >= 0 && x < v.x && y < v.y;
    }
    public double length(){
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2i vector2i = (Vector2i) o;
        return x == vector2i.x && y == vector2i.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x +
                ", " + y +
                ')';
    }

}
