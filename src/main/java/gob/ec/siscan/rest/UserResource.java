package gob.ec.siscan.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gob.ec.siscan.controller.UserController;

import gob.ec.siscan.dto.output.TokenOutputDto;

@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('OPERATOR')")
@RestController
@RequestMapping(UserResource.USERS)
public class UserResource {

    public static final String USERS = "/users";
    public static final String MINIMUM = "/minimum";

    public static final String TOKEN = "/token";
    public static final String ROLES = "/roles";
    public static final String QUERY = "/query";
    public static final String MOBILE_ID = "/{mobile}";
    public static final String PASSWORDS = "/passwords";
    public static final String LOGOUT = "/logout";
    public static final String PROFILES = "/profiles";
    public static final String VALIDATORS = "/validators";

    @Autowired
    private UserController userController;

    @PreAuthorize("authenticated")
    @PostMapping(value = TOKEN)
    public TokenOutputDto login(@AuthenticationPrincipal User activeUser) {
        return userController.login(activeUser.getUsername());
    }

    @PreAuthorize("authenticated")
    @GetMapping(value = LOGOUT)
    public void logout(@Valid @RequestParam(required = false) String mobile) {
        //Empty
    }
}
