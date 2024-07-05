package glue;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;


import java.util.Map;

import account.Account;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountSteps {

    Account account = null;
    
    private Map<String, Double> deposits;
    private Map<String, Double> withdrawals;
    private String statement;

    @Given("^Account exists for Acc No\\. \"([^\"]*)\" with Name \"([^\"]*)\"$")
    public void accountExistsForAccNoWithName(String number, String name) {
    	account = new Account(number,name);
    }
    
    @Given("deposits are made")
    public void deposits_are_made(io.cucumber.datatable.DataTable dataTable) {
    	Double tol = 0.0;
    	this.deposits = dataTable.asMap(String.class, Double.class);
    	 for (Map.Entry<String, Double> entry : deposits.entrySet()) {
    		 tol = tol + entry.getValue();
         }
    	 System.out.println("Total"+tol);
    	 account.setDeposits(tol);
    }

    @Given("withdrawls are made")
    public void withdrawls_are_made(io.cucumber.datatable.DataTable dataTable) {
    	Double withdraw = 0.0;
    	this.withdrawals = dataTable.asMap(String.class, Double.class);
    	for (Map.Entry<String, Double> entry : withdrawals.entrySet()) {
    		withdraw = withdraw + entry.getValue();
        }
    	 System.out.println("withdraw"+withdraw);
    	 account.setWithDraw(withdraw);
    }

    @When("statement is produced")
    public void statement_is_produced() {
    	StringBuilder sb = new StringBuilder();
        
    	sb.append("Statement:");
        sb.append("Name: ").append(account.getAccountHolderName()).append("\n");
        sb.append("Account: ").append(account.getAccountNumber()).append("\n");
        sb.append("Transactions:\n");

        sb.append("Deposits:\n");
        for (Map.Entry<String, Double> entry : deposits.entrySet()) {
        	sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        sb.append("Withdrawals:\n");
        for (Map.Entry<String, Double> entry : withdrawals.entrySet()) {
        	sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        
        sb.append("Balance: ").append(String.format("%.2f",(account.getDeposits() - account.getWithDraw())));
        
        this.statement = sb.toString();
        
        account.setStatement(this.statement);
        System.out.println("Statement"+this.statement);
    }

    @Then("statement includes {string}")
    public void statement_includes(String accountName) {
    	assertTrue(account.getStatement().contains(accountName));
    }


}
