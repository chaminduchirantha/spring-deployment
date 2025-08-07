//package lk.ijse.gdse.springdeployment.controller;
//
//import lk.ijse.gdse.springdeployment.dto.UserDto;
//import lk.ijse.gdse.springdeployment.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("api/v1/user")
//@RequiredArgsConstructor
//@CrossOrigin
//public class UserController {
//
//    private final UserService userService;
//
//    @PostMapping("save")
//    public void saveUser(@RequestBody UserDto userDto) {
//        userService.saveUser(userDto);
//    }
//
//    @PostMapping("login")
//    public UserDto loginUser(@RequestBody UserDto userDto) {
//        return userService.loginUser(userDto.getUserEmail(), userDto.getPassword());
//    }
//
//
//}
