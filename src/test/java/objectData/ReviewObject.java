package objectData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewObject extends GeneralObject{
    private String nameValue;
    private String emailValue;
    private String reviewValue;

    public ReviewObject (String filePath){fromJsonToObject(filePath);}

}
