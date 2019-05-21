import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;

import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

public class FreemarkDemo {
    public static void main(String[] args) throws Exception {
//        要点:数据+模板==生成新的 模板实例对象
//        1. 在greemarker/template/Configuration类中 这里中还预定义了 自己需要的 Version 对象 的静态值
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
//        2.配置模板对象存放路径 到 fremarkDemo对象:最后两个 \\ 要加上
        String inputUrl = "D:\\Java_Code\\FreemarkerDemo\\src\\main\\java\\ftl\\";
        configuration.setDirectoryForTemplateLoading(new File(inputUrl));
//        3.加载 一个模板对象 到 fremarkDemo对象上
        Template template = configuration.getTemplate("freemarkerDemo.ftl");
//        4.为模板中变量配置 值
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("ftl_key1","你好~");
        hashMap.put("ftl_key2","加油啊~");
//        -------------FTL指令测试-----------------
//        1.传递简单变量到前台
        hashMap.put("str","我是小龙");
//        4.if指令 传递是否成功变脸
        hashMap.put("success",false);
        hashMap.put("flag",true);
//        5.遍历list
        List goodsList=new ArrayList();
        Map goods1=new HashMap();
        goods1.put("name", "苹果");
        goods1.put("price", 5.8);
        Map goods2=new HashMap();
        goods2.put("name", "香蕉");
        goods2.put("price", 2.5);
        Map goods3=new HashMap();
        goods3.put("name", "橘子");
        goods3.put("price", 3.2);
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        hashMap.put("goodsList", goodsList);
//      8.日期格式化
        hashMap.put("today",new Date());
//      9.数字字符串转换
        hashMap.put("point",12412341234L);
//


//        ----------------------------------------
//        5.配置模板实例输出 Writer对象,输出到某路径下
        String outUrl = "D:\\Java_Code\\FreemarkerDemo\\src\\main\\java\\out\\";
//        需要指定 输出文件名称
        Writer out = new FileWriter(new File(outUrl + "out_1.html"));
//        6.使用进过FreemarkDemo处理过的模板输出变量, 需要
        template.process(hashMap,out);
//        7.关流
        out.close();
//        8.通知输出完成
        System.out.println("输出完成");

    }
}
