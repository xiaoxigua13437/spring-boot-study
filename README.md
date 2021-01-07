# spring-boot


 **此项目供本人学习使用：**
 
   #### 1.项目说明
         
         本项目主要快速搭建spring-boot项目（从https://github.com/roncoo/spring-boot-demo 上学习）
    ，包含了spring-boot内部集成：
       (1)ehcache 缓存;
       (2)jms消息中间件;
       (3)邮件发送;
       (4)redis缓存;
       (5)jpa 实现 mysql,mongodb衔接;
       (6)过滤器，监听器，servlet;
       (7)程序性能监控(actuator);
       (8)spring security 权限管理
       (9) mybatis持久层框架
       (10)Swagger 文档 
             
     仅点到知识点，具体使用还需要逐个深入学习    
        
   #### 2.安装依赖
       
       本地需要安装jdk、maven等 基础工具
       
   #### 3.文件说明
       
       pom.xml  项目maven依赖包。
       .gitignore  git不提交文件
   
   #### 4.目录说明 
   
        database为数据库脚本文件；
   
        以下为/src/main/java/com/fzy/learn目录下的目录结构
   
   _目录结构：_ 
     
      ├──bean               //实体
      │  
      ├──cache              //ehcache 缓存
      │
      ├──component          //三方件,目前包含：jms消息中间件，邮件发送，redis缓存
      │
      ├──controller         //controller控制层：
      │
      ├── dao               // dao层，主要有 jpa 实现 mysql,mongodb衔接
      │
      ├──handler            // controller异常处理
      │
      ├──service            //service层
      │
      ├──util               //工具类
      │    ├──base    
      │    ├──configuration //配置
      │    ├──filter        //过滤器
      │    ├──listerner     //监听器
      │    └──servlet       //自定义servlet ,一般我们使用springmvc的dispatcherservlet
      │
      │──Application        //项目启动类
      
   
   "# spring-boot-study" 
