package com.example.service.employee;

import com.example.model.employee.UserRole;
import com.example.repository.UserRepository;
import com.example.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        com.example.model.employee.User user = this.userRepository.findByName(name);

        if (user == null) {
            System.out.println("User not found! " + name);
            throw new UsernameNotFoundException("User " + name + " was not found in the database");
        }

        System.out.println("Found User: " + user);

        // [ROLE_USER, ROLE_ADMIN,..]
        List<UserRole> userRoles = this.userRoleRepository.findByUser(user);

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (userRoles != null) {
            for (UserRole userRole : userRoles) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getAppRole().getName());
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(user.getName(), //
                user.getPassword(), grantList);

        return userDetails;
    }
}
