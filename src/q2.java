import java.io.File;
import java.io.IOException;
import java.util.*;

public class q2 {
    public static void main(String[] args) {
        File file = new File("shapes.txt");
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (IOException e) {
            System.out.println("FILE NOT FOUND! EXITING PROGRAM");
            System.exit(0);
        }
        List<String> shapeInfo = new ArrayList<String>();
        while (scan.hasNextLine()){
            shapeInfo.add(scan.nextLine());
        }
        PrintableObject[] shapeArray = new PrintableObject[shapeInfo.size()];
        for(int i = 0; i < shapeInfo.size(); i++){
            if (shapeInfo.get(i).charAt(0) == 'C'){
                shapeArray[i] = Circle.parse(shapeInfo.get(i));
                System.out.println("c");
            }
            else if (shapeInfo.get(i).charAt(0) == 'R'){
                shapeArray[i] = Rectangle.parse(shapeInfo.get(i));
                System.out.println("r");
            }
            else {
                System.out.println("UNKNOWN SHAPE DETECTED");
            }
        }

        scan = new Scanner(System.in);
        int s = 0;
        while (s != 6){
            System.out.println("Choose one of the options.\n1. Sort ascending by area\n2. Sort descending by area\n3. Sort ascending by name\n4. Sort descending by name\n5. Quit");
            s = scan.nextInt();
            switch (s){
                case 1:{
                    Arrays.sort(shapeArray, Comparator.comparing(Shape::getArea));
                    break;
                }
                case 2:{
                    Arrays.sort(shapeArray, Comparator.comparing(Shape::getArea).reversed());
                    break;
                }
                case 3:{
                    Arrays.sort(shapeArray, Comparator.comparing(Shape::getName));
                    break;
                }
                case 4:{
                    Arrays.sort(shapeArray, Comparator.comparing(Shape::getName).reversed());
                    break;
                }
                case 5:{
                    System.exit(0);
                }
            }
            Printable.print(shapeArray);
        }
    }
}
