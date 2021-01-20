package MultiThread;

import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

class WordCount implements Runnable{
    private static HashMap<String,Integer> wordset = new HashMap<String,Integer>();
    private static AtomicInteger countWord = new AtomicInteger(0);
    private String wrd;

    WordCount(){}
    WordCount(String word){
        wrd = word;
    }

    public static AtomicInteger getCountWord() {
        return countWord;
    }

    public static HashMap<String, Integer> getWordset() {
        return wordset;
    }

    @Override
    public void run() {
        try{
            String[] sWord = wrd.split(" ");
            countWord.addAndGet(sWord.length);
            for(String s:sWord){
                s = s.replace(",","");
                s = s.replace("'","");
                s = s.replace(".","");
                s = s.replace("\"","");
                s = s.toLowerCase(Locale.ROOT);
                s = s.trim();
                if(wordset.containsKey(s)){
                    wordset.put(s,(Integer) wordset.get(s)+1);
                }else{
                    wordset.put(s,1);
                }
            }
        }catch(Exception e){
            System.out.println("kn exception word:"+e);
        }
    }
}
