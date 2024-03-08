package Assignment1;

public class Circle {
    double radius=1.0;
    String color="red";


    public Circle(){

    }
    public Circle(double radius){
        this.radius=radius;
    }
    public Circle(double radius,String color){
        this.radius=radius;
        this.color=color;
    }
    public  double getRadius(){
        return radius;
    }
    public  void setRadius(double radius){
        this.radius=radius;
    }

    public  String getColor(){
        return color;
    }
    public  void setRadius(String color){
        this.color=color;
    }
    public  double getArea(){
        return 3.14*radius*radius;
    }
    public String toString(){
        return "Circle [radius="+radius+",color="+color+"]";
    }


}

