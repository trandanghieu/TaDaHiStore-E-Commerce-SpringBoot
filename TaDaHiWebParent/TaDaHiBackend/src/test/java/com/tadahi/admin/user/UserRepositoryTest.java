package com.tadahi.admin.user;

import com.tadahi.common.entity.Role;
import com.tadahi.common.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUserWithOneRole() {
        Role roleAdmin = entityManager.find(Role.class, 1);
        User user = new User("trandanghieu2432002@gmail.com", "hieutd", "Hieu", "Tran Dang");
        user.addRole(roleAdmin);

        User savedUser = userRepository.save(user);
        assert (savedUser.getId() > 0);
    }

    @Test
    public void testCreateUserWithTwoRoles() {
        Role roleAssistant = entityManager.find(Role.class, 2);
        Role roleEditor = entityManager.find(Role.class, 3);

        User user = new User("camhuynh201@gmail.com","camhtn","Cam","Huynh");
        user.addRole(roleAssistant);
        user.addRole(roleEditor);

        User savedUser = userRepository.save(user);

        assert (savedUser.getId() > 0);
    }

    @Test
    public void testListAllUsers() {
        Iterable<User> users = userRepository.findAll();
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void testGetUserById() {
        User user = userRepository.findById(1).get();
        System.out.println(user);
        assert(user != null);
    }

    @Test
    public void testUpdateUser(){
        User user = userRepository.findById(1).get();
        user.setEnabled(true);
        userRepository.save(user);
    }

}
