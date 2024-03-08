package Assignment3;

public class Square extends Rectangle {
    Square() {
    }

    Square(double side) {
        super(side,side);
    }

    Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();  // Assuming Square uses width as the side
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }


    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }


    public void setLength(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    public String toString() {
        return "Square[" + super.toString() + "]";
    }
}

