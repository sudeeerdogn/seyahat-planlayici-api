package com.seyahat_planlayici.service;

import com.seyahat_planlayici.dto.auth.AuthResponse;
import com.seyahat_planlayici.dto.auth.LoginRequest;
import com.seyahat_planlayici.dto.auth.RegisterRequest;

public interface AuthServiceContract {
    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}
