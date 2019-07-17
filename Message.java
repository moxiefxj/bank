package bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Message extends JFrame implements ActionListener{
	Contorl c=new Contorl();
	
	private JButton save;
	private JButton get;
	private JButton ok;
	private JButton cancle;
	
	private JLabel username;
	private JLabel fund;
	private JLabel savel;
	
	private JLabel usernamel;
	private JLabel fundl;
	
	private JTextField tf;
	
	private String usernamestring;
	private String fundstring;
	
	private ResultSet re;
	
	private int id;
	
	public Message(String title,int id) {
		// TODO Auto-generated constructor stub
		
		this.id=id;
		//窗口的标题
		this.setTitle(title);
				
		this.setSize(400, 300);		
		//窗口居中
		this.setLocationRelativeTo(getOwner());

		init();
		//锁定窗口
		this.setResizable(false);
				
		this.setVisible(true);
	}
	public void init() {
		this.setLayout(null);
		
		save=new JButton("存款");
		save.setBounds(75,20, 60, 30);
		save.addActionListener(this);
		add(save);
		
		get=new JButton("取款");
		get.setBounds(250,20, 60, 30);
		get.addActionListener(this);
		add(get);
		
		ok=new JButton("确定");
		ok.setBounds(75, 200, 60, 30);
		ok.addActionListener(this);
		ok.setVisible(false);
		add(ok);
		
		cancle=new JButton("取消");
		cancle.setBounds(250, 200, 60, 30);
		cancle.addActionListener(this);
		cancle.setVisible(false);
		add(cancle);
		
		username=new JLabel("姓名",JLabel.CENTER);
		username.setBounds(40,60, 60, 30);
		add(username);
		
		
		try {
			re=c.find(id);//id由登陆返回
			if(re.next())
			{
				usernamestring=re.getString("username");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usernamel=new JLabel(usernamestring,JLabel.CENTER);
		usernamel.setBounds(130,60, 100,30);
		add(usernamel);
		
		fund=new JLabel("余额",JLabel.CENTER);
		fund.setBounds(40,100, 60, 30);
		add(fund);
		
		
		try {
			re=c.find(id);
			if(re.next()) {
				fundstring=String.valueOf(re.getInt(5));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fundl=new JLabel(fundstring,JLabel.CENTER);
		fundl.setBounds(130,100, 100,30);
		add(fundl);
		
		savel=new JLabel();
		savel.setBounds(0,140, 100, 30);
		savel.setVisible(false);
		add(savel);
		
		tf=new JTextField();
		tf.setBounds(130,140, 150, 30);
		tf.setVisible(false);
		tf.addActionListener(this);
		add(tf);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==save) {//存款
			//界面设置
			savel.setText("请输入存款金额");
			savel.setVisible(true);
			tf.setVisible(true);
			cancle.setVisible(true);
			ok.setVisible(true);
			
		}
		else if(e.getSource()==get) {//取款
			//界面设置
			savel.setText("请输入取款金额");
			savel.setVisible(true);
			tf.setVisible(true);
			cancle.setVisible(true);
			ok.setVisible(true);
		}
		else if(e.getSource()==ok) {//确定
			
				if(savel.getText()=="请输入取款金额") {
					int i=Integer.parseInt(fundl.getText());//现有得
					int j=Integer.parseInt(tf.getText());//要取得
						if(i<j) {
							JOptionPane.showMessageDialog(getParent(), "金额不足", "提示", JOptionPane.INFORMATION_MESSAGE);
							tf.setText(null);
						}
						else {
							int z=i-j;
							c.Update(String.valueOf(z), id);//后面的为id  需要登陆传
							fundl.setText(String.valueOf(z));
							tf.setText(null);
						}
				}
				else{
					
					int i=Integer.parseInt(fundl.getText());//现有得
					int j=Integer.parseInt(tf.getText());//要取得
					int z=i+j;
					c.Update(String.valueOf(z), id);//后面的为id  需要登陆传
					fundl.setText(String.valueOf(z));
					tf.setText(null);
				}
		}
		else if(e.getSource()==cancle) {//取消
			this.dispose();
		}
	

	}
}
