package service;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import static service.dataProperties.GetAllProperties;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("处理Get()请求...");
        String name = req.getParameter("name");
        String ip = req.getParameter("ip_time");
        String number = req.getParameter("number");
        String mac = req.getParameter("mac_time");
        //String password = req.getParameter("password");
        //使servlet页面中文不会乱码，一定要放在getWriter()方法前面
        resp.setContentType("text/html; charset=utf-8");
        //添加上面这行才会解析html代码，显示Get()请求成功！的加粗模式，否则不会解析html代码，直接显示html标签
        resp.setHeader("Access-Control-Allow-Origin", "*"); //设置允许任何域名跨域访问
        //Map<String,Integer> map = data.map_proto_size;
        //System.out.println(data.map_proto_size.hashCode());
        //data_return d = new data_return();
        Map<String,Object> map = new HashMap<>();
        if(name.equals("proto") ){
            map = GetAllProperties("C:\\Users\\Mloong\\Desktop\\demo\\src\\main\\resources\\data.properties");
        }else if(name.equals("ip")){
            map = GetAllProperties("C:\\Users\\Mloong\\Desktop\\demo\\src\\main\\resources\\data_ip.properties");
        }else if(name.equals("ip_time")){
            map = mysql.executeQuery.selectIp(ip,Integer.valueOf(number));
        }else if(name.equals("mac_time")){
            map = mysql.QueryMac.selectMac(mac);
        }else if(name.equals("mac")){
            map = new HashMap<String,Object>(){
                {
                    put("00:74:9c:7d:fd:ab",1);
                    put("40:b0:76:82:46:26",2);
                    put("01:00:5e:00:00:fb",3);
                    put("ff:ff:ff:ff:ff:ff",4);
                }
            };
        }
        JSONObject jsonObj=new JSONObject(map);
        PrintWriter out = resp.getWriter();
        //out.println(jsonObj);
        out.write(jsonObj.toString());

        //data.currentTime += 1;
        //System.out.println();
        //data.map_proto_size.clear();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("处理Post()请求...");
        //使servlet页面中文不会乱码，一定要放在getWriter()方法前面
        resp.setContentType("text/html; charset=utf-8");
        //添加上面这行才会解析html代码，显示Get()请求成功！的加粗模式，否则不会解析html代码，直接显示html标签
        PrintWriter out = resp.getWriter();
        out.println("<strong>Post()请求成功!</strong><br/>");
    }
}