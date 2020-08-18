package com.example.demo.documents.utils;

import com.example.demo.documents.ItemDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<ItemDocument, String> {
}
