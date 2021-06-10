package demoreact.demo.controlleradmin;

import demoreact.demo.config.JwtTokenProvider;
import demoreact.demo.entity.CustomAccDetails;
import demoreact.demo.entity.LoginDto;
import demoreact.demo.handleexeption.LoginResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * LoadResController
 *
 * Version 1.0
 *
 * Date: 06-07-2021
 *
 * Copyright
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 06-07-2021          Anhtp8           Login
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin/api")
public class LoadResController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    /***
     *
     * @param loginRequest
     * @return JWT for login
     */

    @PostMapping("/login")
    public LoginResponse authenticateUser(@Valid @RequestBody LoginDto loginRequest) {
        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomAccDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }

}
