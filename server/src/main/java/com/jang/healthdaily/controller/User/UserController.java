package com.jang.healthdaily.controller.User;

import com.jang.healthdaily.payload.User.UserIdentityAvailability;
import com.jang.healthdaily.payload.User.UserSummary;
import com.jang.healthdaily.repository.UserRepository;
import com.jang.healthdaily.security.CurrentUser;
import com.jang.healthdaily.security.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /*@Autowired
    private PollRepository pollRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private PollService pollService;*/

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername());
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "userName") String userName) {
        Boolean isAvailable = !userRepository.existsByUserName(userName);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

 /*   @GetMapping("/users/{userName}")
    public UserProfile getUserProfile(@PathVariable(value = "userName") String userName) {
        user user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new ResourceNotFoundException("user", "userName", userName));

        long pollCount = pollRepository.countByCreatedBy(user.getId());
        long voteCount = voteRepository.countByUserId(user.getId());

        UserProfile userProfile = new UserProfile(user.getId(), user.getCreatedAt(), pollCount, voteCount);

        return userProfile;
    }*/

  /*  @GetMapping("/users/{userName}/polls")
    public PagedResponse<PollResponse> getPollsCreatedBy(@PathVariable(value = "userName") String userName,
                                                         @CurrentUser UserPrincipal currentUser,
                                                         @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                         @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return pollService.getPollsCreatedBy(userName, currentUser, page, size);
    }


    @GetMapping("/users/{userName}/votes")
    public PagedResponse<PollResponse> getPollsVotedBy(@PathVariable(value = "userName") String userName,
                                                       @CurrentUser UserPrincipal currentUser,
                                                       @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                       @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return pollService.getPollsVotedBy(userName, currentUser, page, size);
    }*/

}