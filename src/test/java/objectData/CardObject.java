package objectData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardObject extends GeneralObject{
    private String nameCardValue;
    private String cardNumberValue;
    private String cvcCardNumber;
    private String expirationMonthCardNumberValue;
    private String expirationYearCardNumberValue;
    public CardObject(String filePath){fromJsonToObject(filePath);}
}
