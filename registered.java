package bank;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class registered extends JFrame implements ActionListener{
	Contorl c=new Contorl();
	public String ID;
	public String username;
	public String password;
	
	private JButton ok;
	private JButton cancle;
	private JTextField IDtf;
	private JTextField usertf;
	private JTextField passwordtf;
	private JTextField countf;
	private JLabel IDl;
	private JLabel userl;
	private JLabel passwordl;
	private JLabel countl;
	
	int re;
	
	public registered(String title) {
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
		
		IDtf=new JTextField();
		IDtf.setColumns(18);
		IDtf.setFont(new Font("宋体",Font.PLAIN,20));
		IDtf.setBounds(100,0,300,40);
		IDtf.addActionListener(this);
		add(IDtf);
		
		usertf=new JTextField();
		usertf.setColumns(8);
		usertf.setFont(new Font("宋体",Font.PLAIN,20));
		usertf.setBounds(100,50,300,40);
		usertf.addActionListener(this);
		add(usertf);
		
		passwordtf=new JTextField();
		passwordtf.setColumns(18);
		passwordtf.setFont(new Font("宋体",Font.PLAIN,20));
		passwordtf.setBounds(100,100,300,40);
		passwordtf.addActionListener(this);
		add(passwordtf);
		
		countf=new JTextField();
		countf.setColumns(18);
		countf.setFont(new Font("宋体",Font.PLAIN,20));
		countf.setBounds(100,150,300,40);
		countf.addActionListener(this);
		add(countf);
		
		IDl=new JLabel("身份证号",JLabel.CENTER);
		IDl.setBounds(0, 0, 60,40);
		add(IDl);
		
		userl=new JLabel("姓名",JLabel.CENTER);
		userl.setBounds(0, 50, 60, 40);
		add(userl);
		
		passwordl=new JLabel("密码",JLabel.CENTER);
		passwordl.setBounds(0,100, 60, 40);
		add(passwordl);
		
		countl=new JLabel("账号",JLabel.CENTER);
		countl.setBounds(0,150, 60, 40);
		add(countl);
		
		ok=new JButton("确定");
		ok.setBounds(70,200, 60, 40);
		ok.addActionListener(this);
		add(ok);
		
		cancle=new JButton("取消");
		cancle.setBounds(250, 200, 60, 40);
		cancle.addActionListener(this);
		add(cancle);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==ok) {
			
			if(IDtf.getText().length()!=18) {
				JOptionPane.showMessageDialog(getParent(), "身份证号码无效", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(usertf.getText().length()==0||usertf.getText().length()>8) {
				JOptionPane.showMessageDialog(getParent(), "名字不能为空或者名字过长", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(passwordtf.getText().length()<10||passwordtf.getText().length()>20) {
				JOptionPane.showMessageDialog(getParent(), "密码少于10位无效或者密码大于20位，请重新输入", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(countf.getText().length()!=18) {
				JOptionPane.showMessageDialog(getParent(), "账号无效", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
			//向文件中添加信息
			if(IDtf.getText().length()==18&&passwordtf.getText().length()>=10&&usertf.getText().length()!=0&&countf.getText().length()==18) {
				c.Setuser(usertf.getText(), passwordtf.getText());
				c.Setcount(usertf.getText(),IDtf.getText(),countf.getText());
				
				this.dispose();
			}
		}
		else if(e.getSource()==cancle) {
			this.dispose();
		}
	}
}
