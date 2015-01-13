package cn.liuning.UI;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.liuning.dao.UserDao;
import cn.liuning.dao.impl.UserDaoImpl;
import cn.liuning.javabean.User;

public class ShowUserInfoFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	/**
	 * label定义
	 */
	private JPanel jContentPane = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	/**
	 * 输入框定义
	 */
	private JTextField userCard = null;
	private JTextField password = null;
	private JTextField addMoney = null;
	private JTextField userLevel = null;
	private JTextField userName = null;
	private JTextField phoneNumber = null;
	private JTextField idCardNumber = null;
	private JTextField sex = null;

	private JButton cancel=null;
	private ImageIcon icon = null;
	static JFrame frame;
	static String card;
	User user = null;
	
	/**
	 * 构造函数初始化
	 */
	public ShowUserInfoFrame(){
		super();
		UserDao userDao = new UserDaoImpl();
		user = userDao.findUserOfUserCard(card);
		initialize();
	}
	
	/**
	 * 初始化方法初始化
	 */
	private void initialize() {
		
		this.setSize(373, 380);
		this.setContentPane(getJContentPanel());
	}
	
	/**
	 * 中部面板初始化
	 */
	private JPanel getJContentPanel() {
		
		if(jContentPane == null){
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(52, 27, 79, 22));
			jLabel1.setText("会员卡号：");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(52, 57, 68, 24));
			jLabel2.setText("注册时间：");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(52, 90, 68, 21));
			jLabel3.setText("会员余额：");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(65, 124, 66, 20));
			jLabel4.setText("状态：");
			jLabel7 = new JLabel();
			jLabel7.setText("手机号：");
			jLabel7.setBounds(new Rectangle(62, 158, 79, 21));
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(65, 190, 40, 23));
			jLabel5.setText("姓名：");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(50, 230, 79, 21));
			jLabel6.setText("身份证号码：");
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(65, 265, 40, 23));
			jLabel8.setText("性别：");

			icon  = new  ImageIcon("image/back.jpg");
			jContentPane = new JPanel(){
				private static final long serialVersionUID = 1L;

				protected void paintComponent(Graphics g) {
                    g.drawImage(icon.getImage(), 0, 0, null);
                    super.paintComponent(g);
				}

			};
			jContentPane.setOpaque(false);
			jContentPane.setLayout(null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(jLabel7, null);
			jContentPane.add(jLabel8, null);
			jContentPane.add(getUserCard(),null);
			jContentPane.add(getRegisterTime(),null);
			jContentPane.add(getBanlance(),null);
			jContentPane.add(getStates(),null);
			jContentPane.add(getPhoneNumber(),null);
			jContentPane.add(getUserName(),null);
			jContentPane.add(getIdCardNumber(),null);
			jContentPane.add(getSex(),null);
			jContentPane.add(getButton(),null);
		}
		return 	jContentPane;
	}
	
	/**
	 * 得到性别
	 * @return
	 */
	private JTextField getSex() {
		if (sex == null) {
			sex = new JTextField();
			sex.setBounds(new Rectangle(143, 270, 120, 20));
			sex.setEditable(false);
			sex.setText(user.getSex());
		}
		return sex;
	}
	
	/**
	 * getPhoneNumber
	 * @return
	 */
	private JTextField getPhoneNumber() {
		
		if (phoneNumber == null) {
			phoneNumber = new JTextField();
			phoneNumber.setBounds(new Rectangle(143, 158, 120, 23));
			phoneNumber.setEditable(false);
			phoneNumber.setText(user.getPhoneNumber());
		}
		return phoneNumber;
	
	}
	
	/**
	 * getIdCardNumber
	 * @return
	 */
	private JTextField getIdCardNumber() {
		if (idCardNumber == null) {
			idCardNumber = new JTextField();
			idCardNumber.setBounds(new Rectangle(143, 234, 154, 23));
			idCardNumber.setEditable(false);
			idCardNumber.setText(user.getLicenceNumber());
		}
		return idCardNumber;
	}
	
	/**
	 * getUserName
	 * @return
	 */
	private JTextField getUserName() {
		if (userName == null) {
			userName = new JTextField();
			userName.setBounds(new Rectangle(143, 194, 120, 23));
			userName.setEditable(false);
			userName.setText(user.getNickname());
		}
		return userName;
	}
	
	/**
	 * getStates
	 * @return
	 */
	private JTextField getStates() {
		if (userLevel == null) {
			userLevel = new JTextField();
			userLevel.setBounds(new Rectangle(143, 123, 120, 23));
			userLevel.setEditable(false);
			userLevel.setText(user.getUserState());
		}
		return userLevel;
	}
	
	/**
	 * getBanlance
	 * @return
	 */
	private JTextField getBanlance() {
		if (addMoney == null) {
			addMoney = new JTextField();
			addMoney.setBounds(new Rectangle(143, 91, 120, 23));
			addMoney.setEditable(false);
			addMoney.setText(user.getBanlace().toString());
		}
		return addMoney;
	}
	
	/**
	 * getRegisterTime
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private JTextField getRegisterTime() {
		if (password == null) {
			password = new JTextField();
			password.setBounds(new Rectangle(143, 58, 120, 23));
			password.setEditable(false);
			password.setText(user.getRegisterTime().toLocaleString());
		}
		return password;
	}
	
	/**
	 * getUserCard
	 * @return
	 */
	private JTextField getUserCard() {
		if (userCard == null) {
			userCard = new JTextField();
			userCard.setBounds(new Rectangle(143, 29, 120, 23));
			userCard.setEditable(false);
			userCard.setText(user.getUsercard());
		}
		return userCard;
	}
	
	/**
	 * 按钮 确定事件
	 * @return
	 */
	private JButton getButton() {
		if (cancel == null) {
			cancel = new JButton("确定");
			cancel.setBounds(new Rectangle(68, 305, 60, 29));
			cancel.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					ShowUserInfoFrame.this.dispose();
					frame .setEnabled(true);
					AdminToolsBar.enableButton(null);
				}
			});
		}
		return cancel;
	}
}











