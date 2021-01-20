package MultiThread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class InFileCounter implements Runnable
{
    private static AtomicInteger countPara = new AtomicInteger(0);
    private String filename = "K:\\accolite\\AccoliteGit\\SAU-2021-Jan-Batch-Hyderabad\\Java Multithreading - Forenoon\\AuJavaMultiThread\\src\\main\\resources\\Book.txt";

    public static AtomicInteger getCountPara() {
        return countPara;
    }

    public static void printAllData(){
        System.out.println("No of Paragraphs: "+countPara);
        System.out.println("No of Sentences: "+new SentenceCount().getCountSentence());
        System.out.println("No of Words: "+new WordCount().getCountWord());
        HashMap<String,Integer> hmap = new WordCount().getWordset();
        System.out.println("No of Unique Words: "+hmap.size());
        System.out.println("Example word store -> ");
        for(String key:hmap.keySet()){
            System.out.println(key+" : "+hmap.get(key));
            if(hmap.size()>10)break;
        }
        if(hmap.containsKey("the")){
            System.out.println("the : "+hmap.get("the"));
        }
    }

    public void run() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filename))));
            String line;
            StringBuilder tpara=new StringBuilder("");
            String lastLine="-";
            while((line = reader.readLine()) != null){
                if(line.equals("") && !line.equals(lastLine)){
                    countPara.incrementAndGet();
                    executor.submit(new SentenceCount(new String(tpara)),"thread finished");
                    tpara=new StringBuilder("");
                }else{
                    tpara.append(line);
                }
                lastLine = line;
            }
            if(!tpara.equals("")){
                executor.submit(new SentenceCount(new String(tpara)),"thread finished");
            }
            executor.shutdown();
            executor.awaitTermination(4, TimeUnit.SECONDS);
            printAllData();
        }
        catch(Exception e) {
            System.out.println("kn Exception:"+e);
        }
        System.out.println("endpoint");
    }
}