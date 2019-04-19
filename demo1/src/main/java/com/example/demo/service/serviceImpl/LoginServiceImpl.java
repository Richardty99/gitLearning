package com.example.demo.service.serviceImpl;

import com.example.demo.base.em.ErrorMsgEnum;
import com.example.demo.base.exception.BusinessException;
import com.example.demo.base.pojo.RequestModel;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Map;

/**
 * @Auther: HX001
 * @Date: 2019/4/9 14:54
 * @Description:
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;


    @Override
    public RequestModel<User> login(String account, String password) throws SQLException {

        RequestModel<User> requestModel = new RequestModel<User>();
        User oldUser = userDao.selectUserByAccount(account);
        if (oldUser == null) {
            requestModel.setResultCode(ErrorMsgEnum.NO_ACCOUNT.getCode());
            requestModel.setMessage(ErrorMsgEnum.NO_ACCOUNT.getMsg());

        } else {
            if (oldUser.getState() == 1) {
                if (oldUser.getUserPassword().equals(password)) {
                    requestModel.setResultCode(200);
                    requestModel.setMessage("登陆成功");
                    oldUser.setUserPassword(null);
                    requestModel.setData(oldUser);
                } else {
                    throw new BusinessException(ErrorMsgEnum.ERROR_PASS);
                }
            } else {
                throw new BusinessException(ErrorMsgEnum.NO_STATE);

            }
        }
        return requestModel;
    }
}

