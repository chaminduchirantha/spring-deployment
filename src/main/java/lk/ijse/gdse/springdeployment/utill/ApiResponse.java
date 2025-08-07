package lk.ijse.gdse.springdeployment.utill;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private int status;
    private String message;
    private Object data;
    //string Return karanna , Array ekak return karann , null ekak return karanna

}
