public interface Printable {
    public String toString();
    public static void print(PrintableObject[] p){
        for (int i = 0; i < p.length; i++){
            p[i].print();
        }
    };
    public void print();
}
