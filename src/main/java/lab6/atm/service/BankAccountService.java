package lab6.atm.service;

import lab6.atm.modal.BankAccount;
import lab6.atm.modal.Customer;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {
    private List<BankAccount> bankAccountsList;

    @PostConstruct
    public void postConstruct() {
        this.bankAccountsList = new ArrayList<>();
    }

    public void createBankAccount(BankAccount bankAccount) {
        bankAccountsList.add(bankAccount);
    }

    public List<BankAccount> getBankAccounts() {

        return new ArrayList<>(this.bankAccountsList);

    }
   
}
