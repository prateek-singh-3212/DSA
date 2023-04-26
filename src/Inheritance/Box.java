package Inheritance;

public class Box {
    public double h;
    public double w;
    public double l;

    public Box() {
        this.w = -1;
        this.h = -1;
        this.l = -1;
    }

    Box(double w, double l, double h) {
        this.w = w;
        this.h = h;
        this.l = l;
    }
}
