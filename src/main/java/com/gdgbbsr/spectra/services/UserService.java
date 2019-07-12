package com.gdgbbsr.spectra.services;

import com.gdgbbsr.spectra.dto.Result;
import com.gdgbbsr.spectra.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    @Override
    User loadUserByUsername(String username) throws UsernameNotFoundException;

    User register(String username, String password) throws UsernameNotAvailableException;
}
