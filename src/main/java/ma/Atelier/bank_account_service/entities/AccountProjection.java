package ma.Atelier.bank_account_service.entities;

import ma.Atelier.bank_account_service.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class , name="Projection_1")
public interface AccountProjection
{
    public String getId();
    public AccountType getType();
    public  Double getBalance();
}
