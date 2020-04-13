package ru.sibdigital.difar.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.repository.classifier.accs.ClsUserRepository;

import java.util.Collections;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private ClsUserRepository userRepository;

    public UserPrincipalDetailsService(ClsUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ClsUserEntity user = userRepository.findByName(username);
        return new User(user.getName(), user.getPassword(), Collections.emptyList());
    }
}