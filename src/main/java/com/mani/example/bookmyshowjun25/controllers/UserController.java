package com.mani.example.bookmyshowjun25.controllers;

import com.mani.example.bookmyshowjun25.dtos.LoginRequestDto;
import com.mani.example.bookmyshowjun25.dtos.ResponseStatus;
import com.mani.example.bookmyshowjun25.dtos.UserSignUpRequestDto;
import com.mani.example.bookmyshowjun25.dtos.UserSignUpResponseDto;
import com.mani.example.bookmyshowjun25.exceptions.PasswordNotMatchException;
import com.mani.example.bookmyshowjun25.models.User;
import com.mani.example.bookmyshowjun25.repositories.UserRepository;
import com.mani.example.bookmyshowjun25.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private UserService userService;
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @PostMapping("/signup")
    public UserSignUpResponseDto signUp(@RequestBody UserSignUpRequestDto requestDto){
        User user = userService.signUp(requestDto.getName(),
                requestDto.geteMail(),requestDto.getPassword());
        UserSignUpResponseDto responseDto = new UserSignUpResponseDto();
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        responseDto.setName(user.getName());
        responseDto.setEmail(user.geteMail());
        return responseDto;
    }
    @GetMapping("/login")
    public ResponseStatus logIn(@RequestBody LoginRequestDto requestDto) throws PasswordNotMatchException {
        return userService.logIn(requestDto.geteMail(),requestDto.getPassword());
    }
}
