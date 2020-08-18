package com.example.demo.controller;

import com.example.demo.documents.ItemDocument;
import com.example.demo.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    @GetMapping("/getAll")
    public List<ItemDocument> getItems() {
        logger.info("Inside getAll method :: start");

        List<ItemDocument> items = itemService.getItems();

        logger.info("Inside getAll method :: end");
        return items;
    }

    @PostMapping("/addItems")
    public String addItems(@RequestBody ItemDocument itemDocument) {
        logger.info("Inside addItems method :: start");

        String response = itemService.addItems(itemDocument);

        logger.info("Inside addItems method :: end");

        return response;
    }

    @DeleteMapping("/item")
    public String deleteItem(@QueryParam("id") int id) {
        logger.info("Inside deleteItem method :: start");
        String response = itemService.delete(id);
        logger.info("Inside deleteItem method :: start");
        return response;
    }

    @PutMapping("/item")
    public String updateItem(@QueryParam("id") int id, @RequestBody ItemDocument itemDocument) {
        logger.info("Inside updateItem method :: start");
        String response = itemService.update(id,itemDocument);
        logger.info("Inside updateItem method :: start");
        return response;
    }

}
