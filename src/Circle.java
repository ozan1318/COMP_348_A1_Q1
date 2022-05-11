import java.util.Locale;

public class Circle extends PrintableObject implements NamedObject {
    double radius, perimeter, area;
    String name;

    Circle(){
        radius = perimeter = area = 0;
        name = "";
    }

    Circle(double rad) {
        radius = rad;
        this.setAreaAndPerimeter();
        name = "NO_NAME_SET_FOR_CIRCLE";
    }

    Circle(double rad, String name) {
        radius = rad;
        this.name = name;
        this.setAreaAndPerimeter();
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public String getName() {
        return name.toUpperCase();
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        this.setAreaAndPerimeter();
    }

    public void setAreaAndPerimeter() {
        area = Math.PI * radius * radius;
        perimeter = 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return this.getName() + ',' + radius;
    }

    public static Circle parse(String in) {
        String type = "", temp = "";
        double radius;
        int i = 0;
        while (in.charAt(i) != ','){
            type += in.charAt(i);
            i++;
        }
        i++;
        while (i < in.length()){
            temp += in.charAt(i);
            i++;
        }
        radius = Double.parseDouble(temp);

        return new Circle(radius);
    }
}
