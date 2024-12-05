package br.com.gustavodiniz.dynamoquerydemo.service;

import br.com.gustavodiniz.dynamoquerydemo.dto.UserDTO;
import br.com.gustavodiniz.dynamoquerydemo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    private UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getUserByScan(String documentId) {
        return userRepository.findUserByDocumentIdUsingScan(documentId)
                .stream()
                .map(UserDTO::valueOf)
                .toList();
    }

    public List<UserDTO> getUserByQuery(String documentId) {
        return userRepository.findUserByDocumentIdUsingQuery(documentId)
                .stream()
                .map(UserDTO::valueOf)
                .toList();
    }

    public void createUser(UserDTO userDTO) {
        userRepository.save(userDTO.toUser(userDTO));
    }
}
