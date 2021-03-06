package io.dojogeek.adminibot.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class AdminiBotSQLiteOpenHelperTest {

    private static final int NONE_TABLE_CREATED = 0;

    private Context mContext;
    private SQLiteDatabase mSQLiteDatabase;
    private AdminiBotSQLiteOpenHelper mAdminiBotSQLiteOpenHelper;

    @Before
    public void setup() {

        mContext = getTargetContext();

        loadSQLiteHelper();

        mSQLiteDatabase = openDataBaseConnection();
    }

    @After
    public void tearDown() {
        closeDataBaseConnection();
        deleteDataBase();
    }

    @Test
    public void testSingleton_isTheSameInstance() {

        AdminiBotSQLiteOpenHelper expectedAdminiBotSQLiteOpenHelper = AdminiBotSQLiteOpenHelper.getInstance(mContext);

        assertEquals(expectedAdminiBotSQLiteOpenHelper, mAdminiBotSQLiteOpenHelper);
    }

    @Test
    public void testDBCreation_itAlreadyExist() {

        File db = mContext.getDatabasePath(AdminiBotSQLiteOpenHelper.DATABASE_NAME);

        assertTrue(db.exists());
    }

    @Test
    public void testDBVersion_correctVersion() {

        int version = mSQLiteDatabase.getVersion();

        assertEquals(AdminiBotSQLiteOpenHelper.DATABASE_VERSION, version);
    }

    @Test
    public void testTablesCreation_correctCreations() {

        String[] tables = {ExpensesContract.Expense.TABLE_NAME,
                ExpensesOthersPaymentMethodsContract.ExpenseOtherPaymentMethod.TABLE_NAME,
                ExpensesTypesContract.ExpenseType.TABLE_NAME, IncomesContract.Incomes.TABLE_NAME,
                PaymentMethodsContract.PaymentMethod.TABLE_NAME,
                TrademarkContract.Trademark.TABLE_NAME, UsersContract.User.TABLE_NAME,
                IncomesPaymentMethodsContract.IncomePaymentMethod.TABLE_NAME, BankCardsContract.BankCard.TABLE_NAME,
                IncomesBankCardsContract.IncomesBankCards.TABLE_NAME, ExpensesBankCardsContract.ExpensesBankCard.TABLE_NAME,
                BanksContract.Bank.TABLE_NAME, CardDetailContract.CardDetail.TABLE_NAME};

        for (String table : tables) {
            Cursor cursor = selectTable(table);
            assertNotNull(cursor);
            assertNotEquals(NONE_TABLE_CREATED, cursor.getCount());
        }
    }

    @Test
    public void testInitialInsertions_correctBankInsertions() {

        int numberOfInsertions = 12;

        Cursor cursor = mSQLiteDatabase.rawQuery("SELECT * FROM banks", null);

        assertEquals(numberOfInsertions, cursor.getCount());
    }

    @Test
    public void testInitialInsertions_correctTrademarksInsertions() {

        int numberOfInsertions = 3;

        Cursor cursor = mSQLiteDatabase.rawQuery("SELECT * FROM trademarks", null);

        assertEquals(numberOfInsertions, cursor.getCount());
    }

    @Test
    public void testInitialInsertions_correctExpensesTypesInsertions() {

        int numberOfInsertions = 5;

        Cursor cursor = mSQLiteDatabase.rawQuery("SELECT * FROM expenses_types", null);

        assertEquals(numberOfInsertions, cursor.getCount());
    }

    public void closeDataBaseConnection() {
        mAdminiBotSQLiteOpenHelper.close();
    }

    public SQLiteDatabase openDataBaseConnection() {
        return mAdminiBotSQLiteOpenHelper.getReadableDatabase();
    }

    public void deleteDataBase() {
        mContext.deleteDatabase(AdminiBotSQLiteOpenHelper.DATABASE_NAME);
    }

    private Cursor selectTable(String tableName) {
        String query = "select DISTINCT tbl_name from sqlite_master where tbl_name = '" + tableName +
                "'";
        return mSQLiteDatabase.rawQuery(query, null);
    }

    private void loadSQLiteHelper() {
        mAdminiBotSQLiteOpenHelper = AdminiBotSQLiteOpenHelper.getInstance(mContext);
    }
}
