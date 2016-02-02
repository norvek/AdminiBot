package io.dojogeek.adminibot.daos;

import java.util.List;

import io.dojogeek.adminibot.models.TypePaymentMethodModel;

public interface TypesPaymentMethodsDao extends ConectionDao {

    List<TypePaymentMethodModel> getPaymentMethods();

    public long createPaymentMethod(TypePaymentMethodModel paymentMethod);

}