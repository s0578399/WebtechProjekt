package de.htwberlin.webtech.webtech.service;


import de.htwberlin.webtech.webtech.persistence.UserEntity;
import de.htwberlin.webtech.webtech.persistence.UserRepository;
import de.htwberlin.webtech.webtech.web.api.Person;
import de.htwberlin.webtech.webtech.web.api.PersonManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Person> findAll() {
        List<UserEntity> persons = userRepository.findAll();
        return persons.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }


    public Person findById(Long id) {
        var personEntity = userRepository.findById(id);
        return personEntity.isPresent()? transformEntity(personEntity.get()) : null;
    }


    public Person create(PersonManipulationRequest request) {
        var personEntity = new UserEntity(request.getFirstName(), request.getLastName(), request.getAdresse());
        personEntity = userRepository.save(personEntity);
        return transformEntity(personEntity);
    }


    public Person update(Long id, PersonManipulationRequest request) {
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


    private Person transformEntity(UserEntity userEntity) {
        return new Person(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getAdresse()
        );
    }

}
