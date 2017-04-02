package net.vibro.app.validator;

import net.vibro.app.model.User;
import net.vibro.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by ${Mirek} on 02.04.2017.
 */
@Component
public class UserValidator implements Validator{
    @Autowired
    private UserService userService;
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user =(User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username" , "Requierd");
        if (user.getUsername().length()< 8 || user.getUsername().length()>32){
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername())!=null){
            errors.rejectValue("username" , "Duplicate.userForm.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password" , "Required");
        if (user.getPassword().length()<8 || user.getPassword().length()>32){
            errors.rejectValue("password", "Size.userForm.password");
        }
        if (!user.getConfirmPassword().equals(user.getPassword())){
            errors.rejectValue("confirmePassword", "Different.userForm.password" );
        }

    }
}
