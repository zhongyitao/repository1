import com.cumt.dao.UserDao;
import com.cumt.dao.impl.UserDaoImpl;
import com.cumt.domain.User;
import com.cumt.util.MailUtils;
import org.junit.Test;

public class TestDemo {
    @Test
    public void findUserByUsernameTest()
    {
        UserDao dao = new UserDaoImpl();
        User user = dao.findUserByUsername("zhangsan");
        System.out.println(user);

    }

    @Test
    public void mailTest()
    {
        MailUtils.sendMail("jxzhongyitao@126.com","你好，这是一封测试邮件，无需回复。","测试邮件");
        System.out.println("发送成功");
    }


}
