package com.example.demo.service;

import com.example.demo.dao.ItemDao;
import com.example.demo.documents.ItemDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemSeviceImpl implements ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemSeviceImpl.class);

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<ItemDocument> getItems() {
        logger.info("Inside get items method :: start");
        List<ItemDocument> itemList = itemDao.getItems();
        logger.info("Inside get items method :: end");
        return itemList;
    }

    @Override
    public String addItems(ItemDocument itemDocument) {
        logger.info("Inside addItems method :: start");
        itemDao.addItems(itemDocument);
        logger.info("Inside addItems method :: end");
        return "Item Added";
    }

    @Override
    public String delete(int id) {
        logger.info("Inside deleteItems method :: start");
        ItemDocument itemDocument = itemDao.getItemById(id);
        if(itemDocument == null){
            return "Item not Found";
        }
        itemDao.deleteItem(itemDocument);
        logger.info("Inside deleteItems method :: end");
        return "Item Deleted";
    }

    @Override
    public String update(int id, ItemDocument itemDocument) {
        logger.info("Inside update method :: start");
        ItemDocument document = itemDao.getItemById(id);
        if(document == null){
            return "Item not Found";
        }
        itemDocument.setItemId(id);
        itemDao.updateItem(itemDocument);
        logger.info("Inside update method :: end");
        return "Item Updated";
    }

}
