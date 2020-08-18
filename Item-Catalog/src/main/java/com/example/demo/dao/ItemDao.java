package com.example.demo.dao;

import com.example.demo.documents.ItemDocument;
import com.example.demo.documents.utils.ItemRepository;
import com.example.demo.service.SequenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ItemDao {

    private static final Logger logger = LoggerFactory.getLogger(ItemDao.class);

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private SequenceService nextSequenceService;

    public List<ItemDocument> getItems() {
        logger.info("Inside get items method :: start");
        List<ItemDocument> documentList = itemRepository.findAll();
        logger.info("Inside get items method :: end");
        return documentList;
    }

    public void addItems(ItemDocument itemDocument) {
        logger.info("Inside get items method :: start");
        itemDocument.setItemId(nextSequenceService.getNextSequence("customSequences"));
        itemRepository.save(itemDocument);
        logger.info("Inside get items method :: end");
    }

    public ItemDocument getItemById(int id) {
        logger.info("Inside get item by id method :: start");
        List<ItemDocument> documentList = itemRepository.findAll();
        ItemDocument doc =null;
        for(int i=0;i<documentList.size();i++) {
            if (documentList.get(i).getItemId() == id) {
                doc = documentList.get(i);
            }
        }
        logger.info("Inside get item by id method :: end");
        return doc;
    }

    public void deleteItem(ItemDocument itemDocument) {
        logger.info("Inside delete item method :: start");
        itemRepository.delete(itemDocument);
        logger.info("Inside delete item method :: end");
    }

    public void updateItem(ItemDocument itemDocument) {
        logger.info("Inside updateItem method :: start");
        itemRepository.save(itemDocument);
        logger.info("Inside updateItem method :: end");
    }
}
