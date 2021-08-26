package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.models.Role;
import web.models.User;
import web.service.RoleService;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Initialization {
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostConstruct
    public void init(){
        Role admin = new Role(1L, "ROLE_ADMIN");
        Role user = new Role(2L, "ROLE_USER");

        roleService.save(admin);
        roleService.save(user);

        Set<Role> allAccess = new HashSet<>();
        Set<Role> userAccess = new HashSet<>();

        allAccess.add(admin);
        allAccess.add(user);

        userAccess.add(user);

        User user1 = new User(1L, "admin", "admin", "Admin", "Adminov", (byte) 35, "admin@adminov.com", allAccess);
        User user2 = new User(2L, "qwerty", "qwerty", "Qwerty", "Adminov", (byte) 36, "qwerty@gmail.com", userAccess);
        User user3 = new User(3L, "user", "user", "User1", "Userov", (byte) 30, "user@gmail.com", userAccess);
        User user4 = new User(4L, "rick", "rick", "Rickardo", "Milos", (byte) 39, "rick@gmail.com", userAccess);
        User user5 = new User(5L, "alex", "alex", "Alex", "Smirnov", (byte) 99, "alex@gmail.com", allAccess);
        User user6 = new User(6L, "impostor", "impostor", "Impostor", "Imposter", (byte) 9, "imp@mail.ru", userAccess);
        User user7 = new User(7L, "bad", "bad", "Bad", "Comedian", (byte) 66, "bad@rambbler.net", userAccess);
        User user8 = new User(8L, "morty", "morty", "Morty", "Morty", (byte) 12, "morty@gmail.com", userAccess);
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);
    }

}
