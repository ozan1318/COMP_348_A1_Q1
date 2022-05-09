public class Rectangle extends PrintableObject implements NamedObject {
    double side1, side2, area, perimeter;
    String name;
    Rectangle() {
        side1 = side2 = area = perimeter = 0;
        name = "";
    }

    Rectangle(double shortSide, double longSide){
        side1 = shortSide;
        side2 = longSide;
        this.setAreaAndPerimeter();
        name = "";
    }

    Rectangle(double shortSide, double longSide, String nameIn){
        side1 = shortSide;
        side2 = longSide;
        this.setAreaAndPerimeter();
        name = nameIn;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
        this.setAreaAndPerimeter();

    }

    public void setSide2(double side2) {
        this.side2 = side2;
        this.setAreaAndPerimeter();
    }

    public void setAreaAndPerimeter() {
        area = side1 * side2;
        perimeter = (side1 + side2) * 2;
    }

    @Override
    public String toString() {
        return this.getName() + ',' + side1 + ',' + side2;
    }

    public Rectangle parse(String in){
        String type = "", temp = "";
        double side1, side2;
        int i = 0;
        while (in.charAt(i) != ','){
            type += in.charAt(i);
        }
        i++;
        while (in.charAt(i) != ','){
            temp += in.charAt(i);
        }
        side1 = Double.parseDouble(temp);
        i++;
        temp = "";
        while (i < in.length()){
            temp += in.charAt(i);
        }
        side2 = Double.parseDouble(temp);
        i++;
        temp = "";
        return new Rectangle(side1, side2);
    }
}
