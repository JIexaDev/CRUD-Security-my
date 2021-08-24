package web.service;


import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void save(User user);

    void delete(Long id);

    User getById(Long id);

    User getByLogin(String login);
}
