package io.dojogeek.adminibot.views;

import java.util.List;

import io.dojogeek.adminibot.enums.TypePaymentMethodEnum;

public interface PaymentMethods {

    void showTypesPaymentMethods(List<TypePaymentMethodEnum> typePaymentMethodEnumList);
}