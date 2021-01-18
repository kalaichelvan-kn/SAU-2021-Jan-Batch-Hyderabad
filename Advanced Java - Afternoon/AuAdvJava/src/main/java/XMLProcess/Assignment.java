package XMLProcess;

import Annotations.Capitalize;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;

public class Assignment {

	@Capitalize
	String name;

	@Capitalize
	String prog_lang;

	String status_update;

	LocalDate assDate=LocalDate.now();

	int id;

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getProg_lang() {
		return prog_lang;
	}

	@XmlElement
	public void setProg_lang(String prog_lang) {
		this.prog_lang = prog_lang;
	}

	public String getStatus_update() {
		return status_update;
	}

	@XmlElement
	public void setStatus_update(String status_update) {
		this.status_update = status_update;
	}

	public LocalDate getAssDate() {
		return assDate;
	}

	public void setAssDate(LocalDate assDate) {
		this.assDate = assDate;
	}

	public int getId() {
		return id;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Assignment{" +
				"name='" + name + '\'' +
				", prog_lang='" + prog_lang + '\'' +
				", status_update='" + status_update + '\'' +
				", assDate=" + assDate +
				", id=" + id +
				'}';
	}
}