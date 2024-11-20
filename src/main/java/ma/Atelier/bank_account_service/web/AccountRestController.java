package ma.Atelier.bank_account_service.web;

import ma.Atelier.bank_account_service.dto.BankAccountResponseDTO;
import ma.Atelier.bank_account_service.entities.BankAccount;
import ma.Atelier.bank_account_service.mappers.AccountMapper;
import ma.Atelier.bank_account_service.repositories.BankAccountRepository;
import ma.Atelier.bank_account_service.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List
;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private AccountService accountService;
    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper;
    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
    }
    //Consulter un compte
    @GetMapping("/bankAcounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }
    //consulter un liste des comptes
    @GetMapping("/bankAcounts/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found", id)));
    }

    @PostMapping("/bankAcounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountResponseDTO requestDTO) {

        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAcounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount) {

        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getBalance() != null) account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreatdate() != null) account.setCreatdate(new Date());
        if (bankAccount.getCurrency() != null) account.setCurrency(bankAccount.getCurrency());
        if (bankAccount.getAccounttype() != null) account.setAccounttype(bankAccount.getAccounttype());

        return bankAccountRepository.save(account);

    }

    @DeleteMapping("/bankAcounts/{id}")
    public void  deleteAccount(@PathVariable String id) {

            bankAccountRepository.deleteById(id);
    }



}
