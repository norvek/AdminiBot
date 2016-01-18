package io.dojogeek.adminibot.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;

import io.dojogeek.adminibot.models.ExpenseTypeModel;
import sqlite.AdminiBotSQLiteOpenHelper;
import sqlite.ExpenseTypeContract;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class AdminiBotSQLiteOpenHelperTest {

    private AdminiBotSQLiteOpenHelper mAdminiBotSQLiteOpenHelper;

    @Before
    public void setUp() {

        Context context = getTargetContext();

        context.deleteDatabase(AdminiBotSQLiteOpenHelper.DATABASE_NAME);

        mAdminiBotSQLiteOpenHelper = AdminiBotSQLiteOpenHelper.getInstance(context);
    }

    @After
    public void tearDown() throws Exception {
        mAdminiBotSQLiteOpenHelper.close();
    }

    @Test
    public void sqliteHelper_expensesTypesInserted_isEquals() {

        final int insertedValues = 5;

        SQLiteDatabase database = mAdminiBotSQLiteOpenHelper.getReadableDatabase();
        Cursor cursor = database.query(ExpenseTypeContract.ExpenseType.TABLE_NAME, null, null, null, null, null, null);

        assertEquals(cursor.getCount(), insertedValues);

    }

}
