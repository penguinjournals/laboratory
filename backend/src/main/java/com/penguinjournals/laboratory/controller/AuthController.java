package com.penguinjournals.laboratory.controller;

import com.penguinjournals.laboratory.domain.JwtResponse;
import com.penguinjournals.laboratory.domain.LoginRequest;
import com.penguinjournals.laboratory.domain.MessageResponse;
import com.penguinjournals.laboratory.domain.Role;
import com.penguinjournals.laboratory.domain.RoleName;
import com.penguinjournals.laboratory.domain.SignupRequest;
import com.penguinjournals.laboratory.domain.User;
import com.penguinjournals.laboratory.repository.RoleRepository;
import com.penguinjournals.laboratory.repository.UserRepository;
import com.penguinjournals.laboratory.security.jwt.JwtUtils;
import com.penguinjournals.laboratory.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("checkstyle:MagicNumber")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody final LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(role -> role.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                                                userDetails.getId(),
                                                userDetails.getUsername(),
                                                userDetails.getEmail(),
                                                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody final SignupRequest signupRequest) {
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: User name is already in use"));
        }

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use"));
        }

        User user = new User(signupRequest.getUsername(),
                            signupRequest.getEmail(),
                            passwordEncoder.encode(signupRequest.getPassword()));

        List<Role> defaultRoleList = new ArrayList<>();

        Role roleUser = roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Default User role is not present on database"));
        defaultRoleList.add(roleUser);
        user.setRoles(defaultRoleList);

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered succesfully"));
    }
}
