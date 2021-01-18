package Main;

import Session1.Assignment1;

public class AUMain {
    public static void Session1(){
        Assignment1 ass1 = new Assignment1();
        ass1.readXml();
        ass1.deSerialize();
        ass1.serialize();
        ass1.printTop5Ranks();
        ass1.writeToCSV();
        ass1.singletonExample();
    }

    public static void Session2(){

    }

    public static void main(String args[]){
        Session1();
        Session2();
    }
}
