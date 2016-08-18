数据库属性写在ApplicationContext里面，没有db.properties
ApplicationContext在：src\main\resources下

首先掏出右手放在鼠标上
然后点击进入SpringMybatisExam文件夹
编译：mvn clean compile
运行：mvn exec:java -Dexec.mainClass="com.hand.SpringMybatisExam.App" -Dexec.args="arg0 arg1 arg2"


删除：mvn exec:java -Dexec.mainClass="com.hand.SpringMybatisExam.App2" -Dexec.args="arg0 arg1 arg2"  删除失败时，事务会自动rollback

这里是test分支