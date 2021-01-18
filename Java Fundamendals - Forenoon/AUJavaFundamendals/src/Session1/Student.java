package Session1;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Comparator;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Student implements Serializable {

    @XmlElement(name = "rollno")
    private int rollno;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "maths")
    private int maths;

    @XmlElement(name = "science")
    private int science;

    @XmlElement(name = "english")
    private int english;

    private int total;
    private int rank=-1;

    Student(){this.total=0;}
    Student(int rn, String n, int m, int s, int e){this.rollno=rn;this.name=n;this.maths=m;this.science=s;this.english=e;}

    public static Comparator<Student> StuMarkComparator = new Comparator<Student>() {
        public int compare(Student s1, Student s2) {
            int studentMark1 = s1.getTotal();
            int studentMark2 = s2.getTotal();
            return studentMark2-studentMark1;
    }};

    public void calculateTotal(){
        this.total = this.english+this.maths+this.science;
    }

    public int getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public int getMaths() {
        return maths;
    }

    public int getScience() {
        return science;
    }

    public int getEnglish() {
        return english;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
