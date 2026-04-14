package com.seyahat_planlayici.service;

import com.seyahat_planlayici.dto.auth.AuthResponse;
import com.seyahat_planlayici.dto.auth.LoginRequest;
import com.seyahat_planlayici.dto.auth.RegisterRequest;
import com.seyahat_planlayici.exception.ConflictException;
import com.seyahat_planlayici.exception.ResourceNotFoundException;
import com.seyahat_planlayici.exception.UnauthorizedException;
import com.seyahat_planlayici.model.User;
import com.seyahat_planlayici.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthServiceContract {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new ConflictException("Bu email zaten kayıtlı!");
        }

        User user = new User();
        user.setFirstName(request.name());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));

        userRepository.save(user);
        String token = jwtService.generateToken(user.getEmail());
        return new AuthResponse(token, "Kayıt başarılı!");
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new ResourceNotFoundException("Kullanıcı bulunamadı!"));
        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new UnauthorizedException("Şifre yanlış!");
        }
        String token = jwtService.generateToken(request.email());
        return new AuthResponse(token, "Giriş başarılı!");
    }
}