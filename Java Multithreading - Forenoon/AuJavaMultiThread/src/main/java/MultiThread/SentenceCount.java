package MultiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class SentenceCount implements Runnable{
    private static AtomicInteger countSentence = new AtomicInteger(0);
    private String sen;

    SentenceCount(){}
    SentenceCount(String sentence){
        sen = sentence;
    }

    public static AtomicInteger getCountSentence() {
        return countSentence;
    }

    @Override
    public void run() {
        try{
            ExecutorService executor = Executors.newFixedThreadPool(5);
            String[] sSentence = sen.split("(?<=[a-z])\\.\\s+");
            countSentence.addAndGet(sSentence.length);
            for(String sent:sSentence){
                executor.submit(new WordCount(sent),"thread finished");
            }
            executor.shutdown();
            executor.awaitTermination(3, TimeUnit.SECONDS);
        }catch(Exception e){
            System.out.println("kn Exception:"+e);
        }
    }
}
