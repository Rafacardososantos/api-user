package com.example.api_user.service;

import com.example.api_user.model.User;
import com.example.api_user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByNome(username);
        if(user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }
        return org.springframework.security.core.userdetails.User.withUsername(user.getNome()).password(user.getSenha()).build();
    }

//    public UserDetails loadUserById (int id) {
//        Optional<User> Id = userRepository.findById(id);
//        if(Id.isEmpty()){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//        return org.springframework.security.core.userdetail;
//    }
}
