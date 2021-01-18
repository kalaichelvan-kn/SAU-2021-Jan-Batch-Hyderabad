package XMLProcess;

import Annotations.CapitalizeNames;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLProcess{

    private String filePath = "K:\\accolite\\AccoliteGit\\SAU-2021-Jan-Batch-Hyderabad\\Advanced Java - Afternoon\\AuAdvJava\\src\\main\\resources\\assignment.xml";
    private Assignments assignments;

    public XMLProcess(){
        this.jaxBParser();
    }

    public Assignments getAssignments(){
        return this.assignments;
    }

    public void jaxBParser() {
        try {
            File file = new File(filePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(Assignments.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            this.assignments = (Assignments) jaxbUnmarshaller.unmarshal(file);
            System.out.println("Capitalize names");
            for(Assignment assi:this.assignments.getAssignment()){
                System.out.println(CapitalizeNames.changeNames(assi));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
