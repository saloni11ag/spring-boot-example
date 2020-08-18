package com.example.demo.service;

import com.example.demo.documents.CustomSequences;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class SequenceServiceImpl implements SequenceService {

    @Autowired
    private MongoOperations mongo;
    @Override
    public int getNextSequence(String seqName) {
        CustomSequences counter = mongo.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("seq",1),
                options().returnNew(true).upsert(true),
                CustomSequences.class);
        return counter.getSeq();
    }
}
