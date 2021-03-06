package io.dojogeek.adminibot.sqlite;

import android.provider.BaseColumns;

import io.dojogeek.adminibot.enums.CardTypeEnum;

import static io.dojogeek.adminibot.sqlite.SQLiteConstants.DROP_TABLE_IF_EXIST;

public class CardTypeContract {

    public static final CardTypeEnum [] CARD_TYPES = {CardTypeEnum.CREDIT_CARD,
            CardTypeEnum.DEBIT_CARD};

    public static abstract class CardType implements BaseColumns {

        public static final String TABLE_NAME = "card_types";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_NAME_NULLABLE = "null";

    }

    public static final String SQL_CREATE_TABLE = "CREATE TABLE " + CardType.TABLE_NAME +
            "(" + CardType._ID + " INTEGER PRIMARY KEY, " +
            CardType.COLUMN_NAME + " TEXT NOT NULL, " +
            CardType.COLUMN_DESCRIPTION + " TEXT NOT NULL)";

    public static final String SQL_INSERT_INITIAL_VALUES_1 = "INSERT INTO " + CardType.TABLE_NAME +
            " VALUES(" + CardType.COLUMN_NAME_NULLABLE + "," +
            "'" + CARD_TYPES[0].getCardType() + "'," +
            "'" + CARD_TYPES[0].getDescription() + "')";

    public static final String SQL_INSERT_INITIAL_VALUES_2 = "INSERT INTO " + CardType.TABLE_NAME +
            " VALUES(" + CardType.COLUMN_NAME_NULLABLE + "," +
            "'" + CARD_TYPES[1].getCardType() + "'," +
            "'" + CARD_TYPES[1].getDescription() + "')";

    public static final String SQL_DELETE_ENTRIES = DROP_TABLE_IF_EXIST + CardType.TABLE_NAME;

}
