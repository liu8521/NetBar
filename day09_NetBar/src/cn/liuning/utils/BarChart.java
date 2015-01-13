package cn.liuning.utils;
import java.awt.BasicStroke;
import java.awt.Font;
import java.math.BigDecimal;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
 
/**
 * 绘图类
 * @author liuning
 *
 */
public class BarChart {
   
	
	/**
	 * 根据接收的数据 化条形图
	 * 
	 * 用的第三方jar包
	 */
	
	ChartPanel panel;
    static List<BigDecimal> list;
    static String title="";
    
    /**
     * 无参的构造函数
     */
    public  BarChart(){
    	
    }
    
    /**
     * 构造函数初始化
     * @param list
     * @param title
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public  BarChart(List list,String title){
    	BarChart.title=title;
    	BarChart.list=list;
        CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
        					title, // 图表标题
                            "分类", // 目录轴的显示标签
                            "数量", // 数值轴的显示标签
                            dataset, // 数据集
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                            true,           // 是否显示图例(对于简单的柱状图必须是false)
                            false,          // 是否生成工具
                            false           // 是否生成URL链接
                            );
        BarRenderer renderer = new BarRenderer(); 
        renderer.setItemLabelAnchorOffset(10d);
        renderer  
        .setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());  
        renderer.setBaseItemLabelsVisible(true); 
       
        //从这里开始
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        plot.setRenderer(renderer);  
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
        domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
        ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
        rangeAxis.setAxisLineStroke(new BasicStroke(1.6f));
        //解决汉字乱码问题
        panel=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame
          
    }
    private static CategoryDataset getDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       
        for(int i=1;i<=12;i++){
        	 dataset.addValue(list.get(i-1),"",String.valueOf(i));
        }
        return dataset;
    }
    
    /**
     * 获取图标显示面板
     * @return
     */
    public ChartPanel getChartPanel(){
    	return panel;
     
    }
}