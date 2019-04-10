package com.example.demo.service.serviceImpl;

import com.example.demo.base.em.ErrorMsgEnum;
import com.example.demo.base.pojo.RequestModel;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void login(RequestModel<User> requestModel, User user) throws Exception {
        User oldUser=userDao.selectUserByAccount(user.getAccount());
        if (oldUser==null){
            requestModel.setResultCode(ErrorMsgEnum.NO_ACCOUNT.getCode());
            requestModel.setMessage(ErrorMsgEnum.NO_ACCOUNT.getMsg());

        }else {
            if (oldUser.getState()==1) {
                if (oldUser.getUserPassword().equals(user.getUserPassword())) {
                    requestModel.setResultCode(200);
                    requestModel.setMessage("登陆成功");
                    user.setUserPassword(null);
                    requestModel.setData(user);
                } else {
                    requestModel.setResultCode(ErrorMsgEnum.ERROR_PASS.getCode());
                    requestModel.setMessage(ErrorMsgEnum.ERROR_PASS.getMsg());
                }
            }else {
                    requestModel.setResultCode(ErrorMsgEnum.NO_STATE.getCode());
                    requestModel.setMessage(ErrorMsgEnum.NO_STATE.getMsg());
                  }
            }
        }
    }

