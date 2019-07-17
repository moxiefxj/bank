package bank;
import java.sql.*;
public class Model {//链接数据库、连接驱动
	private String user;
	private String password;
	private String ID;
	private String count;
	private int id;
	private String funded;

	private Statement stmt;
	private Connection ct;
	private ResultSet re;
	
	private PreparedStatement ps = null;
	
	public void setuser(String n){
		user=n;
	}
	public String getuser() {
		return user;
	}
	
	public void setpassword(String i) {
		password=i;
	}
	public String getpassword() {
		return password;
	}
	public void setID(String n){
		ID=n;
	}
	public String getID() {
		return ID;
	}
	public void setcount(String i) {
		count=i;
	}
	public String getcount() {
		return count;
	}
	
	public void setid(int n){
		id=n;
	}
	public int getid() {
		return id;
	}
	public void setfunded(String n){
		funded=n;
	}
	public String getfunded() {
		return funded;
	}
	public void getdbdriver() {//加驱动
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("加载驱动失败！");
		}
			
	}
	public void getconnection() {//链接数据库
		String strCon ="jdbc:sqlserver://127.0.0.1:1433;databaseName=bank";//数据库名称
		try {
			ct =DriverManager.getConnection(strCon, "sa","980903");//进入数据库
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("进入数据库失败！");
		}
	}
	public void getre(){//执行加用户数据
			try {
				String sql="insert into users(username,password) values('"+(getuser())+"','"+(getpassword())+"')";
				stmt=ct.createStatement();
				stmt.executeUpdate(sql);
				System.out.println("用户数据添加成功！");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	public void getrc(){//执行加账户数据
		try {
			String sql="insert into count(username,ID,count,fund) values('"+(getuser())+"','"+(getID())+"','"+(getcount())+"','"+0+"')";
			stmt=ct.createStatement();
			stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getse(){//登陆时执行查找用户数据
		try {
			String sql="select * from users where password='"+getpassword()+"'";
			sql+="and username='"+(getuser())+"'";
			stmt=ct.createStatement();
			re=stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
		
	}
	public ResultSet getsave(){//存取是时执行查找用户数据
		try {
			String sql="select * from count where userid='"+getid()+"'";
			stmt=ct.createStatement();
			re=stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;	
	}
	public void setupdate(){//存取是时执行查找用户数据
		try {
			String sql="update count set fund='"+getfunded()+"' where userid='"+getid()+"'";
			ps=ct.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}


