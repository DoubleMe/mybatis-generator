# mybatis-generator
#### 改造自 mybatis-generator 
改动如下：<br> 
* 修改了生成的字段和表名没有注释问题<br> 
* 修改了mapper 的方法。目前保留方法 insert、getById、update、list、delById<br> 
* 修改DTD 简化了配置<br> 
* 修改了java -jar启动参数 目前支持-configfile(配置文件路径) -project（工程路径）<br> 

#### 使用方法：
下载jar 或者下载工程代码打包<br> 
将jar,DTD文件，配置文件信息放到d盘 data目录下<br> 

//gradle 工程mybaits生成<br> 
```java
task mybatisGenerator(){<br> 
    //jar 路径<br> 
    def jarFile = "D:\\data\\mybatis-generator-1.0.0.jar"<br> 
    //配置文件路径<br> 
    def configFile = "D:\\data\\config.xml"<br> 
    //工程路径<br> 
    def projectPath = rootDir.getAbsolutePath()<br> 
    def cmd = "java -jar " + jarFile + " -configfile " + configFile + " -project " + projectPath<br> 
    println cmd<br> 
    Process p = cmd.execute()<br> 
    println "${p.text}"<br> 
}<br> 
```

执行mybatisGenerator<br> 

cmd 执行同上<br> 
