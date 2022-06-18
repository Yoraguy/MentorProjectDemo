# 数据库大型实验
 - 考虑Springboot,Mybatis,JSP实现与后端功能交互
# 页面逻辑
 - 主页
 - 登录页
 - 学生个人主页
  1. 填写和修改学生个人信息
  2. 学生志愿填写（提交表单，通过按钮可以保存）
  3. 双选结果获取（时间截止后展示）
  4. 私信查看与发送（保存数据到开发工具表单或数据库）
 - 导师个人主页
  1. 填写和修改导师个人信息 
  2. 导师选择学生志愿（同上）
  3. 双选结果获取（同上）
  4. 私信查看与发送（同上）
 - 导师信息表（允许游客身份查看）
 # 项目运行
  - 配置maven的输出
   1. 点击文件->设置->搜索maven，然后配置maven主路径、用户设置文件、本地仓库，需要先下载apache-maven，我使用的是3.8.4版本。可参考我的设置：
   2. maven主路径：E:/.../apache-maven-3.8.4
   3. 用户设置文件：E:/.../apache-maven-3.8.4/conf/settings.xml
   4. 本地仓库：E:/.../apache-maven-3.8.4/maven-repo
  - 找到HelloApplication.java 运行其中的主函数
  - 浏览器中访问localhost:8080/hellomentor/hello可以看见Hello World提示
