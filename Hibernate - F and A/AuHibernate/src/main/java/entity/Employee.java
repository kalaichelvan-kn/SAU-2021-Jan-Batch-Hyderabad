package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "employeeId", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Address> addresses;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="EmployeeCourse", joinColumns={@JoinColumn(referencedColumnName="empId")}
            , inverseJoinColumns={@JoinColumn(referencedColumnName="courseId")})
    private Set<Courses> coursesSet;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
