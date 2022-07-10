package grabit.grabit_backend.service;

import grabit.grabit_backend.domain.User;
import grabit.grabit_backend.dto.UpdateUserDTO;
import grabit.grabit_backend.exception.ForbiddenException;
import grabit.grabit_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    /**
     * 유저 업데이트
     * @param
     * @return
     */
    @Transactional
    public User updateUser(UpdateUserDTO updateUserDTO, User user) {
        if (updateUserDTO.getUsername() != null) user.setUsername(updateUserDTO.getUsername());
        if (updateUserDTO.getBio() != null) user.setBio(updateUserDTO.getBio());
        if (updateUserDTO.getProfileImage() != null) user.setProfileImg(updateUserDTO.getProfileImage());

        return userRepository.save(user);
    }
}
