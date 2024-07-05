package account;

import java.util.Map;

public class Account {
	
	private String accountNumber;
    private String accountHolderName;
    private Double deposits;
    private Double withDraw;
    private String statement;
    
    public Account(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
    
	public Double getDeposits() {
		return deposits;
	}

	public void setDeposits(Double deposits) {
		this.deposits = deposits;
	}

	public Double getWithDraw() {
		return withDraw;
	}

	public void setWithDraw(Double withDraw) {
		this.withDraw = withDraw;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}
	
	

}
