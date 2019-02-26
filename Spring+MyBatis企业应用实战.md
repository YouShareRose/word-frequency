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

### RequestMapping

### RequestParam

### PathVariable

### MatrixVariable

### CrossOrigin

### RequestHeader

### CookieValue

### RequestAttribute

### SessionAttribute

### ModelAttribute

### RequestBody

### ResponseBody

### RestController

### 异常处理

## 标签库

## 国际化

## 文件传输

## 数据库

*XMind: ZEN - Trial Version*