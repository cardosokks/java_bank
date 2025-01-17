package br.com.banco.bank;

import br.com.banco.account.AccountDTO;

import java.util.List;

public class BankService {

    public void insertAccount(AccountDTO accountDTO, BankDTO bankDTO) {
        bankDTO.getAccounts().add(accountDTO);
    }

    public List<AccountDTO> getAccounts(BankDTO bankDTO) {
        return bankDTO.getAccounts();
    }

    public AccountDTO generateAccount(BankDTO bankDTO, String name, String cpf) {
        AccountDTO accountDTO = new AccountDTO(bankDTO.getAg(), "" + bankDTO.getLastAccount(), name, cpf);
        bankDTO.setLastAccount(bankDTO.getLastAccount() + 1);
        return accountDTO;
    }

    public double outputTotal(BankDTO bankDTO) {
        double total = 0;
        for (AccountDTO accountDTO : bankDTO.getAccounts()) {
            double balance = accountDTO.getBalance();
            total += balance;
        }
        return total;
    }

    public int outputContagemContas(BankDTO bankDTO) {
        return bankDTO.getAccounts().size();
    }

    public AccountDTO findByName(BankDTO santander, String nameAccount) {
        for(AccountDTO account: santander.getAccounts()){
            if(account.getName().equalsIgnoreCase(nameAccount)){
                return account;
            }
        }
        return null;
    }

    public AccountDTO findByCpf(BankDTO santander, String cpfAccount) {
        for(AccountDTO account: santander.getAccounts()){
            if(account.getCpf().equalsIgnoreCase(cpfAccount)){
                return account;
            }
        }
        return null;
    }
}
