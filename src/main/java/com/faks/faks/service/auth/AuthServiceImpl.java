package com.faks.faks.service.auth;

import com.faks.faks.model.command.auth.LoginCommand;
import com.faks.faks.model.dto.auth.LoginDTO;
import com.faks.faks.model.dto.auth.UserDTO;
import com.faks.faks.model.dto.base.base.ApiBaseDTO;
import com.faks.faks.model.dto.base.base.ErrorInfo;
import com.faks.faks.model.entity.User;
import com.faks.faks.repository.UserRepository;
import com.faks.faks.security.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(JwtTokenUtil jwtTokenUtil,
                           UserRepository userRepository,
                           AuthenticationManager authenticationManager) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        ;
    }


    @Transactional
    @Override
    public ApiBaseDTO loginUser(LoginCommand loginCommand, HttpServletRequest request) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginCommand.getEmail(),
                            loginCommand.getPassword()));
            User user = userRepository.findByEmail(loginCommand.getEmail()).orElse(null);
            if (user == null) {
                throw new Exception("No user found");
            }
            UserDTO userDTO = UserDTO.fromEntity(user);
            final String jwtToken = jwtTokenUtil.generateToken(userDTO);
            return ApiBaseDTO.generateSuccessResponse(new LoginDTO(userDTO, jwtToken, ""));
        } catch (Exception e) {
            e.printStackTrace();
            return ApiBaseDTO.generateErrorResponse(ErrorInfo.GENERAL_ERROR);
        }
    }

    @Override
    public LoginDTO getLoggedUserData() {
        User loggedUser = getUserFromPrincipal();
        return new LoginDTO(UserDTO.fromEntity(loggedUser), "", "");
    }

    @Transactional
    @Override
    public Boolean logoutUser() {
        User loggedUser = getUserFromPrincipal();
        if (loggedUser != null && loggedUser.getEmail() != null && !loggedUser.getEmail().equals("")) {
            SecurityContextHolder.getContext().setAuthentication(null);
            return true;
        }
        return false;
    }

    @Override
    public User getUserFromPrincipal() {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                return userRepository.findByEmail(((UserDetails) principal).getUsername()).orElse(null);
            }
        }
        return null;
    }
}
