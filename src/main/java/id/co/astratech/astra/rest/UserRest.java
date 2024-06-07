package id.co.astratech.astra.rest;

import id.co.astratech.astra.model.User;
import id.co.astratech.astra.response.DtoResponse;
import id.co.astratech.astra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRest {

    @Autowired
    private UserService userService;

    public UserRest (UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getUserByEmailAndPassword")
    public DtoResponse getSkemas(@RequestParam("email") String email, @RequestParam("password") String password){
        return userService.getUserByEmailAndPassword(email, password);
    }

    @PostMapping("/registerUser")
    public DtoResponse registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }


}