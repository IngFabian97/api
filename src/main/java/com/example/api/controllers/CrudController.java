package com.example.api.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.models.UserModel;
import com.example.api.services.CrudService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class CrudController {

    @Autowired
    CrudService crudService;

    @GetMapping("/users")
    public ArrayList <UserModel> getUsers() {
        return crudService.getUsers();
    }

    @PostMapping("/user")
    public UserModel saveUser(@RequestBody UserModel user) {
        return crudService.saveUser(user);
    }
    
    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        boolean isRemoved = crudService.delteUser(id);
        if(isRemoved){
            return "Usuario eliminado";
        }else{
            return "Error al eliminar el usuario";
        }
    }
    
}
