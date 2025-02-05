package com.tadahi.admin.user;

import com.tadahi.common.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository repository;

    @Test
    public void testCreateFirstRole() {
        Role roleAdmin = new Role("Admin", "Manage everything");
        Role savedRole = repository.save(roleAdmin);
        assert (savedRole.getId() > 0);
    }

    @Test
    public void testCreateSecondRole() {
        Role roleSalesperson = new Role("Salesperson",
                                    "Manage products price"
                                            + ", customers, shipping, orders and sales report.");

        Role roleEditor = new Role("Editor",
                                "Manage categories, brands, products, articles and menus");

        Role roleShipper = new Role("Shipper",
                                "View products, view orders and update order status");

        Role roleAssistant = new Role("Assistant",
                                  "Manage questions and reviews");

        repository.saveAll(List.of(roleAssistant, roleEditor, roleSalesperson, roleShipper));
    }

}
