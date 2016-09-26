import java.math.BigDecimal;

/**
 * Created by Администратор on 26.09.2016.
 */
public class Transaction {

    private String description;
    	private BigDecimal currencyAmountInPounds;

            	public Transaction(String description, BigDecimal currencyAmountInPounds) {
        		this.description = description;
        		this.currencyAmountInPounds = currencyAmountInPounds;
        	}

            	public String getDescription() {
        		return description;
        	}

            	public BigDecimal getCurrencyAmountInPounds() {
        		return currencyAmountInPounds;
        	}

            	@Override
    	public int hashCode() {
        		final int prime = 31;
        		int result = 1;
        		result = prime * result + ((currencyAmountInPounds == null) ? 0 : currencyAmountInPounds.hashCode());
        		result = prime * result + ((description == null) ? 0 : description.hashCode());
        		return result;
        	}

            	@Override
    	public boolean equals(Object obj) {
        		if (this == obj) return true;
        		if (obj == null)	return false;
        		if (getClass() != obj.getClass())	return false;
        		Transaction other = (Transaction) obj;
        		if (currencyAmountInPounds == null) {
            			if (other.currencyAmountInPounds != null)
                				return false;
            		} else if (!currencyAmountInPounds.equals(other.currencyAmountInPounds))
            			return false;
        		if (description == null) {
            			if (other.description != null)
                				return false;
            		} else if (!description.equals(other.description))
            			return false;
        		return true;
        	}

            	@Override
    	public String toString() {
        		return "Transaction [description=" + description + ", currencyAmountInPounds=" + currencyAmountInPounds + "]";
        	}
}
