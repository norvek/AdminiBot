package io.dojogeek.adminibot.daos;

import java.util.List;

import io.dojogeek.adminibot.models.ExpenseModel;

public interface ExpenseDao extends ConectionDao {

    long createExpense(ExpenseModel expenseModel);

    List<ExpenseModel> getExpenses();

}
