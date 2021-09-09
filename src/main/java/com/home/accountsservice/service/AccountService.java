package com.home.accountsservice.service;

import com.home.accountsservice.exception.AccountException;
import com.home.accountsservice.model.Account;
import com.home.accountsservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service public class AccountService {

	@Autowired private AccountRepository accountRepository;

	public Account getByAccountNumber(String accountNumber) throws AccountException {
		return Optional.ofNullable(accountRepository.findById(BigDecimal.valueOf(Long.valueOf(accountNumber)))).get()
				.orElse(null);
	}

	public Account getAccountNumber(BigDecimal accountNumber) throws AccountException {
		// Optional<Optional<Account>> account = Optional.ofNullable ( accountRepository.findById ( BigDecimal.valueOf ( Long.valueOf ( accountNumber ) ) ) );

		Optional<Account> account = accountRepository.findById(accountNumber);
		if (account.isPresent())
			return account.get();
		else
			throw new AccountException("Account does not exist");
	}

	public Account saveOrUpdate(Account account) throws AccountException {

		//Pre conditions check
		checkElligibility(account);
		return accountRepository.save(account);
	}

	private boolean checkElligibility(Account account) throws AccountException {
		if (2000 > account.getBalance().intValue())
			throw new AccountException("Please provide balance greater than 2000");
		return true;
	}

	public Account addBalance(Long accountNumber, Long creditAmount) throws AccountException {
		Account toCreditAccount = getByAccountNumber(String.valueOf(accountNumber));
		toCreditAccount.setBalance(BigDecimal.valueOf(toCreditAccount.getBalance().longValue() + creditAmount));
		return accountRepository.save(toCreditAccount);
	}

	public void creditBalance(Long amount) {
		Long newAmount = amount + 65000;
		newAmount = 9600L;
        System.out.println(amount);
        System.out.println(newAmount);
		newAmount = newAmount*23;
	}

	public void debit(Long amount) {
		Long newAmount = amount - 65000;

	}

	public void showhistory(Long accNum) {
		System.out.println(accNum + "--history");
	}

	public  void showMiniStatement(Long accNum) {
		System.out.println(accNum + "--ministatement");
		System.out.println("rebase  2 demo");
	}

	public  void showMiniStatement(Long accNum,String data) {
		System.out.println(accNum + "--ministatement with data " + data);
	}

	public void enterPin(Long pin) {
		System.out.println(pin);

	}

	//TODO
	/*Add methods for
	 * Credit
	 * debit
	 * view transactions
	 * show account details
	 *
	 * */
}
