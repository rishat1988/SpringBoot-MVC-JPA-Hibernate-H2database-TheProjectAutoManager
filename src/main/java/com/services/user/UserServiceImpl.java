package com.services.user;


import com.models.User;
import com.repositories.RoleRepository;
import com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void create(User user) {
        user.setPassword(encodePassword(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public Boolean checkPassword(User user, String password) {
        return bCryptPasswordEncoder.matches(password, user.getPassword());
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.getOne(userId);
    }
}
