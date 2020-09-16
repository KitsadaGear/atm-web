package lab6.atm.controller;


import lab6.atm.modal.BankAccount;
import lab6.atm.service.BankAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bankAccount")
public class BankAccountController {

    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    public String getBankAccountPage(Model models) {
        models.addAttribute("allBankAccount", bankAccountService.getBankAccounts());
        return "bankAccount";
    }

    @PostMapping
    public String registerBankAccount(@ModelAttribute BankAccount bankAccount, Model models) {
        bankAccountService.createBankAccount(bankAccount);
        models.addAttribute("allBankAccount", bankAccountService.getBankAccounts());
        return "redirect:bankAccount";
    }
}
