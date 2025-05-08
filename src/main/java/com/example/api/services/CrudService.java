package com.example.api.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.models.UserModel;
import com.example.api.repositories.UserRepository;

@Service
public class CrudService {

    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        System.out.println("Buscando datos...");
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        System.out.println("Guardando datos...");
        System.out.println("Datos guardaddos" + user);
        return userRepository.save(user);
    }

    public boolean deleteUser(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception err){
            System.out.println("Error al eliminar el usuario");
            return false;
        }
    }

    public UserModel updateUser(Long id, UserModel user){
        Optional<UserModel> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            UserModel existingUser = optionalUser.get();
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        } else {
            return null; 

        }
    }
}
