1.创建SSM项目
创建Maven-Webapp项目
添加依赖 SSM框架依赖  shiro依赖
框架配置
创建JSP页面
创建控制器类
配置运行环境
运行测试

2）创建自定义Realm
	1、创建MyRealm类
	2、创建用户、角色、权限相关的操作类
	3、创建Mapper
	4、在MyRealm中完成用户、角色、权限信息获取
3）添加自定义Realm和securityManager的bean,注入到springIOC容器

4）添加shiroFilter的配置
4）web.xml添加shiro的配置
 