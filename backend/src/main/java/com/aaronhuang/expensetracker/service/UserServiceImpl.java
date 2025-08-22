package com.aaronhuang.expensetracker.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.authentication.AuthenticationProvider;

import com.aaronhuang.expensetracker.dto.UserDto;
import com.aaronhuang.expensetracker.dto.LoginRequest;
import com.aaronhuang.expensetracker.dto.LoginResponse;
import com.aaronhuang.expensetracker.model.User;
import com.aaronhuang.expensetracker.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{
    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;  
    public UserServiceImpl(UserRepository repo, PasswordEncoder passwordEncoder,JWTService jwtService){
        this.repo=repo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }


    public LoginResponse verify(LoginRequest loginRequest) {
        User user = repo.findByEmail(loginRequest.getEmail())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password"));
        
        // Manual password check instead of AuthenticationManager
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password");
        }
        
        String token = jwtService.generateToken(user);
        return new LoginResponse(token, new UserDto(user));
    }

    @Override
    public User create(User u){
        // Hash+Salt the password before saving
        String encryptedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encryptedPassword);
        return repo.save(u);
    }

    @Override
    public Optional<User> getById(Long id){
        return repo.findById(id);
    }

    @Override
    public List<User> getAll(){
        return repo.findAll();
    }

    @Override
    public User updateById(Long id, User u){
        User existing = getById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                            "User not Found: " + id));
        existing.setName(u.getName());

        //update password only if provided
        if(u.getPassword() != null && !u.getPassword().isEmpty()){
            String encryptedPassword = passwordEncoder.encode(u.getPassword());
            existing.setPassword(encryptedPassword);
        }
        return repo.save(existing);
    }

    @Override
    public User deleteById(Long id){
        User existing = getById(id)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, 
                                                            "User not found: " + id));
        repo.delete(existing);
        return existing;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByEmail(username)  // Using email as username
            .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));
    }

    public User getUserFromToken(String auth){
        String token = auth.substring(7); 
        String email = jwtService.extractUserEmail(token);
        return repo.findByEmail(email)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid token"));
    }


}