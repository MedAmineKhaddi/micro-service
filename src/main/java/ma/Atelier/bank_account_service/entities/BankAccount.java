package ma.Atelier.bank_account_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.Atelier.bank_account_service.enums.AccountType;

import java.rmi.server.UID;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id

    //Creation des attributs
    private String id;
    private String currency;
    private Date creatdate;
    private Double balance;

    //annetation pour changer EnumType à  String
    @Enumerated(EnumType.STRING)
    private AccountType accounttype;
}
