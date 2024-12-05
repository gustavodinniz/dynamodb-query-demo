package br.com.gustavodiniz.dynamoquerydemo.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Users")
public class User {

    @DynamoDBHashKey
    @DynamoDBAttribute(attributeName = "user_id")
    private String userId;

    @DynamoDBAttribute(attributeName = "user_name")
    private String userName;

    @DynamoDBAttribute(attributeName = "user_type")
    private String userType;

    @DynamoDBAttribute(attributeName = "document_id")
    private String documentId;

    public User() {
    }

    public User(String userId, String userName, String userType, String documentId) {
        this.userId = userId;
        this.userName = userName;
        this.userType = userType;
        this.documentId = documentId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserType() {
        return userType;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
}
