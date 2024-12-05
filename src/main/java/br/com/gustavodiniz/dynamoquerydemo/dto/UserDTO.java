package br.com.gustavodiniz.dynamoquerydemo.dto;

import br.com.gustavodiniz.dynamoquerydemo.domain.User;

public class UserDTO {
    private String userId;
    private String userName;
    private String userType;
    private String documentId;

    public UserDTO(String userId, String userName, String userType, String documentId) {
        this.userId = userId;
        this.userName = userName;
        this.userType = userType;
        this.documentId = documentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public static UserDTO valueOf(User user) {
        return new UserDTO(user.getUserId(), user.getUserName(), user.getUserType(), user.getDocumentId());
    }

    public User toUser(UserDTO userDTO) {
        return new User(userDTO.getUserId(), userDTO.getUserName(), userDTO.getUserType(), userDTO.getDocumentId());
    }
}
