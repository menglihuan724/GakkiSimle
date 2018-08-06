package com.terry.gakkisimle.im.util;


import com.terry.gakkisimle.im.entity.po.Tree;

import java.util.*;

public class MenuTreeUtils {
    public List<Tree> menuCommon;
    public List<Object> list = new ArrayList();

    public  List<Object> menuList(List<Tree> menu){
        this.menuCommon = menu;
        for (Tree x : menu) {
            Map<String,Object> mapArr = new HashMap();
            if(x.getpId()==0){
                mapArr.put("id", x.getId());
                mapArr.put("name", x.getName());
                mapArr.put("pid", x.getpId());
                mapArr.put("childList", menuChild(x.getId()));
                list.add(mapArr);
            }
        }
        return list;
    }

    public List<?> menuChild(Long id){
        List<Object> lists = new ArrayList();
        for(Tree a:menuCommon){
            Map<String,Object> childArray = new HashMap();
            if(a.getpId() == id){
                childArray.put("id", a.getId());
                childArray.put("name", a.getName());
                childArray.put("pid", a.getpId());
                childArray.put("childList", menuChild(a.getId()));
                lists.add(childArray);
            }
        }
        return lists;
    }
}