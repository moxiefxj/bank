package bank;

import java.sql.ResultSet;

public class Contorl {
	Model m=new Model();
	
	public void Setuser(String user,String password) {
		
		m.setuser(user);
		m.setpassword(password);
		m.getdbdriver();
		m.getconnection();
		m.getre();
	}
	public void Setcount(String user,String ID,String count) {
		
		m.setuser(user);
		m.setID(ID);
		m.setcount(count);
		m.getdbdriver();
		m.getconnection();
		m.getrc();
	}
	public ResultSet check(String user,String password) {
		
		m.setuser(user);
		m.setpassword(password);
		m.getdbdriver();
		m.getconnection();
		return m.getse();
	}
	public ResultSet find(int id) {
		
		m.setid(id);
		m.getdbdriver();
		m.getconnection();
		
		return m.getsave();
	}
	public void Update(String funded,int id) {
		m.setfunded(funded);
		m.getdbdriver();
		m.getconnection();
		m.setupdate();
	}
}
