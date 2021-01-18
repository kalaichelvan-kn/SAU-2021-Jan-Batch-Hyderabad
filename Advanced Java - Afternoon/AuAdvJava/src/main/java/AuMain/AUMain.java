package AuMain;

import SQL.AuJdbc;
import XMLProcess.Assignments;
import XMLProcess.XMLProcess;

public class AUMain {

    private static AuJdbc jdbcobj;
    private static Assignments assignments;

    public static void runjdbc(){
        jdbcobj = new AuJdbc();
        if(jdbcobj.initConnection()){
//            jdbcobj.createTables();
//            jdbcobj.insertData(assignments);
//            jdbcobj.updateData();
            System.out.println("reading data from db");
            jdbcobj.readData();
        }else{
            System.out.println("connection problem");
        }
    }

    public static void runxml(){
        XMLProcess xmlobj = new XMLProcess();
        assignments = xmlobj.getAssignments();
    }

    public static void main(String args[]){
        runxml();
        runjdbc();
    }
}
