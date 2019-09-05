package com.cumt.service.impl;

import com.cumt.dao.UserDao;
import com.cumt.dao.impl.UserDaoImpl;
import com.cumt.domain.ResultInfo;
import com.cumt.domain.User;
import com.cumt.service.UserService;
import com.cumt.util.MailUtils;
import com.cumt.util.UUIDUtils;

public class UserServiceImpl implements UserService{

    UserDao userDao = new UserDaoImpl();

    /**
     * 用户注册
     *
     * @param user
     * @return 返回注册结果
     */
    @Override
    public ResultInfo register(User user) {
        ResultInfo resultInfo = new ResultInfo();
        //查询用户名是否已存在
        User u = userDao.findUserByUsername(user.getUsername());
        //判断是否已存在
        if (null != u)
        {
            //存在
            resultInfo.setFlag(false);
            resultInfo.setErrorMessage("用户名已存在");
        }
        else
        {
            //不存在，则调用方法存储用户信息
            user.setStatus("N");
            user.setCode(UUIDUtils.getUuid());
            boolean flag = userDao.insertUser(user);
            resultInfo.setFlag(flag);
            if (flag)
            {
                String content="<a href='http://localhost:8080/travel/user/active?code="+user.getCode()+"'>点击激活【黑马旅游网】</a>";
                MailUtils.sendMail(user.getEmail(),content,"激活邮件");
            }
            else
            {
                resultInfo.setErrorMessage("注册失败");
            }
        }



        return resultInfo;
    }

    /**
     * 激活
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {

        User user = userDao.findUserByCode(code);
        if (null != user)
        {
            boolean flag = userDao.updateStatus(user);
            return flag;
        }
        else
        {
            return false;
        }
    }

    @Override
    public User login(User user) {
        User u = userDao.findUserByUsernameAndPassword(user);

        return u;


    }
}
