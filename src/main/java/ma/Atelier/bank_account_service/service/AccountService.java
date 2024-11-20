package ma.Atelier.bank_account_service.service;

import ma.Atelier.bank_account_service.dto.BankAccountRequestDTO;
import ma.Atelier.bank_account_service.dto.BankAccountResponseDTO;
import ma.Atelier.bank_account_service.entities.BankAccount;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountResponseDTO bankAccountDTO);
}
