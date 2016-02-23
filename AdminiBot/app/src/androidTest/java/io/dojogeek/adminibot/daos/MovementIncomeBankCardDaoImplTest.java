package io.dojogeek.adminibot.daos;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.dojogeek.adminibot.exceptions.DataException;
import io.dojogeek.adminibot.models.MovementIncomeBankCardModel;
import io.dojogeek.adminibot.sqlite.AdminiBotSQLiteOpenHelper;
import io.dojogeek.adminibot.utiltest.CreatorModels;

import static android.support.test.InstrumentationRegistry.getTargetContext;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(AndroidJUnit4.class)
public class MovementIncomeBankCardDaoImplTest {

    private static final long SUCCESS_OPERATION = 1;
    private static final long OPERATIONAL_ERROR = -1;
    private static final long NO_OPERATION = 0;

    private Context mContext;
    private MovementIncomeBankCardDao mMovementIncomeBankCardDao;

    @Before
    public void setup() {
        mContext = getTargetContext();
        mMovementIncomeBankCardDao = new MovementIncomeBankCardDaoImpl(mContext);
        mMovementIncomeBankCardDao.openConection();
    }

    @After
    public void finishTest() {
        mMovementIncomeBankCardDao.closeConection();
        mContext.deleteDatabase(AdminiBotSQLiteOpenHelper.DATABASE_NAME);
    }

    @Test
    public void movementIncomeBankCardDao_creationMovementIncomeBankCard_isTrue() {

        MovementIncomeBankCardModel movementIncomeBankCard = CreatorModels.createMovementIncomeBankCardModel();

        long insertedRecordId = mMovementIncomeBankCardDao.createMovementIncomeBankCard(movementIncomeBankCard);

        assertThat(insertedRecordId, is(not(NO_OPERATION)));
        assertThat(insertedRecordId, is(not(OPERATIONAL_ERROR)));
    }

    @Test(expected = NullPointerException.class)
    public void movementIncomeBankCarddao_creationMovementIncomeBankCardWithNullModel_isFalse() {

        mMovementIncomeBankCardDao.createMovementIncomeBankCard(null);

    }

    @Test
    public void movementIncomeBankCarddao_creationMovementIncomeBankCardWithNullRequiredField_isFalse() {

        MovementIncomeBankCardModel movementIncomeBankCardModel = CreatorModels.createMovementIncomeBankCardModel();
        movementIncomeBankCardModel.description = null;

        long insertedRecordId = mMovementIncomeBankCardDao.createMovementIncomeBankCard(movementIncomeBankCardModel);

        assertThat(insertedRecordId, is(OPERATIONAL_ERROR));
    }

    @Test
    public void movementIncomeBankCarddao_creationAndObtainingMovementIncomeBankCardById_isTrue() throws DataException {

        MovementIncomeBankCardModel expectedMovementIncomeBankCardModel = CreatorModels.createMovementIncomeBankCardModel();

        long insertedRecordId = mMovementIncomeBankCardDao.createMovementIncomeBankCard(expectedMovementIncomeBankCardModel);

        MovementIncomeBankCardModel actualMovementIncomeBankCardModel =
                mMovementIncomeBankCardDao.getMovementIncomeBankCardById(insertedRecordId);

        assertThat(actualMovementIncomeBankCardModel, is(notNullValue()));
        assertThat(actualMovementIncomeBankCardModel.amount, is(expectedMovementIncomeBankCardModel.amount));
        assertThat(actualMovementIncomeBankCardModel.bankCardId, is(expectedMovementIncomeBankCardModel.bankCardId));
        assertThat(actualMovementIncomeBankCardModel.date, is(expectedMovementIncomeBankCardModel.date));
        assertThat(actualMovementIncomeBankCardModel.description, is(expectedMovementIncomeBankCardModel.description));
        assertThat(actualMovementIncomeBankCardModel.incomeId, is(expectedMovementIncomeBankCardModel.incomeId));
    }
}
