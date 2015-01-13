package cn.liuning.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import cn.liuning.utils.ScreenLocation;


/**
 * 管理员主界面    菜单栏
 * menuMenu   ：菜单
 * helpMenu   ：帮助
 * manageMenu ：管理
 * viewMenu   ：视图
 * statMenu   ： 统计报表
 */

public class AdminMenuBar {
	
	/**
	 * 菜单条：JMenuBar
	 */
	private JMenuBar menuBar=null;
	private JMenu menuMenu=null;
	private JMenu helpMenu=null;
	private JMenu manageMenu=null;
	private JMenu viewMenu=null;
	private JMenu statMenu=null;
	private JMenuItem sysItem=null;
	private JMenuItem exitItem=null;
	private JMenuItem deleteItem=null;
	private JMenuItem addItem=null;
	private JMenuItem updateItem=null;
	private JMenuItem findItem=null;
	private JMenuItem homeItem=null;
	private JMenuItem onlineItem=null;
	private JMenuItem statItem=null;
	private JMenuItem personItem=null;
	private JMenuItem incomeItem=null;
	private JMenuItem contactUsItem=null;
	private JMenuItem aboutsysItem=null;
	private JMenuItem login = null;
	private JMenuItem logout = null;
	static JFrame frame;
	
	/**
	 * 得到 管理员界面的 MenuBar
	 * @return:JMenuBar
	 */
	public JMenuBar getAdminJMenuBar(){
		if(menuBar == null){
			menuBar = new JMenuBar();
			menuBar.add(getMenuMenu());
			menuBar.add(getManageMenu());
			menuBar.add(getViewMenu());
			menuBar.add(getStatMenu());
			menuBar.add(getHelpMenu());
		}
		return menuBar;
	}

	/**
	 * 帮助选项
	 * @return
	 */
	private JMenu getHelpMenu() {
		helpMenu = new JMenu("帮助(H)");
		contactUsItem = new JMenuItem("联系我们");
		contactUsItem.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JOptionPane jp = new JOptionPane();
				String str = "网吧管理系统\n"+
							"Version: 1.0\n"+
							"Author: LiuNing/YanXiuhao\n"+
							"1127746065@qq.com";
				jp.showMessageDialog(jp, str);
			}
		});
		aboutsysItem = new JMenuItem("关于系统");
		aboutsysItem.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JOptionPane jp = new JOptionPane();
				String str = "请联系:liu8521@live.com";
				jp.showMessageDialog(jp, str);
			}
		});
		helpMenu.add(contactUsItem);
		helpMenu.add(aboutsysItem);
		return helpMenu;
	}

	/**
	 * 统计选项
	 * @return
	 */
	private JMenu getStatMenu() {
		statMenu = new JMenu("统计报表(T)");
		personItem = new JMenuItem("人数报表");
		personItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminToolsBar.temp=false;
				// TODO 自动生成的方法存根
				AdminToolsBar.enableButton(AdminToolsBar.statButton);
				AdminFrame.leftPanel=LeftPanel.leftPanel;
				AdminFrame.leftPanel.removeAll();
				
				AdminFrame.leftPanel=LeftPanel.getLeftPanel2();
				AdminFrame.centerPanel.setViewportView(null);
				AdminFrame.leftPanel.updateUI();
				AdminFrame.centerPanel.updateUI();
			}
		});
		incomeItem = new JMenuItem("收入报表");
		incomeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				AdminToolsBar.temp=false;
				AdminToolsBar.enableButton(AdminToolsBar.statButton);
				AdminFrame.leftPanel=LeftPanel.leftPanel;
				AdminFrame.leftPanel.removeAll();
				
				AdminFrame.leftPanel=LeftPanel.getLeftPanel2();
				AdminFrame.centerPanel.setViewportView(null);
				AdminFrame.leftPanel.updateUI();
				AdminFrame.centerPanel.updateUI();
			}
		});
		statMenu.add(personItem);
		statMenu.add(incomeItem);
		return statMenu;
	}

	/**
	 * 视图选项
	 * @return
	 */
	@SuppressWarnings("static-access")
	private JMenu getViewMenu() {
		viewMenu = new JMenu("视图(V)");
		homeItem = new JMenuItem("主页视图");
		homeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				AdminToolsBar.temp=true;
				AdminFrame.centerPanel.setViewportView(new TableData().getJTable());
				
				AdminFrame.leftPanel=LeftPanel.getLeftPanel();
				AdminFrame.leftPanel.removeAll();
				AdminFrame.leftPanel=LeftPanel.getLeftPanel();
				AdminFrame.centerPanel.updateUI();
				
				AdminToolsBar.enableButton(AdminToolsBar.homeButton);
				AdminToolsBar.enableButton(AdminToolsBar.homeButton);
			}
		});
		onlineItem = new JMenuItem("在线用户");
		onlineItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminToolsBar.temp=true;
				if(AdminToolsBar.count%2 == 0){
					AdminFrame.centerPanel.setViewportView(TableData.getJTable2());
					AdminToolsBar.count++;
				}else{
					AdminFrame.centerPanel.setViewportView(TableData.getJTable());
					AdminToolsBar.count++;
				}
			}
		});
		statItem = new JMenuItem("统计视图");
		statItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				AdminToolsBar.temp=false;
				AdminToolsBar.enableButton(AdminToolsBar.statButton);
				AdminFrame.leftPanel=LeftPanel.leftPanel;
				AdminFrame.leftPanel.removeAll();
				
				AdminFrame.leftPanel=LeftPanel.getLeftPanel2();
				AdminFrame.centerPanel.setViewportView(null);
				AdminFrame.leftPanel.updateUI();
				AdminFrame.centerPanel.updateUI();
			}
		});
		viewMenu.add(homeItem);
		viewMenu.add(onlineItem);
		viewMenu.add(statItem);
		return viewMenu;
	}

	/**
	 * 管理选项
	 * @return
	 */
	private JMenu getManageMenu() {
		manageMenu = new JMenu("管理(A)");
		addItem = new JMenuItem("增加会员");
		addItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				AddUserFrame.frame=frame;
				final AddUserFrame addFrame = new AddUserFrame();
				ScreenLocation.setLocationMid(addFrame, "用户增加");
				
				addFrame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e){
						frame.setEnabled(true);
						AdminToolsBar.enableButton(null);
					}
				});
				frame.setEnabled(false);
				AdminToolsBar.enableButton(AdminToolsBar.addButton);
			}
		});
		deleteItem = new JMenuItem("删除会员");
		deleteItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				DeleteUserFrame.frame=frame;
				final DeleteUserFrame deleteFrame = new DeleteUserFrame();
				ScreenLocation.setLocationMid(deleteFrame, "删除用户");
				
				deleteFrame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e){
						AdminToolsBar.enableButton(null);
						frame.setEnabled(true);
					}
				});
				
				frame.setEnabled(false);
				AdminToolsBar.enableButton(AdminToolsBar.deleteButton);
			}
		});
		updateItem = new JMenuItem("信息修改");
		updateItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				UpdateUserFrame.frame = frame;
				UpdateUserFrame update = new UpdateUserFrame();
				update.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e){
						AdminToolsBar.enableButton(null);
						frame.setEnabled(true);
					}
				});
				ScreenLocation.setLocationMid(update, "修改信息");
				
				frame.setEnabled(false);
				AdminToolsBar.enableButton(AdminToolsBar.updateButton);
			}
		});
		findItem = new JMenuItem("信息查询");
		findItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FindUserFrame.frame = frame;
				FindUserFrame find = new FindUserFrame();
				find.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e){
						AdminToolsBar.enableButton(null);
						frame.setEnabled(true);
					}
				});
				ScreenLocation.setLocationMid(find, "修改信息");
				frame.setEnabled(false);
				AdminToolsBar.enableButton(AdminToolsBar.findButton);
			}
		});
		manageMenu.add(addItem);
		manageMenu.add(deleteItem);
		manageMenu.add(updateItem);
		manageMenu.add(findItem);
		return manageMenu;
	}

	/**
	 * 菜单 选项
	 * @return
	 */
	private JMenu getMenuMenu() {
		menuMenu = new JMenu("菜单(M)");
		sysItem = new JMenuItem("系统设置");
		login = new JMenuItem("上机");
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				LoginFrame_ loginFrame = new LoginFrame_();
				ScreenLocation.setLocationMid(loginFrame, "上机");
			}
		});
		logout = new JMenuItem("下机");
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				LogoutFrame_ logoutFrame = new LogoutFrame_();
				ScreenLocation.setLocationMid(logoutFrame, "下机");
			}
		});
		sysItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SetUpFrame.frame=frame;
				final SetUpFrame setup = new SetUpFrame();
				ScreenLocation.setLocationMid(setup, "设置");
				setup.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e){
						AdminToolsBar.enableButton(null);
						frame.setEnabled(true);
					}
				});
				frame.setEnabled(false);
				
			}
		});
		exitItem = new JMenuItem("退出系统");
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		
		
		menuMenu.add(login);
		menuMenu.add(logout);
		menuMenu.add(sysItem);
		menuMenu.add(exitItem);
		return menuMenu;
	}
	
	
}
