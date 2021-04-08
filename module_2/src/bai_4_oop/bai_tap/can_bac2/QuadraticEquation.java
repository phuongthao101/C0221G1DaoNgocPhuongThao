package bai_4_oop.bai_tap.can_bac2;

public class QuadraticEquation {
   double a;
   double b;
   double c;

   public QuadraticEquation(){

    }
    public QuadraticEquation( double a, double b, double c){
       this.a = a;
       this.b = b;
       this.c = c;

    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getA (){
       return this.a;

    }
    public double getDiscriminant(){
       return this.b* 2 - 4* this.a * this.c;

    }
    public double getRoot1(){
       return (-this.b +Math.sqrt(this.getDiscriminant())) / 2 * this.a;
    }
    public double getRoot2(){
       return (- this.b - Math.sqrt(this.getDiscriminant()) ) / 2* this.a;
    }


}
