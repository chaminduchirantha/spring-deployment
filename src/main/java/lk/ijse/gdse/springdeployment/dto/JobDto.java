package lk.ijse.gdse.springdeployment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
    private Integer id;
    @NotBlank(message = "job tittle mandatory")
    private String jobTitle;
    @NotBlank(message = "companyName mandatory")
    @Pattern(regexp = "[a-zA-Z]+$" , message = "Company name should contain only alphabet")
    private String company;
    private String location;
    @NotBlank(message = "type is mandatory")
    private String type;
    @Size(min = 10 , max = 100 , message = "job description should be at 10 character is long")
    private String jobDescription;
    private String status;
}
