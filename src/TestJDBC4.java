import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBC4 {
    public static void main(String[] args) throws SQLException {
        //让用户输入修改信息
        Scanner sc  = new Scanner(System.in);
        System.out.println("请输入要修改的学生Id:");
        int id = sc.nextInt();
        System.out.println("请输入要修改的学生姓名：");
        String name = sc.next();
        //创建DataSource对象
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/test_0601?character=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("19990306Zsss");
        //创建连接
        Connection connection = dataSource.getConnection();
        //拼装SQL语句
        String sql = "Update student set name =? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        statement.setInt(2,id);
        //执行SQL
        int ret = statement.executeUpdate();
        if (ret == 1) {
            System.out.println("修改成功");

        }else {
            System.out.println("修改失败");
        }
        statement.close();
        connection.close();
    }
}
