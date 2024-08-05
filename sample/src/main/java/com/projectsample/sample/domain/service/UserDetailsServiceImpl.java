package com.projectsample.sample.domain.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projectsample.sample.domain.entity.Account;
import com.projectsample.sample.domain.repository.AccountRepository;


/* Basicamente esta clase nos sirve para buscar los usuarios a la hora de autenticarnos en la base de datos*/
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        List<Account> accounts = accountRepository.findByEmail(email);

        if (accounts.isEmpty()){
            throw( new UsernameNotFoundException("El usuario con el email ingresado no existe"));
        
        }
        Account accountFound = accounts.get(0);

        Collection<? extends GrantedAuthority> authorities = accountFound.getRoles()
            .stream()
            .map(role -> new SimpleGrantedAuthority("ROLE_".concat(role.getName().name())))
            .collect(Collectors.toSet());

        
        
        return new User(
            accountFound.getEmail(),
            accountFound.getPassword(),
            true,
            true,
            true,
            true,
            authorities
        );
    }


    


}
