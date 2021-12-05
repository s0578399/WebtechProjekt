package de.htwberlin.webtech.webtech.service;

import de.htwberlin.webtech.webtech.persistence.UserEntity;
import de.htwberlin.webtech.webtech.persistence.UserRepository;
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

    public List<User> findAll() {
        List<UserEntity> persons = userRepository.findAll();
        return persons.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }


    public User findById(Long id) {
        var personEntity = userRepository.findById(id);
        return personEntity.isPresent()? transformEntity(personEntity.get()) : null;
    }


    public User create(UserManipulationRequest request) {
        var personEntity = new UserEntity(request.getFirstName(), request.getLastName(), request.getAdresse(), request.getLogin(), request.getPassword());
        personEntity = userRepository.save(personEntity);
        return transformEntity(personEntity);
    }


    public User update(Long id, UserManipulationRequest request) {
        var personEntityOptional = userRepository.findById(id);
        if (personEntityOptional.isEmpty()) {
            return null;
        }
        var personEntity = personEntityOptional.get();
        personEntity.setFirstName(request.getFirstName());
        personEntity.setLastName(request.getLastName());
        personEntity.setAdresse(request.getAdresse());

        personEntity = userRepository.save(personEntity);
        return transformEntity(personEntity);
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
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getAdresse(),
                userEntity.getLogin(),
                userEntity.getPassword()
        );
    }

}
