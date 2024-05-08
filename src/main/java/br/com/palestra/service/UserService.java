package br.com.palestra.service;

import br.com.palestra.entity.User;
import br.com.palestra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public User create(User user){
        return userRepository.save(user);
    }

    public User update(Long id, User user){
        userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário com o ID " + id + " não encontrado"));;
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
