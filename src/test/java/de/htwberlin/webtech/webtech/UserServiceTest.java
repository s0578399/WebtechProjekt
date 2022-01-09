package de.htwberlin.webtech.webtech;


import de.htwberlin.webtech.webtech.persistence.UserEntity;
import de.htwberlin.webtech.webtech.persistence.UserRepository;
import de.htwberlin.webtech.webtech.service.UserService;
import de.htwberlin.webtech.webtech.web.api.User;
import de.htwberlin.webtech.webtech.web.api.UserManipulationRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;


    @Test
    @DisplayName("should find a user by its id")
    void findAllTest() {
        List<User> ul = new ArrayList<>();
        User u1 = new User(1L, "James", "Doe", "unknown-street");
        User u2 = new User(2L, "Jane", "Doe", "unknown-street");
        ul.add(u1); ul.add(u2);
        List<UserEntity> uel = new ArrayList<>();
        UserEntity ue1 = new UserEntity("James", "Doe", "unknown-street");
        UserEntity ue2 = new UserEntity("Jane", "Doe", "unknown-street");
        uel.add(ue1); uel.add(ue2);

        doReturn(uel).when(userRepository).findAll();

        var actual = userService.findAll();

        assertEquals(ul.get(0).getFirstName(), actual.get(0).getFirstName());
        assertEquals(ul.get(0).getLastName(), actual.get(0).getLastName());
        assertEquals(ul.get(1).getFirstName(), actual.get(1).getFirstName());
        assertEquals(ul.get(1).getLastName(), actual.get(1).getLastName());
    }

    @Test
    @DisplayName("should find a user by its id")
    void findByIdTest() {
        User u1 = new User(1L, "Jane", "Doe", "unknown-street");
        UserEntity ue1 = new UserEntity("Jane", "Doe", "unknown-street");

        doReturn(Optional.of(ue1)).when(userRepository).findById(1L);

        var actual = userService.findById(1L);

        assertEquals(u1.getFirstName(), actual.getFirstName());
        assertEquals(u1.getLastName(), actual.getLastName());
    }


    @Test
    @DisplayName("should update a product by its id")
    void updateTest() {
        User u1 = new User(1L, "Jane", "Doe", "unknown-street");
        UserEntity ue1 = new UserEntity("Jane", "Doe", "unknown-street");
        UserManipulationRequest um1 = new UserManipulationRequest("Jane", "Doe", "unknown-street");

        doReturn(Optional.of(ue1)).when(userRepository).findById(1L);
        doReturn(ue1).when(userRepository).save(ue1);

        var actual = userService.update(1L, um1);

        assertEquals(u1.getFirstName(), actual.getFirstName());
        assertEquals(u1.getLastName(), actual.getLastName());
    }

    @Test
    @DisplayName("should delete a user by its id")
    void deleteByIdTest() {
        doReturn(true).when(userRepository).existsById(1L);

        var actual = userService.deleteById(1L);

        assertEquals(true, actual);
    }





























}
