package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PersonalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;
    private String email;
    private String mobile;

    @OneToOne
    @MapsId
    private Employee employee;

    public PersonalDetails(String email, String mobile, Employee employee) {
        this.email = email;
        this.mobile = mobile;
        this.employee = employee;
    }
}
