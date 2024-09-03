package objectData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginObject extends GeneralObject{
    private String emailValue;
    private String passwordValue;
    public LoginObject(String pathFile){fromJsonToObject(pathFile);}
}
