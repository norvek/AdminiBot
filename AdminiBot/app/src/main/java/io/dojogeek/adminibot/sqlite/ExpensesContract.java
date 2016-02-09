package io.dojogeek.adminibot.sqlite;

import android.provider.BaseColumns;

import static io.dojogeek.adminibot.sqlite.SQLiteConstants.COMMA_SEP;
import static io.dojogeek.adminibot.sqlite.SQLiteConstants.DOUBLE;
import static io.dojogeek.adminibot.sqlite.SQLiteConstants.TEXT_TYPE;
import static io.dojogeek.adminibot.sqlite.SQLiteConstants.PRIMARY_KEY;
import static io.dojogeek.adminibot.sqlite.SQLiteConstants.INTEGER;
import static io.dojogeek.adminibot.sqlite.SQLiteConstants.CREATE_TABLE;
import static io.dojogeek.adminibot.sqlite.SQLiteConstants.OPEN_PARENTHESIS;
import static io.dojogeek.adminibot.sqlite.SQLiteConstants.CLOSE_PARENTHESIS;
import static io.dojogeek.adminibot.sqlite.SQLiteConstants.DROP_TABLE_IF_EXIST;

public class ExpensesContract {

    public static abstract class Expense implements BaseColumns {

        public static final String TABLE_NAME = "expenses";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_AMOUNT = "amount";
        public static final String COLUMN_DATE_EXPEDITURE = "date_expediture";
        public static final String COLUMN_NEXT_EXIT = "next_exit";
        public static final String COLUMN_EXPENSES_TYPE_ID = "expenses_type_id";
        public static final String COLUMN_USER_ID = "user_id";
        public static final String COLUMN_NAME_NULLABLE = "null";

    }

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " +  Expense.TABLE_NAME +
            "(" + Expense._ID + " INTEGER PRIMARY KEY, " +
            Expense.COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
            Expense.COLUMN_AMOUNT + " REAL NOT NULL, " +
            Expense.COLUMN_DATE_EXPEDITURE + " TEXT NOT NULL, " +
            Expense.COLUMN_NEXT_EXIT + " TEXT NOT NULL, " +
            Expense.COLUMN_EXPENSES_TYPE_ID + " INTEGER NOT NULL, " +
            Expense.COLUMN_USER_ID + " INTEGER NOT NULL)";


    public static final String SQL_DELETE_ENTRIES = DROP_TABLE_IF_EXIST + Expense.TABLE_NAME;

}