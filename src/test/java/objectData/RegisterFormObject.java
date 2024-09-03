package objectData;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RegisterFormObject extends GeneralObject{

    private String genderValue;
    private String nameValue;
    private String emailAdressValue;
    private String passwordValue;
    private String dayValue;
    private String monthValue;
    private String yearValue;
    private String firstNameValue;
    private String lastNameValue;
    private String companyValue;
    private String adress1Value;
    private String adress2Value;
    private String countryValue;
    private String cityValue;
    private String stateValue;
    private String zipCodeValue;
    private String phoneNumber;
    private String incorrectEmailValue;
    private String incorrectPasswordValue;

    public RegisterFormObject(String filePath){fromJsonToObject(filePath);}
}
