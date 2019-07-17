package bank;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

	Contorl c=new Contorl();
	
	public String username;
	public String password;
	
	private JButton ok;
	private JButton cancle;
	private JButton registered;
	
	private JTextField usertf;
	private JTextField passwordtf;

	
	private JLabel userl;
	private JLabel passwordl;
	
	private ResultSet re;
	public Login(String title) {
		// TODO Auto-generated constructor stub
		//窗口的标题
				this.setTitle(title);
				
				this.setSize(400, 300);
				//this.setBounds(400,200,400, 300);
				//窗口居中
				this.setLocationRelativeTo(getOwner());

				init();
				//锁定窗口
				this.setResizable(false);
				
				this.setVisible(true);
	}
	public void init() {
		this.setLayout(null);
		
		usertf=new JTextField();
		usertf.setColumns(8);
		usertf.setFont(new Font("宋体",Font.PLAIN,20));
		usertf.setBounds(100,50,200,40);
		add(usertf);

		passwordtf=new JTextField();
		passwordtf.setColumns(18);
		passwordtf.setFont(new Font("宋体",Font.PLAIN,20));
		passwordtf.setBounds(100,100,200,40);
		add(passwordtf);
		
		userl=new JLabel("姓名",JLabel.CENTER);
		userl.setBounds(0, 50, 60, 40);
		add(userl);
		
		passwordl=new JLabel("密码",JLabel.CENTER);
		passwordl.setBounds(0,100, 60, 40);
		add(passwordl);
		
		ok=new JButton("确定");
		ok.setBounds(70,200, 60, 40);
		ok.addActionListener(this);
		add(ok);
		
		cancle=new JButton("取消");
		cancle.setBounds(180, 200, 60, 40);
		cancle.addActionListener(this);
		add(cancle);
		
		registered=new JButton("注册");
		registered.setBounds(300, 200, 60, 40);
		registered.addActionListener(this);
		add(registered);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ok) {
			//比对密码和账户是否匹配
			try {
				re=c.check(usertf.getText(), passwordtf.getText());
				if(re.next()) {
					new Message("存取款操作",re.getInt("id"));
					//关闭窗口
					this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(getParent(), "账号或者密码错误", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cancle) {
			//关闭窗口
			this.dispose();
		}
		else if(e.getSource()==registered) {
			//跳转注册界面
			new registered("注册");
		}
	}
	
	public static void main(String[] args) {
		new Login("科成银行");
	}

}
