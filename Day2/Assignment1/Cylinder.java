package Assignment1;

public class Cylinder extends Circle {

    private double height=1.0;



    public Cylinder(){

    }
    public Cylinder(double radius){
        this.radius=radius;
    }
    public Cylinder(double radius,double height){
        this.radius=radius;
        this.height=height;
    }
    public Cylinder(double radius,double height,String color){
        this.radius=radius;
        this.height=height;
        this.color=color;
    }
    public  double getHeight(){
        return height;
    }
    public  void setHeight(double height){
        this.height=height;
    }


    public  double getVolume(){
        return 3.14*radius*radius*height;
    }


}
