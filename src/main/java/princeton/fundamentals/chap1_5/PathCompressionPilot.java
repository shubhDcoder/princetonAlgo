package princeton.fundamentals.chap1_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import static princeton.graph.chap4_1.PrintUtil.*;

public class PathCompressionPilot {
    public static void main(String args[]) throws IOException{
        markHeading("UNION FIND WITH PATH COMPRESSION IMPLEMENTATION");

        Instant start = Instant.now();

        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        PathCompression qf = new PathCompression(Integer.parseInt(reader.readLine()));
        String line;
        while((line = reader.readLine()) != null) {
            String lines[] = line.split(" ");
            int key1 = Integer.parseInt(lines[0]);
            int key2 = Integer.parseInt(lines[1]);

            qf.union(key1, key2);
        }
        reader.close();

        Instant end = Instant.now();
        syso("done in : " + Duration.between(start, end).toMillis() + " miliseconds");
        printLine();
        syso("total connected/different components are : " + qf.count());
    }
}