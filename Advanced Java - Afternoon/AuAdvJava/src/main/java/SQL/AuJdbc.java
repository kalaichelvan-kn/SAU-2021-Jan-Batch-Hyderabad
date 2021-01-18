package SQL;

import XMLProcess.Assignment;
import XMLProcess.Assignments;

import java.awt.*;
import java.sql.*;

public class AuJdbc {

	Connection con;

	public AuJdbc(){ }

	public boolean initConnection(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbkn", "root", "1126");
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public void createTables() {
		try (Statement stmt = this.con.createStatement()) {
			String sql = "create table assignment(asgmt_id int PRIMARY KEY, name varchar(50), prog_lang varchar(50), status_update varchar(50), date timestamp)";
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertData(Assignments assignments) {
		String sql = "insert into assignment(asgmt_id, name, prog_lang, status_update, date) values(?, ?, ?, ?, ?)";
		try{
			PreparedStatement stmt = this.con.prepareStatement(sql);
			for(Assignment a:assignments.getAssignment()){
				stmt.setInt(1, a.getId());
				stmt.setString(2, a.getName());
				stmt.setString(3, a.getProg_lang());
				stmt.setString(4, a.getStatus_update());
				stmt.setString(5, a.getAssDate().toString());
				stmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateData() {
		String sql = "update assignment set status_update=? where asgmt_id=?";
		try (PreparedStatement stmt = this.con.prepareStatement(sql)) {
			stmt.setString(1, "started");
			stmt.setInt(2, 1);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void readData() {
		String sql = "select asgmt_id, name, prog_lang, status_update, date  from assignment";
		try (Statement stmt = this.con.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +rs.getString(3)+ " " +rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
