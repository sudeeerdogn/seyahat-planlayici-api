package com.seyahat_planlayici.service;

import com.seyahat_planlayici.model.User;
import com.seyahat_planlayici.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public Map<String, String> register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Bu email zaten kayıtlı!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        String token = jwtService.generateToken(user.getEmail());
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("message", "Kayıt başarılı!");
        return response;
    }

    public Map<String, String> login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı!"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Şifre yanlış!");
        }
        String token = jwtService.generateToken(email);
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("message", "Giriş başarılı!");
        return response;
    }
}