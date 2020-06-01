import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC2 {
    public static void main(String[] args) throws SQLException {
        //创建DataSource对象
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/test_0601?character=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("19990306Zsss");

        //创建Connection对象
        Connection connection = dataSource.getConnection();
        String sql = "select * from student";

        //借助PrepareStatement拼装SQL语句
        PreparedStatement statement = connection.prepareStatement(sql);
        //执行SQL语句
        ResultSet resultSet = statement.executeQuery();
        //遍历结果集类似于迭代器遍历集合类
        while (resultSet.next()){
            //表示resultSet只想当前行，可获取对应列数据
            //可根据列名获取
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int class_id = resultSet.getInt("class_id");
            System.out.println("学生Id:"+id+" "+"学生姓名："+name+" "+"学生班级号："+class_id);

        }

        //关闭释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
