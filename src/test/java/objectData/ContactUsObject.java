package objectData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactUsObject extends GeneralObject{
    private String nameValue;
    private String emailValue;
    private String subjectValue;
    private String messageValue;

    public ContactUsObject(String filePath){fromJsonToObject(filePath);}

}
