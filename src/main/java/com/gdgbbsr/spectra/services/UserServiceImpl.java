package com.gdgbbsr.spectra.services;

import com.gdgbbsr.spectra.models.User;
import com.gdgbbsr.spectra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findOneByUsername(username).orElseThrow(() ->
            new UsernameNotFoundException(String.format("User %s not found", username)));
    }

    @Override
    public User register(String username, String password) throws UsernameNotAvailableException {

        if (this.userRepository.findOneByUsername(username).isPresent()) {
            throw new UsernameNotAvailableException();
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));

        return userRepository.save(newUser);
    }

}
