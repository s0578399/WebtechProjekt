package de.htwberlin.webtech.webtech.service;

import de.htwberlin.webtech.webtech.persistence.UserEntity;
import de.htwberlin.webtech.webtech.repository.UserRepository;
import de.htwberlin.webtech.webtech.web.api.User;
import de.htwberlin.webtech.webtech.web.api.UserManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity findString(String s) {
        return userRepository.findUserEntityByFirstNameIsContaining(s);
    }

    public List<User> findAll() {
        List<UserEntity> persons = userRepository.findAll();
        return persons.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }


    public User findById(Long id) {
        var userEntity = userRepository.findById(id);
        return userEntity.isPresent()? transformEntity(userEntity.get()) : null;
    }


    public User create(UserManipulationRequest request) {
        var userEntity = new UserEntity(request.getLogin(), request.getPassword(), request.getFirstName(), request.getLastName(), request.getAdresse(), request.getRole(), request.getBucket());
        userEntity = userRepository.save(userEntity);
        return transformEntity(userEntity);
    }


    public User update(Long id, UserManipulationRequest request) {
        var userEntityOptional = userRepository.findById(id);
        if (userEntityOptional.isEmpty()) {
            return null;
        }
        var userEntity = userEntityOptional.get();
        userEntity.setLogin(request.getLogin());
        userEntity.setPassword(request.getPassword());
        userEntity.setFirstName(request.getFirstName());
        userEntity.setLastName(request.getLastName());
        userEntity.setAdresse(request.getAdresse());
        userEntity.setRole(request.getRole());
        userEntity.setBucket(request.getBucket());

        //userEntity = userRepository.save(userEntity);
        userRepository.save(userEntity);
        return transformEntity(userEntity);
    }


    public boolean deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }


    private User transformEntity(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getLogin(),
                userEntity.getPassword(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getAdresse(),
                userEntity.getRole(),
                userEntity.getBucket()
        );
    }

}
