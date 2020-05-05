package princeton.fundamentals.chap1_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import static princeton.graph.chap4_1.PrintUtil.*;

public class QuickUnionPilot {
    public static void main(String args[]) throws FileNotFoundException{
        markHeading("UNION FIND WITH QUICK UNION IMPLEMENTATION");
        Scanner scanner = new Scanner(new File(args[0]));
        QuickUnion qf = new QuickUnion(scanner.nextInt());
        while(scanner.hasNextLine()) {
            int key1 = scanner.nextInt();
            int key2 = scanner.nextInt();

            qf.union(key1, key2);
        }
        scanner.close();
        printLine();
        syso("total connected/different components are : " + qf.count());
        syso(Arrays.toString(qf.elements));
    }
}