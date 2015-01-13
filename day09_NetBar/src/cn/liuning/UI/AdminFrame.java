package cn.liuning.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import cn.liuning.dao.AdminDao;
import cn.liuning.dao.CurrentRecordDao;
import cn.liuning.dao.impl.AdminDaoImpl;
import cn.liuning.dao.impl.CurrentRecordDaoImpl;
import cn.liuning.javabean.Admin;
import cn.liuning.utils.ScreenLocation;

public class AdminFrame extends JFrame implements Runnable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 工具变量
	 */
	static JScrollPane centerPanel = new JScrollPane();
	static JPanel leftPanel;
	private JPanel jContentPanel = null;
	static Timer timer2;
	static Timer timer;

	/**
	 * 管理员界面           主函数
	 */
	public static void main(String[] args) {
	
		AdminFrame adminFrame = new AdminFrame();
		ScreenLocation.setLocationMid(adminFrame, "管理员界面");
	}
	
	/**
	 * 构造函数初始化
	 */
	public AdminFrame(){

		this.setJMenuBar(new AdminMenuBar().getAdminJMenuBar());
		this.setContentPane(getJContentPanel());
		this.setSize(920,630);
		ImageIcon icon = new ImageIcon("image/coffee.png");
		this.setIconImage(icon.getImage());
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        //启动定时器，完成时间显示，和数据刷新
        timer2 = new Timer(6000,listener2);
        timer2.start();
        timer = new Timer(1000,listener);
        timer.start();
	}
	
	/**
	 * 得到容器面板 
	 * @return
	 */
	@SuppressWarnings("static-access")
	private JPanel getJContentPanel(){
	
		if(jContentPanel == null){
			jContentPanel = new JPanel();
			jContentPanel.setLayout(new BorderLayout(8,7));
			JLabel statusBar=new JLabel("  ");
			jContentPanel.add(statusBar,BorderLayout.SOUTH);
			jContentPanel.add(statusBar,BorderLayout.EAST);
			AdminToolsBar.frame=this;
			AdminMenuBar.frame=this;
			jContentPanel.add(new AdminToolsBar().getAdminToolsBar(),BorderLayout.NORTH);
			jContentPanel.add(new LeftPanel().getLeftPanel(),BorderLayout.WEST);
			jContentPanel.add(getJCenterPanel(),BorderLayout.CENTER);
			
		}
		return jContentPanel;
	}
	
	/**
	 * 得到中间窗体
	 */
	@SuppressWarnings("static-access")
	private JScrollPane getJCenterPanel() {
		
		centerPanel.setViewportView(new TableData().getJTable());
		centerPanel.setSize(new Dimension(600, 470));
		Thread thread = new Thread(this);
		thread.start();
		return centerPanel;
	}
	
	
	/**
	 * 数据库刷新每隔六秒钟刷新。
	 */
	static ActionListener listener2 = new ActionListener() {
        @SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent e) {
        	timer.stop();
        	AdminDao adminDao = new AdminDaoImpl();
        	Admin admin = adminDao.findRate();
        	String rate = admin.getRate();
        	CurrentRecordDao currentRecord = new CurrentRecordDaoImpl();
        	if(rate.equals("1.8")){
        		currentRecord.updateAllUserMoney("0.003");
        		currentRecord.updateDuTime("0.003");
        	}else if(rate.equals("1.2")){
        		currentRecord.updateAllUserMoney("0.002");
        		currentRecord.updateDuTime("0.002");
        	}else if(rate.equals("2.4")){
        		currentRecord.updateAllUserMoney("0.004");
        		currentRecord.updateDuTime("0.004");
        	}else if(rate.equals("3.0")){
        		currentRecord.updateAllUserMoney("0.005");
        		currentRecord.updateDuTime("");
        	}else if(rate.equals("3.6")){
        		currentRecord.updateAllUserMoney("0.006");
        		currentRecord.updateDuTime("0.006");
        	}
        	if(AdminToolsBar.temp == true){
        		if(AdminToolsBar.count%2==0){
            		centerPanel.setViewportView(new TableData().getJTable());
            	}else{
            		centerPanel.setViewportView(new TableData().getJTable2());
            	}
        	}
        	timer.start();
        }
    };
	
	/**
	 * 刷新table
	 */
	static ActionListener listener = new ActionListener() {
		String time = "";
        public void actionPerformed(ActionEvent e) {
           
        	if(LeftPanel.l_timeText==null ||
        			LeftPanel.l_timeText.getText().equals("")||
        			LeftPanel.l_timeText.getText().equals(" ")){
        	}else{
        		time = LeftPanel.l_timeText.getText();
        		String str = setDuTime(time);
        		LeftPanel.l_timeText.setText(str);
        	}
        	for(int j=0;j<26;j++){
    			
    			String aaa = TableData.jTable.getValueAt(j, 2).toString();
    			if(aaa.equals(" ") || aaa.equals("") ||aaa==null){
    				
    			}else{
    				TableData.jTable.setValueAt(setDuTime(aaa), j, 2);
    			}
    		}
        }
    };
    
    /**
     * 工具函数，组装时间
     * @param time
     * @return 
     */
    private static String setDuTime(String time) {
    	String hour = time.split(":")[0];
    	String minute = time.split(":")[1];
    	String second = time.split(":")[2];
    	
    	int z = Integer.parseInt(hour);
    	int y = Integer.parseInt(minute);
    	int x = Integer.parseInt(second);
		x=x+1;
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
	
	
	/**
	 * 时间显示
	 */
	@Override
	public void run() {
		while(true){
		    Date d = new Date();
			@SuppressWarnings("deprecation")
			String str = d.toLocaleString();
			String date = str.split(" ")[0];
			String time = str.split(" ")[1];
			LeftPanel.dateLabel.setText(date);
			LeftPanel.timeLabel.setText(time);
		    try {
		    	Thread.sleep(1000);
		    } catch (InterruptedException e) {
		     e.printStackTrace();  
		    }
		 }
	}	
}




