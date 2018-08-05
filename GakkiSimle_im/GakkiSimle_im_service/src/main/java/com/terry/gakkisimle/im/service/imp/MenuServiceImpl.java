package com.terry.gakkisimle.im.service.imp;

import com.terry.gakkisimle.im.dao.MenuDao;
import com.terry.gakkisimle.im.entity.po.Tree;
import com.terry.gakkisimle.im.service.MenuService;
import com.terry.gakkisimle.im.util.MenuTreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<Object> getMenus() {
        List<Tree> trees= (List<Tree>) menuDao.findAll();
        MenuTreeUtils menuTreeUtils=new MenuTreeUtils();
        return menuTreeUtils.menuList(trees);
    }
}