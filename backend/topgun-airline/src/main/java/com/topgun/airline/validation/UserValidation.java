package com.topgun.airline.validation;

import com.topgun.airline.domain.user.UserDTO;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserValidation {

    public void userValidation(UserDTO data){
        if(data.email().equals(data.password())){
            throw new IllegalArgumentException("Password cannot be the same as email");
        }
        if(!containsNumeral(data.password())){
            throw new IllegalArgumentException("Password must contain numerals and letters");
        }
    }

    public static boolean containsNumeral(String input) {
        Pattern pattern = Pattern.compile(".*[a-zA-Z].*[0-9].*");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
