package org.example;

import java.util.concurrent.CyclicBarrier;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Circle{
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

class Cylinder extends Circle{
    double height=1.0;



    Cylinder(){

    }
    Cylinder(double radius){
        this.radius=radius;
    }
    Cylinder(double radius,double height){
        this.radius=radius;
        this.height=height;
    }
    Cylinder(double radius,double height,String color){
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

public class assignment1 {
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