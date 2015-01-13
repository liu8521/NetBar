package cn.liuning.UI;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.liuning.dao.UserDao;
import cn.liuning.dao.impl.UserDaoImpl;
import cn.liuning.javabean.User;


public class UpdateUserFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * 标签定义
	 */
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel4 = null;
	
	/**
	 * 按钮 文本框...
	 */
	private JButton commit = null;
	private JButton reset = null;
	private JTextField userCard = null;
	private JPasswordField password = null;
	private JTextField phoneNumber = null;
	private JComboBox userType = null;

	static JFrame frame;

	/**
	 * 构造函数初始化
	 */
	public UpdateUserFrame() {
		super();
		initialize();
	}

	/**
	 * 初始化方法初始化
	 */
	private void initialize() {
		ImageIcon icon = new ImageIcon("image/updateuser.png");
		this.setIconImage(icon.getImage());
		this.setSize(350, 260);
		this.setContentPane(getJContentPane());
	}

	/**
	 * 得到容器面板
	 * @return
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(85, 140, 66, 20));
			jLabel4.setText("性别：");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(75, 91, 69, 23));
			jLabel2.setText("手机号：");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(65, 59, 68, 24));
			jLabel1.setText("输入密码：");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(65, 29, 79, 22));
			jLabel.setText("会员卡号：");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(getCommit(), null);
			jContentPane.add(getReset(), null);
			jContentPane.add(getUserCard(), null);
			jContentPane.add(getPassword(), null);
			jContentPane.add(getPhoneNumber(), null);
			jContentPane.add(getSex(), null);

		}
		return jContentPane;
	}
	
	/**
	 * 得到用户卡号
	 * @return
	 */
	private JTextField getUserCard() {
		if (userCard == null) {
			userCard = new JTextField();
			userCard.setBounds(new Rectangle(147, 29, 98, 23));
		}
		return userCard;
	}
	
	/**
	 * 得到密码框
	 * @return
	 */
	private JPasswordField getPassword() {
		if (password == null) {
			password = new JPasswordField();
			password.setBounds(new Rectangle(147, 58, 98, 23));
		}
		return password;
	}
	
	/**
	 * 得到手机号
	 * @return
	 */
	private JTextField getPhoneNumber() {
		if (phoneNumber == null) {
			phoneNumber = new JTextField();
			phoneNumber.setBounds(new Rectangle(147, 91, 98, 23));
		}
		return phoneNumber;
	}
	
	/**
	 * getSex
	 * @return
	 */
	private JComboBox getSex() {
		if (userType == null) {
			userType = new JComboBox();
			userType.addItem("男");
			userType.addItem("女");
			userType.setBounds(new Rectangle(147, 137, 98, 23));
		}
		return userType;
	}

	/**
	 * getReset 按钮
	 * @return
	 */
	private JButton getReset() {
		if (reset == null) {
			reset = new JButton("取消");
			reset.setBounds(new Rectangle(246, 180, 62, 26));
			reset.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					UpdateUserFrame.this.dispose();
					frame.setEnabled(true);
					AdminToolsBar.enableButton(null);
				}
			});
		}
		return reset;
	}
	
	/**
	 * getCommit 确定
	 * @return
	 */
	private JButton getCommit() {
		if (commit == null) {
			commit = new JButton("确定");
			commit.setBounds(new Rectangle(164, 180, 62, 26));
			commit.addMouseListener(new MouseAdapter() {
				@SuppressWarnings({ "deprecation", "static-access" })
				public void mouseClicked(MouseEvent e) {
				
					UserDao userDao = new UserDaoImpl();
					JOptionPane jp=new JOptionPane();
					String card = getUserCard().getText();
					String pass = getPassword().getText();
					String phone = getPhoneNumber().getText();
					String sexStr = getSex().getSelectedItem().toString();
					if(card.equals("") || pass.equals("") || phone.equals("")){
						jp.showMessageDialog(jp, "请将用户资料填写完整!");
					}else{
						User user = userDao.findUserOfUserCard(card);
						
						user.setPassword(pass);
						user.setPhoneNumber(phone);
						user.setSex(sexStr);
						System.out.println(user.getPassword());
						userDao.updateUser(user, card);
						jp.showMessageDialog(jp, "用户修改成功！");
						UpdateUserFrame.this.dispose();
						frame.setEnabled(true);
						AdminToolsBar.enableButton(null);
					}
				}
			});
		}
		return commit;
	}
}
