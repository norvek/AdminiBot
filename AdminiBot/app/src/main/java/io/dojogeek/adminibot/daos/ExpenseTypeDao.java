package io.dojogeek.adminibot.daos;

import java.util.List;

import io.dojogeek.adminibot.models.ExpenseTypeModel;

public interface ExpenseTypeDao extends ConnectionDao {

    long createExpenseType(ExpenseTypeModel expenseType);

    List<ExpenseTypeModel> getExpensesTypes();

    ExpenseTypeModel getExpenseTypeById(long id);

    long updateExpensetype(ExpenseTypeModel expenseTypeModel, String where);

    long deleteExpenseTypeById(long expenseTypeId);

}
