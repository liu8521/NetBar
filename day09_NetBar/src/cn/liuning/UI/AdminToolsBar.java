package cn.liuning.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import cn.liuning.utils.ScreenLocation;

public class AdminToolsBar {
	
	 static JToolBar toolBar;
	 static JButton addButton;
	 static JButton deleteButton;
	 static JButton updateButton;
	 static JButton findButton;
	 static JButton payforButton;
	 static JButton statButton;
	 static JButton helpButton;
	 static JButton setupButton;
	 static JButton homeButton;
	static JFrame frame;
	static boolean temp= true;
	
	private static List<JButton> list = new ArrayList<JButton>();
	
	public JToolBar getAdminToolsBar(){
		if(toolBar == null){
			
			toolBar = new JToolBar();	
			toolBar.add(new JLabel("    "));
			toolBar.add(getHomeButton());
			toolBar.add(new JLabel("     "));
			toolBar.add(getAddButton());
			toolBar.add(new JLabel("     "));
			toolBar.add(getDeleteButton());
			toolBar.add(new JLabel("     "));
			toolBar.add(getUpdateButton());
			toolBar.add(new JLabel("     "));
			toolBar.add(getFindButton());
			toolBar.add(new JLabel("     "));
			toolBar.add(getPayforButton());
			toolBar.add(new JLabel("     "));
			toolBar.add(getStatButton());
			toolBar.add(new JLabel("     "));
			toolBar.add(getSetupButton());
			toolBar.add(new JLabel("     "));
			toolBar.add(getHelpButton());
			toolBar.add(new JLabel("     "));
		}
		return toolBar;
	}

	/**
	 * 设置按钮
	 * @return
	 */
	private JButton getSetupButton() {
		
		if(setupButton == null){
			
			setupButton = new JButton(new ImageIcon("image/setup2.jpg"));
			setupButton.setToolTipText("设置");
			setupButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
					SetUpFrame.frame=frame;
					final SetUpFrame setup = new SetUpFrame();
					ScreenLocation.setLocationMid(setup, "设置");
					
					setup.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e){
							enableButton(null);
							frame.setEnabled(true);
						}
					});
					frame.setEnabled(false);
					enableButton(setupButton);
				}
			});
		
		}
		return setupButton;
	}
	/**
	 * 帮助按钮
	 * @return
	 */
	static int count=0;
	private JButton getHelpButton() {
	
		if (helpButton == null) {
			helpButton = new JButton(new ImageIcon("image/help2.jpg"));
			helpButton.setToolTipText("帮助");
			helpButton.addActionListener(new ActionListener() {
				
				@SuppressWarnings("static-access")
				@Override
				public void actionPerformed(ActionEvent e) {
					AdminToolsBar.temp=true;
					enableButton(null);
					if(count%2 == 0){
						AdminFrame.centerPanel.setViewportView(new TableData().getJTable2());
						count++;
					}else{
						AdminFrame.centerPanel.setViewportView(new TableData().getJTable());
						count++;
					}
					AdminFrame.leftPanel=LeftPanel.getLeftPanel();
					AdminFrame.leftPanel.removeAll();
					AdminFrame.leftPanel=LeftPanel.getLeftPanel();

				}
			});
		}
		return helpButton;
	}

	/**
	 * 统计报表
	 * @return
	 */
	private JButton getStatButton() {
		
		if (statButton == null) {
			statButton = new JButton(new ImageIcon("image/statistic.jpg"));
			statButton.setToolTipText("统计报表");
			statButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
					temp=false;
					enableButton(statButton);
					AdminFrame.leftPanel=LeftPanel.leftPanel;
					AdminFrame.leftPanel.removeAll();
					
					AdminFrame.leftPanel=LeftPanel.getLeftPanel2();
					AdminFrame.centerPanel.setViewportView(null);
					AdminFrame.leftPanel.updateUI();
					AdminFrame.centerPanel.updateUI();
				}
			});
		}
		return statButton;
	}

	/**
	 * 用户充值
	 * @return
	 */
	private JButton getPayforButton() {
		
		if (payforButton == null) {
			payforButton = new JButton(new ImageIcon("image/pay.jpg"));
			payforButton.setToolTipText("充值");
			payforButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					AddMoneyFrame.frame=frame;
					final AddMoneyFrame addMoney = new AddMoneyFrame();
					ScreenLocation.setLocationMid(addMoney, "用户充值");
					
					addMoney.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e){
							enableButton(null);
							frame.setEnabled(true);
						}
					});
					frame.setEnabled(false);
					enableButton(payforButton);
				}
			});
		}
		return payforButton;
	}
	/**
	 * 查询用户
	 * @return
	 */
	private JButton getFindButton() {
		
		if (findButton == null) {
			findButton = new JButton(new ImageIcon("image/find1.jpg"));
			findButton.setToolTipText("查询用户");
			findButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					FindUserFrame.frame = frame;
					FindUserFrame find = new FindUserFrame();
					find.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e){
							enableButton(null);
							frame.setEnabled(true);
						}
					});
					ScreenLocation.setLocationMid(find, "修改信息");
					frame.setEnabled(false);
					enableButton(findButton);
					
				}
			});
		}
		return findButton;
	}

	/**
	 * 修改用户
	 * @return
	 */
	private JButton getUpdateButton() {
		
		if (updateButton == null) {
			updateButton = new JButton(new ImageIcon("image/update1.jpg"));
			updateButton.setToolTipText("修改用户");
			updateButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					UpdateUserFrame.frame = frame;
					UpdateUserFrame update = new UpdateUserFrame();
					update.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e){
							enableButton(null);
							frame.setEnabled(true);
						}
					});
					ScreenLocation.setLocationMid(update, "修改信息");
					
					frame.setEnabled(false);
					enableButton(updateButton);
					
				}
			});
		}
		return updateButton;
	}

	/**
	 * 删除用户
	 * @return
	 */
	private JButton getDeleteButton() {
		
		if (deleteButton == null) {
			deleteButton = new JButton(new ImageIcon("image/delete.jpg"));
			deleteButton.setToolTipText("删除用户");
			deleteButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					DeleteUserFrame.frame=frame;
					final DeleteUserFrame deleteFrame = new DeleteUserFrame();
					ScreenLocation.setLocationMid(deleteFrame, "删除用户");
					
					deleteFrame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e){
							enableButton(null);
							frame.setEnabled(true);
						}
					});
					
					frame.setEnabled(false);
					enableButton(deleteButton);
				}
			});
		}
		return deleteButton;
	}

	/**
	 * 增加用户
	 * @return
	 */
	private JButton getAddButton() {
		if (addButton == null) {
			addButton = new JButton(new ImageIcon("image/add.jpg"));
			addButton.setToolTipText("增加用户");
			addButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AddUserFrame.frame=frame;
					final AddUserFrame addFrame = new AddUserFrame();
					ScreenLocation.setLocationMid(addFrame, "用户增加");
					
					addFrame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e){
							frame.setEnabled(true);
							enableButton(null);
						}
					});
					frame.setEnabled(false);
					enableButton(addButton);
					
				}
			});
		}
		return addButton;
	}
	
	/**
	 * 主页
	 * @return
	 */
	@SuppressWarnings("static-access")
	private JButton getHomeButton() {
		
		if (homeButton == null) {
			homeButton = new JButton(new ImageIcon("image/home1.jpg"));
			homeButton.setToolTipText("主页");
			//homeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//手装光标
			homeButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					AdminToolsBar.temp=true;
					AdminFrame.centerPanel.setViewportView(new TableData().getJTable());
					AdminFrame.leftPanel=LeftPanel.getLeftPanel();
					AdminFrame.leftPanel.removeAll();
					AdminFrame.leftPanel=LeftPanel.getLeftPanel();
					AdminFrame.centerPanel.updateUI();
					enableButton(homeButton);
				}
			});
		}
		return homeButton;
	}
	
	/**
	 * 工具函数
	 */
	public static void enableButton(JButton button){
		list.add(homeButton);
		list.add(addButton);
		list.add(deleteButton);
		list.add(updateButton);
		list.add(findButton);
		list.add(payforButton);
		list.add(statButton);
		list.add(helpButton);
		list.add(setupButton);
		for(int i=0;i<list.size();i++){
			if(list.get(i) == button){
				list.get(i).setEnabled(false);
			}else{
				list.get(i).setEnabled(true);
			}
		}
	}
}





