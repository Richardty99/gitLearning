package com.example.demo.service.serviceImpl;

import com.example.demo.base.pojo.RequestModel;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: HX001
 * @Date: 2019/4/9 08:16
 * @Description:
 */
@Service
public class UserserviceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public void selectUser(RequestModel requestModel) throws Exception {
        PageHelper.startPage(requestModel.getQueryParams().getCurr_page(),requestModel.getQueryParams().getPage_size());
        List<User> list=userDao.selectUser(requestModel.getQueryParams());
        PageInfo pageInfo=new PageInfo(list);
        requestModel.setData(list);
    }
}
