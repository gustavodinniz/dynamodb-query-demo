package br.com.gustavodiniz.dynamoquerydemo.repository;

import br.com.gustavodiniz.dynamoquerydemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    List<User> findUserByDocumentIdUsingQuery(String documentId);
    List<User> findUserByDocumentIdUsingScan(String documentId);
    void save(User user);
}
