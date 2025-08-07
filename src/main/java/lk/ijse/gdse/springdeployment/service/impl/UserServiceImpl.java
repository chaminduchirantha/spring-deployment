//package lk.ijse.gdse.springdeployment.service.impl;
//
//import lk.ijse.gdse.springdeployment.dto.UserDto;
//import lk.ijse.gdse.springdeployment.entity.User;
//import lk.ijse.gdse.springdeployment.repositary.UserRepositary;
//import lk.ijse.gdse.springdeployment.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class UserServiceImpl implements UserService {
//    private final UserRepositary userRepositary;
//    private final ModelMapper modelMapper;
//
//    @Override
//    public void saveUser(UserDto userDto) {
//        userRepositary.save(modelMapper.map(userDto, User.class));
//    }
//
//    @Override
//    public UserDto loginUser(String userEmail, String password) {
//        Optional<User> userOpt = userRepositary.findByUserEmailAndPassword(userEmail, password);
//        if (userOpt.isPresent()) {
//            User user = userOpt.get();
//            return new UserDto(user.getId(), user.getUsername(), user.getUserEmail(), null);
//        } else {
//            throw new RuntimeException("Invalid credentials");
//        }
//    }
//}
