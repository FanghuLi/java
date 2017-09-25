import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.lifanghu.IDAO.IUserDAO;
import com.lifanghu.model.User;

public class TestUser {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatic-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            // 由于使用了注解，所以在主配置文件没有mapper，需要在代码里显示注册该mapper接口
            sqlSessionFactory.getConfiguration().addMapper(IUserDAO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        testSelectAll();
        testSelectByConditions();
        testAddUser();
        testDeleteUser();

        testUpateUser();
    }
    public static void testSelectAll() {
        // sqlSessionFactory.getConfiguration().addMapper(IUserDAO.class);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            List<User> users = userDAO.retrieveAllUsers();
            System.out.println("用户编号\t" + "姓名\t" + "年龄\t住址");
            for (User u : users) {
                System.out.println(u.getId() + "\t" + u.getUserName() + "\t"
                        + u.getUserAge() + "\t" + u.getUserAddress());
            }
        } finally {
            session.close();
        }
    }
    public static void testSelectByConditions() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            User u = userDAO.retrieveUserByIdAndName(4, "%dongtian%");
            if (u != null) {
                System.out.println("用户编号\t" + "姓名\t" + "年龄\t住址");
                System.out.println(u.getId() + "\t" + u.getUserName() + "\t"
                        + u.getUserAge() + "\t" + u.getUserAddress());
            }
        } finally {
            session.close();
        }
    }
    public static void testAddUser() {
        User u = new User();
        u.setUserName("dongtian");
        u.setUserAge(51);
        u.setUserAddress("hubeisheng");
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            userDAO.addNewUser(u);
            session.commit();
        } finally {
            session.close();
        }
    }
    public static void testDeleteUser() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            userDAO.deleteUser(7);
            session.commit();
        } finally {
            session.close();
        }
    }

    public static void testUpateUser() {
        User u = new User();
        u.setId(4);
        u.setUserName("dongtian");
        u.setUserAge(51);
        u.setUserAddress("hubeisheng1");
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            userDAO.updateUser(u);
            session.commit();
        } finally {
            session.close();
        }
    }
}