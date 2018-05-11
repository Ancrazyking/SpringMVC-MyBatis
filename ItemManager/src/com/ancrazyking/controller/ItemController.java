package com.ancrazyking.controller;

import com.ancrazyking.pojo.Items;
import com.ancrazyking.pojo.QueryVo;
import com.ancrazyking.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 单例模式,100个人来了也就一个类
 *
 * @author Ancrazyking
 * @date 2018/5/10 15:46
 **/
@Controller
public class ItemController
{


    @Autowired
    private ItemService itemService;


    @RequestMapping("/item/itemList.action")
    public ModelAndView itemList()
    {


        List<Items> list = itemService.selectItemsList();
        ModelAndView mav = new ModelAndView();

        mav.addObject("itemList", list);
        mav.setViewName("itemList");
        return mav;

    }


    /**
     * 参数的绑定,默认参数绑定
     *
     * @return
     * @RequestParam("id"),将参数绑定到形参上,如果为空则报错
     */
    //去修改页面入参,绑定参数之基本类型
    @RequestMapping("item/itemEdit.action")
    public ModelAndView itemEdit(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id, HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model)
    {

/*
       String id= request.getParameter("id");
*/
        //绑定类型
        Items items = itemService.selectItemsById(id);

        ModelAndView mav = new ModelAndView();
        mav.addObject("item", items);
        mav.setViewName("itemEdit");
        return mav;

    }


    //绑定参数之pojo
/*    @RequestMapping("/itemUpdate.action")
    public ModelAndView itemUpdate(Items items){

        itemService.updateItemsById(items);
        ModelAndView mav=new ModelAndView();
        mav.setViewName("success");
        return mav;
    }*/


    //绑定参数之包装类
    @RequestMapping("/itemUpdate.action")
    public ModelAndView itemUpdate(QueryVo vo)
    {

        itemService.updateItemsById(vo.getItems());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        return mav;
    }


    //删除多个,数组参数绑定,ids对应jsp页面的form表单的name属性
    //也可以用QueryVo包装类,不过该类必须含有Integer[] ids字段
    @RequestMapping("/itemsDelete")
    public ModelAndView itemsDelete(Integer[] ids)
    {


        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        return mav;


    }


    @RequestMapping(value = "/json.action")
    public @ResponseBody Items json(@RequestBody Items items){
        System.out.println(items);
        return items;
    }
}
