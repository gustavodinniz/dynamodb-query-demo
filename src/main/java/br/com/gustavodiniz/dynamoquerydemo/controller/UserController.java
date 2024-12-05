package br.com.gustavodiniz.dynamoquerydemo.controller;

import br.com.gustavodiniz.dynamoquerydemo.dto.UserDTO;
import br.com.gustavodiniz.dynamoquerydemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
    }

    @GetMapping("/scan/{documentId}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getUserByScan(@PathVariable String documentId) {
        return userService.getUserByScan(documentId);
    }

    @GetMapping("/query/{documentId}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getUserByQuery(@PathVariable String documentId) {
        return userService.getUserByQuery(documentId);
    }
}
