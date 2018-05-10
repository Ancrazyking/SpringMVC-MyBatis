package com.ancrazyking.service;

import com.ancrazyking.pojo.Items;


import java.util.List;

/**
 * @author Ancrazyking
 * @date 2018/5/10 14:35
 **/

public interface ItemService
{
    List<Items> selectItemsList();

    Items selectItemsById(Integer id);


    void updateItemsById(Items items);
}
