package com.ancrazyking.service;

import com.ancrazyking.dao.ItemsMapper;
import com.ancrazyking.pojo.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Ancrazyking
 * @date 2018/5/10 15:48
 **/
@Service
public class ItemServiceImpl implements ItemService
{

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> selectItemsList()
    {
      return itemsMapper.selectByExample(null);
    }

    @Override
    public Items selectItemsById(Integer id)
    {
        return itemsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateItemsById(Items items)
    {
        items.setCreatetime(new Date());
        itemsMapper.updateByPrimaryKey(items);
    }
}
