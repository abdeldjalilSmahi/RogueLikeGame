package fr.uvsq.pglp.roguelike.donjon;

import java.awt.geom.Point2D;
import org.fusesource.jansi.Ansi.Color;

public class DonjonObject {
    protected Point2D position;
    protected String asciiChar ;
    protected Color color ;

    public DonjonObject(Point2D position, String asciiChar, Color color) {
        this.position = position;
        this.asciiChar = asciiChar;
        this.color = color;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
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
