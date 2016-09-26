import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Администратор on 26.09.2016.
 */
public class Db {

    public static List<DbRow> getTransactions(long accountNumber) throws SQLException {
        return new ArrayList<>(Arrays.asList(new DbRow(accountNumber)));
    }
}
