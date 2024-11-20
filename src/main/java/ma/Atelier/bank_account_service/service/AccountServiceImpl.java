package ma.Atelier.bank_account_service.service;

import jakarta.transaction.Transactional;
import ma.Atelier.bank_account_service.dto.BankAccountResponseDTO;
import ma.Atelier.bank_account_service.entities.BankAccount;
import ma.Atelier.bank_account_service.mappers.AccountMapper;
import ma.Atelier.bank_account_service.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountResponseDTO bankAccountDTO) {

        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .balance(bankAccountDTO.getBalance())
                .accounttype(bankAccountDTO.getAccounttype())
                .currency(bankAccountDTO.getCurrency())
                .creatdate(new Date())

                .build();

        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }
}
