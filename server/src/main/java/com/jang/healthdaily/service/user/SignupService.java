package com.jang.healthdaily.service.user;

import com.jang.healthdaily.exception.AppException;
import com.jang.healthdaily.model.Role.Role;
import com.jang.healthdaily.model.Role.RoleName;
import com.jang.healthdaily.payload.User.SignUpRequest;
import com.jang.healthdaily.repository.User;
import com.jang.healthdaily.repository.Camp.CampRepository;
import com.jang.healthdaily.repository.RoleRepository;
import com.jang.healthdaily.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SignupService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    CampRepository campRepository;

    public void addUser(SignUpRequest signUpRequest) {
        addUserInfo(signUpRequest);
    }

    private void addUserInfo(SignUpRequest signUpRequest) {
        User user = new User(
            signUpRequest.getUserName(),
            signUpRequest.getEmail(),
            signUpRequest.getPassword(),
            signUpRequest.getCell(),
            signUpRequest.getPhone()
        );

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("user Role not set."));

        user.setRoles(Collections.singleton(userRole));
        userRepository.save(user);
    }


    /*private void addCampInfo(SignUpRequest signUpRequest, String companyCode) {
        Campsite campsite = new Campsite(
                signUpRequest.getAddress(),
                signUpRequest.getStreet(),
                signUpRequest.getCell(),
                signUpRequest.getCompanyName(),
                companyCode,
                111111,
                222222,
                signUpRequest.getPhone(),
                signUpRequest.isOnlineSettle(),
                signUpRequest.isBankBookSettle(),
                signUpRequest.isOfflineCardSettle(),
                signUpRequest.isOfflineCashSettle()
        );

        campRepository.save(campsite);
    }
*/
}