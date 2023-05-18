package com.vsu.skibin.coursework.app.controller.profile;

import com.vsu.skibin.coursework.app.api.data.dto.ProfileDTO;
import com.vsu.skibin.coursework.app.api.data.request.DoublePasswordRequest;
import com.vsu.skibin.coursework.app.api.data.request.SignInRequest;
import com.vsu.skibin.coursework.app.api.data.request.SignUpRequest;
import com.vsu.skibin.coursework.app.service.ProfileService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vsu.skibin.coursework.app.tool.PasswordUtil;

import java.util.Collection;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{id}")
    public ProfileDTO profiling(@PathVariable("id") Long profileId){
        return profileService.getProfile(profileId);
    }

    @GetMapping("/{id}/subscription")
    public Collection<ProfileDTO> getSubscribe(@PathVariable("id") Long profileId){
        return profileService.getSubscribes(profileId);
    }

    @PostMapping("/sign_in")
    public ProfileDTO signIn(@RequestBody SignInRequest request){
        return profileService.signIn(request.getLogin(), PasswordUtil.getHash(request.getPassword()));
    }

    @PostMapping("/sign_up")
    public void signUp(@RequestBody SignUpRequest request) {
        profileService.signUp(request.getLogin(),
                request.getEmail(),
                request.getPassword(),
                request.getPasswordRepeat());
    }

    @PatchMapping("/{id}/password")
    public void changePassword(@PathVariable("id") Long profileId,
                               @RequestBody DoublePasswordRequest passwordRequest){
        profileService.changePassword(profileId, passwordRequest.getOldPassword(), passwordRequest.getNewPassword());
    }

    @PatchMapping("/{id}/author")
    public boolean becomeAnAuthor(@PathVariable("id") Long profileId){
        return profileService.becomeAnAuthor(profileId);
    }

    @PostMapping("/{id}/subscription")
    public void subscribe(@PathVariable("id") Long profileId, @RequestParam("author") String authorLogin){
        profileService.subscribeToProfile(profileId, authorLogin);
    }

    @DeleteMapping("/{id}/subscription")
    public void unsubscribe(@PathVariable("id") Long profileId, @RequestParam("author") String authorLogin){
        profileService.unsubscribeFromProfile(profileId, authorLogin);
    }
}
