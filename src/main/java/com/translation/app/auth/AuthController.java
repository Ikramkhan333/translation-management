package com.translation.app.auth;

import com.translation.app.security.JwtTokenProvider;
import com.translation.app.user.User;
import com.translation.app.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    /**
     * @author ikram
     * @since 28-02-2025
     * @apiNote function login and get Token
     */
    @PostMapping("/login")
    @Operation(summary = "User login")
    public ResponseEntity<Object> login(@RequestParam String username, @RequestParam String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        Map<String,Object> result = new HashMap<>();
        result.put("token",jwtTokenProvider.generateToken(username));
        return ResponseEntity.ok().body(result);
        }

    /**
     * @author ikram
     * @since 28-02-2025
     * @apiNote function add user
     */
    @PostMapping("/register")
    @Operation(summary = "User registration")
    public String register(@RequestBody User user) {
        userService.save(user);
        return "User registered successfully";
    }
}
