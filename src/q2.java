import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        Shape shapeList[] = new Shape[shapeInfo.size()];
        for(int i = 0; i < shapeInfo.size(); i++){
            if (shapeInfo.get(i).charAt(0) == 'C'){
                shapeList[i] = Circle.parse(shapeInfo.get(i));
            }
            else if (shapeInfo.get(i).charAt(0) == 'R'){
                shapeList[i] = Rectangle.parse(shapeInfo.get(i));
            }
            else {
                System.out.println("UNKNOWN SHAPE DETECTED");
            }
        }
    }
}
