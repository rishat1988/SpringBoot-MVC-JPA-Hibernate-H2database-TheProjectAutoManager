package com.services.user;

import com.models.User;
import java.util.Set;

public interface UserService {
    void create(User user);

    User findByUserName(String username);

    String encodePassword(String password);

    Boolean checkPassword(User user, String password);

    User getUserById(Long userId);
}
