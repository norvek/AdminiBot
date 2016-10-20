package io.dojogeek.adminibot.factory;

import java.util.ArrayList;
import java.util.List;

import io.dojogeek.adminibot.adapters.dtos.DtoCreditCardAdapter;
import io.dojogeek.adminibot.enums.TypePaymentMethodEnum;
import io.dojogeek.adminibot.models.BankCardModel;
import io.dojogeek.adminibot.models.BankModel;
import io.dojogeek.adminibot.models.CashModel;
import io.dojogeek.adminibot.models.CreditCardModel;
import io.dojogeek.adminibot.models.ExpenseBankCardModel;
import io.dojogeek.adminibot.models.ExpenseModel;
import io.dojogeek.adminibot.models.ExpenseOtherPaymentMethodModel;
import io.dojogeek.adminibot.models.OtherPaymentMethodModel;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class ModelsFactory {

    private static PodamFactory factory = new PodamFactoryImpl();

    public static ExpenseOtherPaymentMethodModel createExpenseOtherPaymentMethodModel() {

        ExpenseOtherPaymentMethodModel expenseOtherPaymentMethodModel =
                factory.manufacturePojo(ExpenseOtherPaymentMethodModel.class);

        return expenseOtherPaymentMethodModel;
    }

    public static ExpenseModel createExpenseModel() {

        ExpenseModel expenseModel = factory.manufacturePojo(ExpenseModel.class);

        return expenseModel;
    }

    public static ExpenseBankCardModel createExpenseBankCardModel() {

        ExpenseBankCardModel expenseBankCardModel = factory.manufacturePojo(ExpenseBankCardModel.class);

        return expenseBankCardModel;
    }

    public static OtherPaymentMethodModel createOtherPaymentMethodModel() {

        OtherPaymentMethodModel otherPaymentMethodModel =
                factory.manufacturePojo(OtherPaymentMethodModel.class);

        return otherPaymentMethodModel;
    }

    public static BankCardModel createBankCardModel() {

        BankCardModel bankCardModel = factory.manufacturePojo(BankCardModel.class);

        return bankCardModel;
    }

    public static List<TypePaymentMethodEnum> createTypePaymentMethodEnumList() {

        List<TypePaymentMethodEnum> typePaymentMethodEnumList = new ArrayList<>();
        typePaymentMethodEnumList.add(TypePaymentMethodEnum.CARD);
        typePaymentMethodEnumList.add(TypePaymentMethodEnum.CASH);
        typePaymentMethodEnumList.add(TypePaymentMethodEnum.FOOD_COUPONS);

        return typePaymentMethodEnumList;
    }

    public static CreditCardModel createCreditCardModel() {
        CreditCardModel creditCardModel =
                factory.manufacturePojo(CreditCardModel.class);

        return creditCardModel;
    }

    public static BankModel createBankModel() {
        return factory.manufacturePojo(BankModel.class);
    }

    public static DtoCreditCardAdapter createDtoCreditCardAdapter() {
        return factory.manufacturePojo(DtoCreditCardAdapter.class);
    }

}
