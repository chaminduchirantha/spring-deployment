package lk.ijse.gdse.springdeployment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String username;
    private String password;
    private String userEmail;

    public UserDto(Integer id, String username, String password, String userEmail) {
    }
}
