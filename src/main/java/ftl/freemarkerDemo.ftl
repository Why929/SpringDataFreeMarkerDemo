<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>freemarkerDemo_template</title>
</head>
<body>
${ftl_key1}
${ftl_key2}
1.定义简单类型<#assign  linkman=str>从后台去变量出来,后台用Map<key,value>传入值
联系人:${linkman}
2.定义对象类型:
<#assign  info={"mobile":"13301231212",'address':'北京市昌平区王府街'}>
电话:${info.mobile}
地址:${info.address}
3.include指令 用于模板文件的嵌套,嵌入其他ftl文件,后台不用写,前端直接写
<#include "head.ftl">
4.if指令
<#if success>
    你已经通过实名认证了,后台用Map<"success",true>
<#else >
    你没有通过实名认证
</#if>
<#if success>
    你已经通过实名认证了,后台用Map<"success",true>
<#elseif flag>
    你没有通过实名认证,后台用Map<"flag",ture>
</#if>
5.遍历ListMap
<#list goodsList as goods>
    角标:${goods_index}
    商品名称:${goods.name}
    价格:${goods.price}
</#list>
6.内建函数  变量 ?  函数名称
如:共xx条记录  使用.size函数来实现
共${goodsList?size}条记录数
7.JSON字符串转成对象: 页面上显示
<#assign text="{'bank':'工商银行','account':'10101920201920212'}"/>
<#assign  data=text?eval/>
开户行:${data.bank}
账号:${data.account}
8.日期格式化 后台传递Map<"today",new Date()>
当前日期:${today?date}//接收日期需要格式转化 转化成 年月日
当前时间:${today?time}// 转化成时间 时分秒
当前日期+时间:${today?datetime}// 年月日 时分秒
自定义时间日期转化:${today?string("yy年MM月dd日HH时mm分ss秒")}
自定义时间日期转化:${today?string("yyyy年MM月dd日HH时mm分ss秒")}
9.数字字符串转化 去除, 后台Map<"point",12443122>
${point?c}
10.判断某变量是否存在:  ??
aaa等于空么?
<#if aaa??>
    aaa变量存在
<#else>
    aaa变量不存在
</#if>
11.缺失变量默认值:!   !"小白",如果某变量为空,则取默认值 小白
${aaa!"小白"}


</body>
</html>