import java.sql.SQLException;

/**
 * Created by Администратор on 26.09.2016.
 */
public class DbRow {

    private long account;

           	public DbRow(long account) throws SQLException {
        		if(account > 1_000_000)
            			throw new SQLException();
        		this.account = account;
        	}

            	public String getValueForField(String string) throws SQLException {
        		if(string.equals("amt")) {
            			return Long.toString(account);
            		}
        		else if(string.equals("desc")) return string;
        		else throw new SQLException();
        	}
}
