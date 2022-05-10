public abstract class PrintableObject implements Shape, Printable{

    String name;

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
