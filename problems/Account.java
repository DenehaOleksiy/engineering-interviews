/*

This class was written by a very junior Java engineer. 

There are at least 10 things wrong with this class. 

We would like you identify all 10 things that are wrong and
refactor the class below into Java 8 compatible code.

Please *EXPLAIN* clearly *WHAT* you are changing.

You will be graded based on CLEAR EXPLANATIONS, not just 
refactoring.

*/

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Account {

    //так як accountNumber є числовий тип то змінюємо на long.
    private long accountNumber;

    //бажано зберігати імена змінних DB як static.
           	private static final String  AMOUNT_IN_POUNDS = "amt";
    	    private static final String DESCRIPTION = "desc";
    
    public Account(long accountNumber){
        //перевіряємо чи accountNumber > 0
        	if(accountNumber > 0)
            			this.accountNumber = accountNumber;
        		else
            //інакше кидаємо ексепшен
       			throw new IllegalArgumentException("Account Number is not valid");
    }


    public long getAccountNumber(){
        return accountNumber; // return the account number
    }
         //для гнучкості класу робимо повертаєме значення interface
    	//для безпеки типів вводимо дженерік Transaction
    public List<Transaction> getTransactions() throws TransactionException {
        try {
            //тут теж вводимо дженерік
            List<DbRow> dbTransactionList = Db.getTransactions(accountNumber);
            List<Transaction> transactionList = new ArrayList<>();

            for (DbRow row : dbTransactionList) {
                Transaction trans = makeTransactionFromDbRow(row);
                transactionList.add(trans);
            }

            return transactionList;

        } catch (SQLException ex) {
            //так як просто Exception є не інформативним
            //для конкретизації створюємо і кидаємо свій ексепшен
            throw new TransactionException("Can't retrieve transactions from the database");
        }
    }

         //якщо ми не використовуємо метод то можна зробити його private
    	 private Transaction makeTransactionFromDbRow(DbRow row) throws SQLException {
        		String amountInPounds = row.getValueForField(AMOUNT_IN_POUNDS);
        		String description = row.getValueForField(DESCRIPTION);
        		//так як ми працюємо з грошима
                //то робимо тип BigDecimal, як найбільш точний
                 BigDecimal currencyAmountInPounds = new BigDecimal(amountInPounds);
        		return new Transaction(description, currencyAmountInPounds);
        	}

     	//при override метода equals тип аргумента має бути object.
    public boolean equals(Object o) {
        //перевіряємо чи дійсно є class Account.
                		if (o instanceof Account) {
                            //приводимо тип до Account
            			Account account = (Account) o;
           				return this.accountNumber == account.getAccountNumber();
            		}
       		return false;
        	}



}
