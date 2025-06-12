package com.mani.example.bookmyshowjun25.services;

import com.mani.example.bookmyshowjun25.dtos.ResponseStatus;
import com.mani.example.bookmyshowjun25.exceptions.PasswordNotMatchException;
import com.mani.example.bookmyshowjun25.models.User;
import com.mani.example.bookmyshowjun25.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public User signUp(String name, String email, String password){
        Optional<User> optionalUser = userRepository.findByEMail(email);
        if(optionalUser.isPresent()){
            /*
                    user with the given email is already present
                    navigate then to login page
             */
        }
        User user = new User();
        user.setName(name);
        user.seteMail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password)); // should not store password as it is  Encoding / decoding
        // like B-CryptPasswordEncoder
        return userRepository.save(user);
    }
    public ResponseStatus logIn(String eMail,String password) throws PasswordNotMatchException {
        Optional<User> optionalUser = userRepository.findByEMail(eMail);
        if(optionalUser.isEmpty()){
            //Ask user to  SignUp first
        }
        User user = optionalUser.get();
        if(bCryptPasswordEncoder.matches(password,user.getPassword())){
            return ResponseStatus.SUCCESS;
        }
        else{
            throw new PasswordNotMatchException("Incorrect Password");
        }
    }
}
