package mx.edu.utng.pcamacho.menu;

/**
 * Created by UTNG on 20/09/2017.
 */

public class MenuItem extends MenuComponent {
    private String name;
    private String desciption;
    private boolean vegetarian;
    private double price;

    public MenuItem(String name,
                    String desciption,
                    Boolean vegetarian,
                    double price) {
        this.name = name;
        this.desciption = desciption;
        this.vegetarian = vegetarian;
        this.price = price;


    }

    public String getDesciption() {
        return desciption;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public String print() {
        String v;
        if (isVegetarian()) {
            v = "Vegetariano";
        } else {
            v = "No vegetariano";
        }
        return getName() + "\n" +
                getDesciption() + "\n" +
                v + "\n"+
                getPrice()+"\n\n";

    }

}
