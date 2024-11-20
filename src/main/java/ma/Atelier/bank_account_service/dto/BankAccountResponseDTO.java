package ma.Atelier.bank_account_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.Atelier.bank_account_service.enums.AccountType;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponseDTO {

    private String id;
    private Date creationDate;
    private String currency;
    private Double balance;
    private AccountType accounttype;
}
