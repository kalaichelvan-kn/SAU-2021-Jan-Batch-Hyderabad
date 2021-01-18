package Main;

public class AUString {

    public void stringBuilder(){
        System.out.println("stringBuilder -> ");
        StringBuilder stringBuilder1=new StringBuilder("kalai");
        System.out.println(stringBuilder1);
    }

    public void stringBuffer(){
        System.out.println("string buffer ->");
        StringBuffer stringBuffer=new StringBuffer("kalai");
        System.out.println(stringBuffer);
    }

    public void string(){
        System.out.println("String ->");
        String s1="kalaic";
        String s2="kalai";
        System.out.println(s1.compareTo(s2));
    }
}
