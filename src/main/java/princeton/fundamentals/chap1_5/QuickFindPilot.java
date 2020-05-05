package princeton.fundamentals.chap1_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static princeton.graph.chap4_1.PrintUtil.*;

public class QuickFindPilot {
    public static void main(String args[]) throws FileNotFoundException{
        markHeading("UNION FIND WITH QUICK FIND IMPLEMENTATION");
        Scanner scanner = new Scanner(new File(args[0]));
        QuickFind qf = new QuickFind(scanner.nextInt());
        while(scanner.hasNextLine()) {
            int key1 = scanner.nextInt();
            int key2 = scanner.nextInt();

            qf.union(key1, key2);
        }
        scanner.close();
        printLine();
        syso("total connected/different components are : " + qf.count());
    }
}