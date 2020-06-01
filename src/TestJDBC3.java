import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBC3 {
    public static void main(String[] args) throws SQLException {
        //创建DataSource对象
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/test_0601?character=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("19990306Zsss");
        //Connection创建连接
        Connection connection = dataSource.getConnection();
        //拼装SQL
        System.out.println("请输入你要删除学生的姓名：");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        String sql = "delete from student where name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        //执行SQL
        int ret = statement.executeUpdate();
        if (ret == 1) {
            System.out.println("删除成功！");
        }else {
            System.out.println("删除失败");
        }
        statement.close();
        connection.close();
    }
}
