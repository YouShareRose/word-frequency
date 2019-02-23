# word-frequency
对英文文章进行词频统计分析

---
* 搭建基本的mvc应用
先下载了[Spring](https://repo.spring.io/libs-release-local/org/springframework/spring/5.0.1.RELEASE/ "5.0.1.RELEASE")的所有库到本地，搭了个最基本的web项目。
在IDEA 上添加库的时候可以直接选择/WEB-INF/lib 目录，右击，选择**Add as Library..**

* 使用@Controller注解,遇到错误 "通配符的匹配很全面, 但无法找到元素 'mvc:annotation-driven' 的声明"
解决办法：
spring-config.xml中，要添加 http://www.springframework.org/schema/mvc 和
http://www.springframework.org/schema/mvc/spring-mvc.xsd