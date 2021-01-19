package MultiThread;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class WordCount implements Runnable
{
    private static AtomicInteger count = new AtomicInteger(0);
    private String filename = "K:\\accolite\\AccoliteGit\\SAU-2021-Jan-Batch-Hyderabad\\Java Multithreading - Forenoon\\AuJavaMultiThread\\src\\main\\resources\\sample.txt";

    public static int getCount() {
        return count.get();
    }

    public void run() {
        try {
            Scanner in = new Scanner(new File(filename));
            while (in.hasNext()) {
                in.next();
                count.incrementAndGet();
            }
            System.out.println(filename + ": " + count);
        }
        catch(Exception e) {
            System.out.println(filename + " blev ikke fundet.");
        }
    }
}