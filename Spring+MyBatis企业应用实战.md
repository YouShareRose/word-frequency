# Spring+MyBatis企业应用实战

## JAVA EE

### Java EE 应用概述

- 分层模型

	- Domain Object 由一系列的POJO组成，是该系统的领域对象，往往包含了各自所需实现的业务逻辑方法
	- DAO (Data Access Object) 数据对象访问层 实现对数据库的创建、查询、更新和删除（CRUD）等原子操作

	  DAO层在 MyBatis 中也被称为 Mapper 层，通过 SQL 语句映射完成CRUD操作

	- Service 业务逻辑层 可能仅仅用于暴露 Domain Object 对象所实现的业务逻辑方法，也可能是依赖 DAO组建实现的业务逻辑方法
	- Controller 控制器层 拦截用户请求，调用业务逻辑组件的业务逻辑方法，处理用户请求，并根据处理结果向不同的表现层组件转发
	- View 表现层 由JSP、Velocity、PDF组成，负责收集用户请求，并显示处理结果

- 组件

	- 表现层组件

		- 收集用户数据 显示系统状态
		- 常用技术：JSP \ Velocity \ FreeMarker \ Tapestry

	- 控制器组件

		- MVC框架，提供一个前端核心控制器，核心控制器负责拦截用户请求，转发给控制器组件。控制器组件负责调用业务逻辑方法，处理用户请求。

	- 业务逻辑组件

		- 通常，一个业务逻辑方法对应一次用户操作。
		- 一个业务逻辑方法应该是个整体，要有事务性
		- 仅负责实现业务逻辑，不应进行数据库访问

	- DAO组件

		- 提供Domain Object 对象的增删改查，对应于数据库的CRUD
		- 如果采用不同的持久层访问技术，DAO组件的实现会完全不同，为了解耦，业务逻辑组件面向DAO接口编程

- 应用组件结构和优势

	- 各组件松耦合，使用接口

### 轻量级Java EE 应用相关技术

- JSP、Servlet、JavaBean
- MyBatis3及 Hibernate
- Spring5

	- 单例模式、工厂、抽象工厂、命令、职责链、代理

## Spring MVC

### MVC思想概述

- 传统Model1 和 Model2
- MVC思想及其优势

### Struts2 和Spring MVC

### 开发第一个SpringMVC 应用

### DispatcherServlet

### MVC 执行流程

## 常用注解

### Conroller

- 用于标记一个类为控制器类
- 使Spring能找到控制器

	- 在配置文件的头文件中引入spring-context
	- 使用<context:component-scan/>元素

		- 功能：启动包扫描的功能，以便注册带有@Controller\@Service\@Compoment等注解的类成为Spring的Bean
		- 配置：<sontext:component-scan base-package="your.controller.package"/>

	- <mvc:annotation-driven/>

		- 应用默认配置方案，自动注册RequestMappingHandlerMapping 和 RequestMappingHandlerAdapter 两个Bean、提供数据绑定支持、@Valid支持等功能

	- <mvc:default-servlet-handler/>

		- 静态资源处理器，在Spring MVC 上下文中定义一个DefaultServletHttpPequestHandler,对进入DispatcherServlet 的URL 进行筛查，如果是静态资源的请求，交由Web 应用服务器默认的Servlet 处理

### RequestMapping

- 可用于类或方法
- 属性

	- value Strng[] 用于将指定请求的实际地址映射到方法上
	- name String 给映射地址一个别名
	- method RequestMethod[] 指定请求的方法类型，包括 GET\POST\HEAD\OPTIONS\PUT\PATCH\DELETE\TRACE
	- consumes String[] 指定处理请求提交内容类型（Content-Type），如application/json 、 text\html等，例如 consumes="application/json"
	- produces String[] 指定返回的内容类型，返回的内容类型必须是request请求头（Accept）中所包含的类型
	- params String[] 指定request中必须包含某些参数时，才让该方法处理，例如 params="myParam=myValue"
	- headers String[] 指定request中必须包含某些指定的header值时，才让该方法处理请求，例如 headers="Referer=http://some.org"

- 可出现的参数类型

	- HttpServletRequest
	- HttpSession
	- Model
	- WebRequest

		- 重点方法：getParameter、getHeader、setAttribute、getAttribute、框架无侵入

- 可返回的类型

	- ModelAmdView
	- Map
	- String
	- HttpEntity

- 页面转发

	- 转发到JSP页面

		- 默认使用服务器内部跳转（foeward） return "main"
		- 客户端重定向 return "redirect:/main.jsp" 相当于在浏览器重新发送请求，所以不能访问WEB-INF 下的资源文件，而且也必须写资源文件后缀名，因为此时spring-config.xml文件的视图解析器设置的前缀和后缀都将无效

	- 转发到控制器的请求处理方法

		- 服务器内部跳转到名为main 的请求处理方法 return “forward:/main”
		- 客户端重定向到名为main 的请求处理方法 return “redirect:/main”

### RequestParam

- 用于将指定的请求参数赋值给方法中的形参
- 属性

	- name String 请求参数绑定的名称
	- value String name属性的别名
	- required boolean 是否必须绑定，默认为true
	- defaultValue String 如果没有传递参数而使用的默认值

- 示例：@RequestParam(value="name",defaultValue="yourNmae") String name

### PathVariable

- 获得请求URL中的动态参数
- 属性

	- name String 指定请求参数绑定的名称，如果省略则绑定同名参数
	- value String name的别名
	- required boolean 指示参数是否必须绑定

- 示例：@RequestMapping(value="/path/variable/{userId}/")  public void method(@PathVariable Integer userId)

### MatrixVariable

- 拓展URL请求地址的功能，多个变量可以使用“:”(分号)分隔，可以进行条件组合查询
- 在Spring MVC中默认不启用，开启方法 <mvc:annotation-driven enable-matrix-variables="true"/>

### CrossOrigin

- 处理跨域请求

### RequestHeader

- 将请求的头信息数据映射到功能处理方法的参数上

### CookieValue

### RequestAttribute

- 访问由请求处理方法、过滤器或拦截器创建的、预先存在于request 作用域中的属性，将该属性转换到目标方法的参数

### SessionAttribute

- 访问由请求处理方法、过滤器或拦截器创建的、预先存在于session 作用域中的属性，将该属性转换到目标方法的参数

### SessionAttributes

- 可以有选择地指定Model中的哪些属性转存到 HttpSession 对象中

### ModelAttribute

- 将请求参数绑定到对象，被@ModelAttribute 注释的方法会在Controller每个执行方法前被执行

### RequestBody

- 常用来处理Content-Type 为 application/json  application/xml 不能处理 multipart/form-data 格式 

### ResponseBody

### RestController

### 异常处理

## 标签库

## 国际化

## 文件传输

## 数据库

*XMind: ZEN - Trial Version*