package com.example.FirstRestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class ControllerLayer {
    List<Integer> li = new ArrayList<>();
    @Autowired
    private ServiceLayer serviceLayerObj;
    @PostMapping("/addToDb")
    public RepositoryLayer<String> addToDb(@RequestBody User user){

        String result = serviceLayerObj.addUserToDb(user);

        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }
    @GetMapping("/getFromDb")
    public ResponseEntity<User> getFromDb(@RequestParam("userId")Integer userId){

        User userObj = serviceLayerObj.getFromDb(userId);

        return new ResponseEntity<>(userObj,HttpStatus.OK);

    }
    @GetMapping("/getNameWithYoungestAge")
    public ResponseEntity<String> getNameOfPerson(){

        String name = serviceLayerObj.personWithYoungestAge();
        return new ResponseEntity<>(name,HttpStatus.BAD_GATEWAY);
    }

    @GetMapping("/getTotalPeopleRegistered")
    public ResponseEntity<Integer> getTotalPeople(){
        int ans = serviceLayerObj.getTotalPeople();
        return new ResponseEntity<>(ans,HttpStatus.ACCEPTED);
    }
}
