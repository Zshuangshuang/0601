import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBC {
public static void main(String[] args) throws SQLException {
//1、创建DataSource对象(DataSource对象会伴随整个程序的生命周期)
DataSource dataSource = new MysqlDataSource();
//配置URL,User,Password，需要向下转型实现
((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/test_0601?character=utf-8&useSSL=true");
((MysqlDataSource)dataSource).setUser("root");
((MysqlDataSource)dataSource).setPassword("19990306Zsss");//要和电脑装的MySQL密码一致
//2、基于DataSource对象，创建Connection对象，和数据库建立链接
//建立连接也就是确认是否准备就绪，执行相应的数据库增删查改操作
Connection connection = dataSource.getConnection();

//3、PrepareStatement对象拼接具体的SQL语句
//  插入操作(动态输入)
Scanner sc = new Scanner(System.in);
System.out.println("请输入学生Id:");
int id = sc.nextInt();
System.out.println("请输入学生姓名:");
String name = sc.next();
System.out.println("请输入学生班级号:");
int class_id = sc.nextInt();
//此处的?是占位符
String sql = "insert into student values(?,?,?)";
//获取statement对象
PreparedStatement statement = connection.prepareStatement(sql);
//把具体的值替换给?此处的1，2，3相当于?的下标
statement.setInt(1,id);
statement.setString(2,name);
statement.setInt(3,class_id);
    System.out.println("statement:"+statement);
//4、执行SQL语句；
//insert,delete,update都用executeUpdate方法执行
//select用executeQuery来执行
//此时的返回值ret表示修改的行数
int ret = statement.executeUpdate();
System.out.println("ret:"+ret);

//6、关闭释放资源
//先创建的后关闭释放，后创建的先关闭释放
statement.close();
connection.close();
}
}
