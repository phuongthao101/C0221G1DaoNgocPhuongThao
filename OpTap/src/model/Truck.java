package model;

public class Truck extends Vehicle{
//+ Xe tải  có thêm thuộc tính: Trọng tải.
    private int weight;

    public Truck(String palate, String nameProduction, int yearProduct, String owner, int weight) {
        super(palate, nameProduction, yearProduct, owner);
        this.weight = weight;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

//    @Override
//    public void showInfo() {
//       String info = String.format("Truck: Palate: %s, Name production: %s ", palate, nameProduction);
//       System.out.println(info);
//    }


    @Override
  public void showInfo() {
    String infor =
             weight +
                "," + palate +
                "," + nameProduction +
                "," + yearProduct +
                "," + owner
               ;
        System.out.println(infor);;
    }

    @Override
    public String toString() {
        return String.format("%s,1,%s",super.toString(),weight);

    }
}
