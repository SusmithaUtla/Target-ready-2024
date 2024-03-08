package Assignment1;

public class Assignment1 {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Circle[] c={
                new Cylinder(12.34),
                new Cylinder(12.34,10.0),
                new Cylinder(12.34,10.0,"blue")
        };

        System.out.println(c[0].getArea());
        Cylinder cy1=new Cylinder(12.34);
        System.out.println(cy1.getVolume());
        System.out.println(c[0].toString());

        System.out.println(c[1].getArea());
        Cylinder cy2=new Cylinder(12.34,10.0);
        System.out.println(cy2.getVolume());
        System.out.println(c[1].toString());

        System.out.println(c[2].getArea());
        Cylinder cy3=new Cylinder(12.34,10.0,"blue");
        System.out.println(cy3.getVolume());
        System.out.println(c[2].toString());
    }
}

