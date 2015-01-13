package cn.liuning.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.Timer;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import cn.liuning.dao.BackupRecordDao;
import cn.liuning.dao.ComputerDao;
import cn.liuning.dao.CurrentRecordDao;
import cn.liuning.dao.UserDao;
import cn.liuning.dao.impl.BackupRecordDaoImpl;
import cn.liuning.dao.impl.ComputerDaoImpl;
import cn.liuning.dao.impl.CurrentRecordDaoImpl;
import cn.liuning.dao.impl.UserDaoImpl;
import cn.liuning.javabean.BackupRecord;
import cn.liuning.javabean.CurrentRecord;
import cn.liuning.javabean.User;
import cn.liuning.utils.ScreenLocation;

public class UserFrame extends JFrame implements Runnable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 菜单项
	 */
	JMenuBar menuBar = null;
	JMenu menuMenu=null;
	JMenuItem logInItem=null;
	JMenuItem logOutItem=null;
	JMenuItem exitSysItem=null;
	JMenu findMenu=null;
	JMenu helpMenu=null;
	JMenuItem contactUsMenu=null;
	
	/**
	 * 工具条
	 */
	JToolBar toolBar=null;
	JButton loginButton = null;
	JButton logoutButton = null;

	/**
	 * left显示区
	 */
	JPanel leftPanel = null;
	JLabel sysLabel = null;
	JLabel sysLabel1 = null;
	JLabel timeLabel = null;
	JLabel dateLabel  = null;
	
	/**
	 * center 显示区
	 */
	JPanel centerPanel =new JPanel();
	
	/**
	 * 上机界面
	 */
	JLabel pcNumberLabel = null;
	JComboBox pcNumber = null;
	JLabel userCardLabel = null;
	JTextField userCard = null;
	JLabel passLabel = null;
	JPasswordField password = null;
	JButton confirm =null;
	JButton cancel = null;
	
	/**
	 * 下机界面
	 */
	JLabel userCardLabel_o = null;
	JTextField userCard_o = null;
	JLabel passLabel_o = null;
	JPasswordField password_o = null;
	JButton confirm_o = null;
	JButton cancel_o = null;
	
	/**
	 * 工具字段
	 */
	static int x=0;
	static int y=0;
	static int z=0;
	boolean logout = false;
	boolean leag = false;
	boolean loginTemp = false;
	Timer timer = null;
	String flageTime="";
	List<JButton> list = new ArrayList<JButton>();
	List<String> hostList = new ArrayList<String>();
	String host_Nu="";
	
	/**
	 * 主函数
	 */
	public static void main(String[] args) {
		UserFrame userFrame = new UserFrame();
		ScreenLocation.setLocationMid(userFrame,"用户界面");
	}
	
	/**
	 * 构造函数初始化
	 */
	public UserFrame(){
		initial();
		ImageIcon icon = new ImageIcon("image/user.png");
		this.setIconImage(icon.getImage());
		this.setLayout(new BorderLayout(3, 3));
		this.setJMenuBar(menuBar);
		this.add(toolBar,BorderLayout.NORTH);
		this.add(getLeftPanel(),BorderLayout.WEST);
		this.add(centerPanel,BorderLayout.CENTER);
		this.setTitle("用户菜单");
        this.setSize(600,450);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
	}
	
	/**
	 * 初始化方法初始化
	 */
	private void initial(){
		initialMenu();
		loginInitial();
	}
	
	/**
	 * 得到左部显示面板
	 * @return
	 */
	private JPanel getLeftPanel(){
		//系统时间标签
		sysLabel = new JLabel("上网持续时间:",JLabel.CENTER);
		sysLabel.setBounds(new Rectangle(8, 53, 100, 36));
		sysLabel.setFont(new Font("宋体", Font.BOLD, 14));
		sysLabel1 = new JLabel("",JLabel.CENTER);
		sysLabel1.setBounds(new Rectangle(8, 93, 100, 36));
		sysLabel1.setFont(new Font("宋体", Font.BOLD, 14));
		//日期标签
		dateLabel = new JLabel("",JLabel.CENTER);
		dateLabel.setFont(new Font("宋体", Font.BOLD, 14));
		dateLabel.setBounds(new Rectangle(8, 265, 90, 33));
		//时间标签
		timeLabel = new JLabel("",JLabel.CENTER);
		timeLabel.setFont(new Font("宋体", Font.BOLD, 14));
		timeLabel.setBounds(new Rectangle(8, 295, 90, 33));
		Thread t = new Thread(this);
		t.start();
		//加入左部面板
		leftPanel = new JPanel();
		leftPanel.setLayout(null);
		leftPanel.add(sysLabel);
		leftPanel.add(sysLabel1);
		leftPanel.add(dateLabel);
		leftPanel.add(timeLabel);
		leftPanel.setBorder(new CompoundBorder(new EtchedBorder(),
				new LineBorder(null)));
		leftPanel.setPreferredSize(new Dimension(120,330));
		
		return leftPanel;
	}
	
	/**
	 * 菜单栏工具栏初始化
	 */
	private void initialMenu(){
		/*
		 * 菜单
		 */
		menuBar = new JMenuBar();
		//菜单(M)
		menuMenu = new JMenu("菜单(M)");
		menuMenu.setMnemonic('M');
		logInItem = new JMenuItem("上机");
		logInItem.addActionListener(listener);
		logOutItem = new JMenuItem("下机");
		logOutItem.addActionListener(listener2);
		exitSysItem = new JMenuItem("退出系统");
		exitSysItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				UserFrame.this.dispose();
			}
		});
		menuMenu.add(logInItem);
		menuMenu.add(logOutItem);
		menuMenu.add(exitSysItem);
		
		//查看(F)
		findMenu = new JMenu("查看(F)");
		findMenu.setMnemonic('F');
		//帮助(H)
		helpMenu = new JMenu("帮助(H)");
		helpMenu.setMnemonic('H');
		contactUsMenu = new JMenuItem("联系我们(O)");
		contactUsMenu.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane jp = new JOptionPane();
				String str = "网吧管理系统\n"+
							"Version: 1.0\n"+
							"Author: LiuNing/YanXiuhao";
				jp.showMessageDialog(jp, str);
			}
		});
		helpMenu.add(contactUsMenu);
		//将组件加入菜单条 里面
		menuBar.add(menuMenu);
		menuBar.add(findMenu);
		menuBar.add(helpMenu);
		
		/*
		 * 工具条
		 */
		toolBar = new JToolBar();
		loginButton = new JButton(new ImageIcon("image/login.jpg"));
		logoutButton = new JButton(new ImageIcon("image/logoff.jpg"));
		if(!loginTemp){
			logoutButton.setEnabled(false);
		}
		logoutButton.addActionListener(listener2);
		//加入工具条
		toolBar.add(new JLabel("|   "));
		toolBar.add(loginButton);
		toolBar.add(new JLabel("   |   "));
		toolBar.add(logoutButton);
		toolBar.add(new JLabel("   |   "));
	}
	
	/**
	 * 中间窗体初始化
	 */
	private void loginInitial(){
		//机号
		pcNumberLabel = new JLabel("机号：");
		pcNumberLabel.setFont(new Font("宋体", Font.BOLD, 14));
		pcNumberLabel.setBounds(89, 43, 45, 26);
		pcNumber = new JComboBox();
		ComputerDao conputerDao = new ComputerDaoImpl();
		List<String> list = conputerDao.findFreeHost("offline");
		for(int j=0;j<list.size();j++){
			pcNumber.addItem(list.get(j));
		}
		pcNumber.setBounds(141, 43, 124, 26);
		
		//卡号
		userCardLabel = new JLabel("卡号:");
		userCardLabel.setFont(new Font("宋体", Font.BOLD, 14));
		userCardLabel.setBounds(89, 103, 45, 26);
		userCard = new JTextField();
		userCard.setBounds(141, 103, 124, 26);
		userCard.setColumns(10);
		
		//密码
		passLabel = new JLabel("密码:");
		passLabel.setFont(new Font("宋体", Font.BOLD, 14));
		passLabel.setBounds(89, 164, 45, 26);
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(141, 165, 124, 26);
		
		//上机按钮
		confirm = new JButton("上机");
		confirm.setBounds(83, 233, 82, 33);
		confirm.addActionListener(listener);
		//重置按钮
		cancel = new JButton("重置");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userCard.setText("");
				password.setText("");
			}
		});
		cancel.setBounds(200, 233, 88, 33);
		
		centerPanel.setLayout(null);
		centerPanel.add(pcNumberLabel);
		centerPanel.add(pcNumber);
		centerPanel.add(userCardLabel);
		centerPanel.add(userCard);
		centerPanel.add(passLabel);
		centerPanel.add(password);
		centerPanel.add(confirm);
		centerPanel.add(cancel);
		centerPanel.setPreferredSize(new Dimension(600,350));
	}
	
	/**
	 * 下机监听
	 */
	ActionListener listener2 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int i = JOptionPane.showConfirmDialog(null, "确定下机吗？","",JOptionPane.YES_NO_OPTION);
			
			UserDao userDao = new UserDaoImpl();
			ComputerDao computerDao = new ComputerDaoImpl();
			CurrentRecordDao currentDao = new CurrentRecordDaoImpl();
			BackupRecordDao backupDao = new BackupRecordDaoImpl();
			
			if(i == 0){
				//更新用户表状态
				userDao.updateState_Offline(userCard.getText());
				
				CurrentRecord record = currentDao.findRecordOfUserCard(userCard.getText());
				User user = userDao.findUserOfUserCard(userCard.getText());
				user.setBanlace(record.getExpectBanlance());
				System.out.println(user.getBanlace());
				//更新用户余额
				userDao.updateUser(user, userCard.getText());
				//更新主机表状态
				computerDao.deleteHostState(record.getHostnumber(), "offline");
				@SuppressWarnings("deprecation")
				String str = record.getStarttime().toLocaleString();
				String year = str.split(" ")[0].split("-")[0];
				String month = str.split(" ")[0].split("-")[1];
				String day = str.split(" ")[0].split("-")[2];
				
				//插入备份表
				BackupRecord backup = new BackupRecord();
				backup.setConsume(record.getCurrentCost());
				backup.setDay(day);
				backup.setDuraTime(sysLabel1.getText());
				backup.setHostnumber(host_Nu);
				backup.setId(0);
				backup.setMonth(month);
				backup.setNickname(record.getNickname());
				backup.setOverTime(new Date());
				backup.setStartTime(record.getStarttime());
				backup.setUsercard(record.getUsercard());
				backup.setYear(year);
				backupDao.insertIntoBaRecord(backup);
				
				//删除实时记录表状态
				currentDao.deleteRecord(record.getUsercard());
				
				logout = true;
				
				//切换 下机数据显示界面
				ShowLogoutInfo.frame=UserFrame.this;
				ShowLogoutInfo.record = record;
				ShowLogoutInfo showLogout = new ShowLogoutInfo();
				ScreenLocation.setLocationMid(showLogout, "信息显示");
				
			}else{
				
			}
		}
	};
	
	/**
	 * 上机监听器
	 */
	ActionListener listener = new ActionListener() {
		
		@SuppressWarnings({ "static-access", "deprecation" })
		@Override
		public void actionPerformed(ActionEvent e) {
			UserDao userDao = new UserDaoImpl();
			ComputerDao computerDao = new ComputerDaoImpl();
			CurrentRecordDao currentDao = new CurrentRecordDaoImpl();

			JOptionPane jp = new JOptionPane();
			if(userCard.getText().equals("") 
					|| userCard.getText()==null
					 ||	password.getText().equals("") 
					  || password.getText()==null ){
				jp.showMessageDialog(UserFrame.this, "用户名或密码为空");
			}else {
				User user = userDao.findUserOfUserCard(userCard.getText());
				if(user == null){
					jp.showMessageDialog(UserFrame.this, "系统不存在此用户！");
				}
				else if(user.getUserState().equals("online")){
					jp.showMessageDialog(UserFrame.this, "用户已在线请先下机！");
				}
				else{
					//更新用户状态
					userDao.updateState_Online(userCard.getText());
					//更新主机状态
					host_Nu = pcNumber.getSelectedItem().toString();
					computerDao.updateHostState(userCard.getText(),
							user.getNickname(), host_Nu, "online");
					//更新实时记录表
					CurrentRecord record = new CurrentRecord();
					record.setCurrentCost(new BigDecimal(0));
					record.setDuratime("00:00:00");
					record.setExpectBanlance(user.getBanlace());
					record.setHostnumber(pcNumber.getSelectedItem().toString());
					record.setId(0);
					record.setNickname(user.getNickname());
					record.setStarttime(new Date());
					record.setUsercard(user.getUsercard());
					//插入实时记录表
					currentDao.addRecord(record);
					
					//开启余额检测
					timer = new Timer(6000,listener3);
				    timer.start();
				    
					jp.showMessageDialog(UserFrame.this, "上机成功！");
					sysLabel1.setText("00:00:00");
					confirm.setEnabled(false);
					cancel.setEnabled(false);
					logoutButton.setEnabled(true);
					
				}
			}
		}
	};

	
	/**
	 * 余额不足自动下机
	 */
	ActionListener listener3 = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			CurrentRecordDao currentDao = new CurrentRecordDaoImpl();
			CurrentRecord record = currentDao.findRecordOfUserCard(userCard.getText());
			
			if(record!=null && record.getExpectBanlance().compareTo(new BigDecimal(1.0)) < 0){
				UserDao userDao = new UserDaoImpl();
				ComputerDao computerDao = new ComputerDaoImpl();
				BackupRecordDao backupDao = new BackupRecordDaoImpl();
				
				//更新用户余额
				User user =  userDao.findUserOfUserCard(userCard.getText());
				user.setBanlace(record.getExpectBanlance());
				userDao.updateUser(user, userCard.getText());
				//更新用户表状态
				userDao.updateState_Offline(userCard.getText());

				//更新主机表状态
				computerDao.deleteHostState(record.getHostnumber(), "offline");
				@SuppressWarnings("deprecation")
				String str = record.getStarttime().toLocaleString();
				String year = str.split(" ")[0].split("-")[0];
				String month = str.split(" ")[0].split("-")[1];
				String day = str.split(" ")[0].split("-")[2];
				
				//插入备份表
				BackupRecord backup = new BackupRecord();
				backup.setConsume(record.getCurrentCost());
				backup.setDay(day);
				backup.setDuraTime(sysLabel1.getText());
				backup.setHostnumber(host_Nu);
				backup.setId(0);
				backup.setMonth(month);
				backup.setNickname(record.getNickname());
				backup.setOverTime(new Date());
				backup.setStartTime(record.getStarttime());
				backup.setUsercard(record.getUsercard());
				backup.setYear(year);
				backupDao.insertIntoBaRecord(backup);
				
				//删除实时记录表状态
				currentDao.deleteRecord(record.getUsercard());
				
				logout = true;
				
				//切换 下机数据显示界面
				ShowLogoutInfo.frame=UserFrame.this;
				ShowLogoutInfo.record = record;
				ShowLogoutInfo showLogout = new ShowLogoutInfo();
				ScreenLocation.setLocationMid(showLogout, "余额不足");
			}else{
				System.out.println("余额充足");
			}
			
		}
	
	};
	/**
	 * 系统时间显示
	 */
	@SuppressWarnings("deprecation")
	public void run() {
		 while(true){
		    Date date = new Date();
			String dateAndtime = date.toLocaleString();
			String day = dateAndtime.split(" ")[0];
			String time = dateAndtime.split(" ")[1];
			dateLabel.setText(day);
			timeLabel.setText(time);
			String time2 = sysLabel1.getText();
			if(!(time2.equals("") || time2==null)){
				z = Integer.parseInt(time2.split(":")[0]);
				y = Integer.parseInt(time2.split(":")[1]);
				x = Integer.parseInt(time2.split(":")[2]);
				if(logout){
					
				}else{
					x=x+1;
				}
				
				sysLabel1.setText(getContinueTime());
			}
		    try {
		    	Thread.sleep(1000);
		    	x++;
		    	String str = getContinueTime();
		    	if(leag){
		    		if(loginTemp){
		    			flageTime=str;
		    		}
		    		sysLabel1.setText(flageTime);
		    	}
		    } catch (InterruptedException e) {
		     e.printStackTrace();  
		    }
		 }
	}
	
	/**
	 * 组装持续时间的方法
	 */
	private String getContinueTime(){
		
		if(x>=60){
    		y=y+1;
    		x=x%60;
    	}
    	if(y>=60){
    		z=z+1;
    		y=y%60;
    	}
    	String str = "";
    	if(z<10){
    		str=str+"0"+String.valueOf(z);
    	}else{
    		str += String.valueOf(z);
    	}
    	str+=":";
    	if(y<10){
    		str=str+"0"+String.valueOf(y);
    	}else{
    		str += String.valueOf(y);
    	}
    	str+=":";
    	if(x<10){
    		str=str+"0"+String.valueOf(x);
    	}else{
    		str += String.valueOf(x);
    	}
    	return str;
	}

}











