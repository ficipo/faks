package com.faks.faks.service.user;

//import com.faks.faks.model.command.base.ApiBasePageCommand;
import com.faks.faks.model.command.user.DeleteUserCommand;
import com.faks.faks.model.command.user.FilterUserCommand;
import com.faks.faks.model.command.user.SaveUserCommand;
import com.faks.faks.model.dto.auth.UserDTO;
import com.faks.faks.model.dto.base.base.ApiBaseDTO;
import com.faks.faks.model.dto.base.base.ApiBasePageDTO;
import com.faks.faks.model.dto.base.base.ErrorInfo;
import com.faks.faks.model.dto.base.base.PageDTO;
import com.faks.faks.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ApiBasePageDTO<UserDTO> getAllUsers() {
        return ApiBasePageDTO.setApiPageResponse(UserDTO.fromList(userRepository.findAll()), PageDTO.builder().build());
    }

    @Transactional
    @Override
    public ApiBaseDTO<UserDTO> saveUser(SaveUserCommand command) {
        return ApiBaseDTO.generateSuccessResponse(UserDTO.fromEntity(userRepository.save(command.toEntity())));
    }

    @Transactional
    @Override
    public ApiBaseDTO<UserDTO> filterUser(FilterUserCommand command) {
        return userRepository.findById(command.getId())
                .map(user -> ApiBaseDTO.generateSuccessResponse(UserDTO.fromEntity(user)))
                .orElseGet(() -> ApiBaseDTO.generateErrorResponse(ErrorInfo.GENERAL_ERROR));
    }


    @Override
    public Boolean deleteUser(DeleteUserCommand command) {
        userRepository.deleteById(command.getId());
        return true;
    }

}
