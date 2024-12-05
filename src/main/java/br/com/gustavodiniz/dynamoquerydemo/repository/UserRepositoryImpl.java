package br.com.gustavodiniz.dynamoquerydemo.repository;

import br.com.gustavodiniz.dynamoquerydemo.domain.User;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public UserRepositoryImpl(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Override
    public List<User> findUserByDocumentIdUsingQuery(String documentId) {
        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
        expressionAttributeValues.put(":val", new AttributeValue().withS(documentId));

        DynamoDBQueryExpression<User> query = new DynamoDBQueryExpression<User>()
                .withIndexName("documentId-index")
                .withKeyConditionExpression("document_id = :val")
                .withExpressionAttributeValues(expressionAttributeValues)
                .withConsistentRead(false);

        return dynamoDBMapper.query(User.class, query);
    }

    @Override
    public List<User> findUserByDocumentIdUsingScan(String documentId) {
        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
        expressionAttributeValues.put(":val", new AttributeValue().withS(documentId));

        DynamoDBScanExpression scan = new DynamoDBScanExpression()
                .withFilterExpression("document_id = :val")
                .withExpressionAttributeValues(expressionAttributeValues);

        return dynamoDBMapper.scan(User.class, scan).stream().toList();
    }

    @Override
    public void save(User user) {
        dynamoDBMapper.save(user);
    }
}
