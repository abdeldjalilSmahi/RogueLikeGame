package fr.uvsq.pglp.roguelike.donjon;

import java.awt.geom.Point2D;
import org.fusesource.jansi.Ansi.Color;

public class DonjonObject {
    protected Point2D object;
    protected String asciiChar ;
    protected Color color ;

    public DonjonObject(Point2D object, String asciiChar, Color color) {
        this.object = object;
        this.asciiChar = asciiChar;
        this.color = color;
    }

    public Point2D getObject() {
        return object;
    }

    public void setObject(Point2D object) {
        this.object = object;
    }

    public String getAsciiChar() {
        return asciiChar;
    }

    public void setAsciiChar(String asciiChar) {
        this.asciiChar = asciiChar;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
