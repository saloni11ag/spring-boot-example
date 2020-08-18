package com.example.demo.service;

import com.example.demo.documents.ItemDocument;

import java.util.List;

public interface ItemService {
    List<ItemDocument> getItems();

    String addItems(ItemDocument itemDocument);

    String delete(int id);

    String update(int id, ItemDocument itemDocument);
}
