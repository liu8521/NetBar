package cn.liuning.UI;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.liuning.dao.UserDao;
import cn.liuning.dao.impl.UserDaoImpl;
import cn.liuning.javabean.User;


public class AddMoneyFrame extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jContentPanel = null;
	private JLabel	jLabel	= null;
	private JButton	commit= null;
	private JButton	reset= null;
	private JTextField	userCard= null;
	private JTextField addValue;
	private JLabel jLabel2;
	static JFrame frame;
	
	/**
	 * 构造函数初始化
	 */
	public AddMoneyFrame(){
		super();
		initialize();
	}

	/**
	 * 初始化方法
	 */
	private void initialize() {
		ImageIcon icon = new ImageIcon("image/addmoney.png");
		this.setIconImage(icon.getImage());
		this.setSize(330, 250);
		this.setContentPane(getJContentPane());
	}

	/**
	 * 容器初始化
	 * @return JPanel
	 */
	private JPanel getJContentPane() {
		if(jContentPanel == null){
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(44, 29, 79, 22));
			jLabel.setText("会员卡号：");
			
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(44, 70, 79, 22));
			jLabel2.setText("充值金额：");
			
			jContentPanel = new JPanel();
			jContentPanel.setLayout(null);
			jContentPanel.add(jLabel, null);
			jContentPanel.add(jLabel2, null);
			jContentPanel.add(getCommit(), null);
			jContentPanel.add(getReset(), null);
			jContentPanel.add(getUserCard(), null);
			jContentPanel.add(getAddValue(), null);
		}
		return jContentPanel;
	}

	/**
	 * 获取用户名
	 * @return JTextField
	 */
	private JTextField getUserCard() {
		if (userCard == null){
		
			userCard = new JTextField();
			userCard.setBounds(new Rectangle(147, 29, 98, 23));
		}
		return userCard;
	}
	
	/**
	 * 获取值
	 * @return JTextField
	 */
	private JTextField getAddValue() {
		if (addValue == null){
			addValue = new JTextField();
			addValue.setBounds(new Rectangle(147, 70, 98, 23));
		}
		return addValue;
	}
	
	/**
	 * 获取取消按钮
	 * @return JButton
	 */
	private JButton getReset() {
		if (reset == null){
			reset = new JButton("取消");
			reset.setBounds(new Rectangle(178, 145, 62, 26));
			reset.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					AddMoneyFrame.this.dispose();
					frame.setEnabled(true);
					AdminToolsBar.enableButton(null);
				}
			});
		}
		return reset;
	}

	/**
	 * 获取确定按钮
	 * @return JButton
	 */
	private JButton getCommit() {
		if (commit == null){
			commit = new JButton("确定");
			commit.setBounds(new Rectangle(72, 145, 62, 26));
			commit.addMouseListener(new MouseAdapter(){
				
				@SuppressWarnings("static-access")
				public void mouseClicked(MouseEvent e)	{
			
					String str = getUserCard().getText();
					String addMoney = getAddValue().getText();
					JOptionPane jp = new JOptionPane();
					if (str.equals("") || str == null ||addMoney.equals("")){
						jp.showMessageDialog(jp, "用户卡号或金额为空!");
					}else{
						UserDao userDao = new UserDaoImpl();
						User user = userDao.findUserOfUserCard(str);
						if(user == null){
							jp.showMessageDialog(jp, "用户不存在!");
						}else{
							
							double money= Double.valueOf(addMoney);
							
							userDao.recharge(money, str);
							
							jp.showMessageDialog(jp, "用户充值成功!");
							AddMoneyFrame.this.dispose();
							frame.setEnabled(true);
							AdminToolsBar.enableButton(null);
						
						}
					}
				}
			});
		}
		return commit;
	}
	
}










