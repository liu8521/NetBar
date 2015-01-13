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
import cn.liuning.javabean.CurrentRecord;
import cn.liuning.utils.ScreenLocation;

public class ShowLogoutInfo extends JFrame{

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
	
	/**
	 * 输入框定义
	 */
	private JTextField userCard = null;
	private JTextField userName = null;
	private JTextField consume = null;
	private JTextField banlance = null;
	private JTextField duratime = null;
	
	private JButton cancel=null;
	private ImageIcon icon = null;
	static JFrame frame;
	static String card;
	static CurrentRecord record = null;
	
	
	/**
	 * 构造函数初始化
	 */
	public ShowLogoutInfo(){
		super();
		initialize();
	}
	
	/**
	 * 初始化方法初始化
	 */
	private void initialize() {
		this.setSize(373, 380);
		this.setContentPane(getJContentPanel());
		ImageIcon icon = new ImageIcon("image/user.png");
		this.setIconImage(icon.getImage());
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
			jLabel2.setBounds(new Rectangle(62, 65, 79, 24));
			jLabel2.setText("姓名：");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(62, 115, 79, 21));
			jLabel3.setText("消费：");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(62, 165, 79, 20));
			jLabel4.setText("余额：");
			jLabel5 = new JLabel();
			jLabel5.setText("累计时间：");
			jLabel5.setBounds(new Rectangle(52, 215, 79, 20));
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

			jContentPane.add(getUserCard(),null);
			jContentPane.add(getUserName(),null);
			jContentPane.add(getConsume(),null);
			jContentPane.add(getBanlance(),null);
			jContentPane.add(getDuratime(),null);
			jContentPane.add(getButton(),null);
		}
		return 	jContentPane;
	}
	
	/**
	 * 得到用户卡号
	 * @return
	 */
	private JTextField getUserCard() {
		if (userCard == null) {
			userCard = new JTextField();
			userCard.setHorizontalAlignment(JTextField.CENTER);
			userCard.setBounds(new Rectangle(150, 27, 79, 22));
			userCard.setEditable(false);
			userCard.setText(record.getUsercard());
		}
		return userCard;
	}
	
	/**
	 * 得到用户姓名
	 * @return
	 */
	private JTextField getUserName() {
		
		if (userName == null) {
			userName = new JTextField();
			userName.setHorizontalAlignment(JTextField.CENTER);
			userName.setBounds(new Rectangle(150, 71, 79, 23));
			userName.setEditable(false);
			userName.setText(record.getNickname());
		}
		return userName;
	
	}
	
	/**
	 * 得到消费金额
	 * @return
	 */
	private JTextField getConsume() {
		if (consume == null) {
			consume = new JTextField();
			consume.setHorizontalAlignment(JTextField.CENTER);
			consume.setBounds(new Rectangle(150, 115, 79, 23));
			consume.setEditable(false);
			consume.setText(record.getCurrentCost().toString());
		}
		return consume;
	}
	
	/**
	 * 得到余额
	 * @return
	 */
	private JTextField getBanlance() {
		if (banlance == null) {
			banlance = new JTextField();
			banlance.setHorizontalAlignment(JTextField.CENTER);
			banlance.setBounds(new Rectangle(150, 166, 79, 23));
			banlance.setEditable(false);
			banlance.setText(record.getExpectBanlance().toString());
		}
		return banlance;
	}
	
	/**
	 * 得到持续时间
	 * @return
	 */
	private JTextField getDuratime() {
		if (duratime == null) {
			duratime = new JTextField();
			banlance.setHorizontalAlignment(JTextField.CENTER);
			consume.setHorizontalAlignment(JTextField.CENTER);
			duratime.setBounds(new Rectangle(150, 212, 79, 23));
			duratime.setEditable(false);
			duratime.setText(record.getDuratime());
		}
		return duratime;
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
					ShowLogoutInfo.this.dispose();
					frame.dispose();
					UserFrame aaa = new UserFrame();
					ScreenLocation.setLocationMid(aaa, "用户登录");
				}
			});
		}
		return cancel;
	}
}











