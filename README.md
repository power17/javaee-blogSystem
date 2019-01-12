# javaee-blogSystem
#博客系统
##一、登录和退出功能
###1、工程搭建
####1.1、 新建项目，
####1.2、 引入jar包
####1.3、配置resource为resource ROOt
####1.4、配置注解：file=>setting=>compiler=>annotation process
###2、静态页面的搭建
####2.1、引入静态文件
####2.2、安装jrebel进行热部署
###3、登陆
####3.1、到数据库查找字段：建立loginAction=>loginService=>UserDao查询数据库=>User
####3.2、如果查询到结果，就跳转成功页，如果失败，则提示错误
####3.2、退出功能的实现
