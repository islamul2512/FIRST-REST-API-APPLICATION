package com.example.FirstRestApi;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController // this tells spring Application that  API written this class

public class ApiClass {
    // this is databse like using hashMap
    Map<Integer,User> userDB = new HashMap<>();
    @GetMapping("/getWeatherUpdate")
    public String getWeatherUpdate(){
        return "The weather is cold The wind is 30 kmph " + "And the temperature is 20 degree ";
    }

    @GetMapping("/addUser")
    public String addUser(@RequestParam("userId") int userId,
                          @RequestParam("age") int age,
                          @RequestParam("name") String name){
    // to add this information to database
        User userObj = new User(name,age,userId);
        int dbKey = userId;
        userDB.put(dbKey,userObj);
        return "user has been added database ";
    }

    @PostMapping("/addUserViaBody")
    public String addUserViaReqBody(@RequestBody User userObj){
        int dbKey = userObj.getUserId();
        userDB.put(dbKey,userObj);
        return "User has been added in DB";
    }

    @GetMapping("getUserInformation")
    public User getUser(@RequestParam("userId") int userId){
        User user = userDB.get(userId);
        return user;
    }
}
