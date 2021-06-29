package service;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IPshow<K,V> extends JFrame {
    String textTitle;
    JFreeChart chart;
    String xName;
    String yName;
    Map<K,V> IPs;
    public IPshow(String pictureTitle, String textTitle, String xName, String yName, List<K> x,List<V> y){
        super(pictureTitle);
        this.textTitle = textTitle;
        this.xName = xName;
        this.yName = yName;
        this.IPs = new HashMap<K,V>();
        for (int i = 0; i < x.size(); i++) {
            IPs.put(x.get(i),y.get(i));
        }
        this.setContentPane(createPanel()); //构造函数中自动创建Java的panel面板
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    public IPshow(String pictureTitle,String textTitle,String xName,String yName,Map<K,V> IPs) {
        super(pictureTitle);
        this.IPs = IPs;
        this.textTitle = textTitle;
        this.xName = xName;
        this.yName = yName;
        this.setContentPane(createPanel()); //构造函数中自动创建Java的panel面板
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        0=DO_NOTHING_ON_CLOSE 不做任何反应。
//        1=HIDE_ON_CLOSE  仅仅隐藏。
//        2=DISPOSE_ON_CLOSE .关闭窗口。
//        3=EXIT_ON_CLOSE 关闭窗口，并结束所有线程。
    }
    //转载数据
    public CategoryDataset createDataset() //创建柱状图数据集
    {
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        IPs.forEach((k,v)->{
            dataset.addValue((int)v,"Out",k.toString());
        });

        return dataset;
    }
    //创建图表
    public JFreeChart createChart(CategoryDataset dataset) //用数据集创建一个图表
    {
        chart= ChartFactory.createBarChart(textTitle, xName,
                yName, dataset, PlotOrientation.VERTICAL, true, true, false); //创建一个JFreeChart
        chart.setTitle(new TextTitle(textTitle,new Font("宋体",Font.BOLD+Font.ITALIC,20)));//可以重新设置标题
        CategoryPlot plot=(CategoryPlot) (chart).getPlot();//获得图标中间部分，即plot
        CategoryAxis categoryAxis=plot.getDomainAxis();//获得横坐标
        categoryAxis.setLabelFont(new Font("宋体",Font.BOLD+Font.ITALIC,12));//设置横坐标字体
        return chart;
    }
    //创建图标
    public JPanel createPanel()
    {
        JFreeChart chart =createChart(createDataset());
        return new ChartPanel(chart); //将chart对象放入Panel面板中去，ChartPanel类已继承Jpanel
    }
    //显示图表
    public void showTable(){
        //System.out.println("2222222222222222222222222222222222222222222222222222222222222222222222222222");
        //pack();
        setVisible(true);
    }

}
