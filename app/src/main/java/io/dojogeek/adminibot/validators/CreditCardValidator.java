package io.dojogeek.adminibot.validators;

public class CreditCardValidator extends Validator {

    private static String CARD_NAME = "cardName";
    private static String CARD_NUMBER = "cardNumber";
    private static String CREDIT_CARD_BRAND = "creditCardBrand";
    private static String BANK = "bank";
    private static String CREDIT_LIMIT = "creditLimit";
    private static String CURRENT_BALANCE = "currentBalance";
    private static String CUTTOFF_DATE = "cuttofDatte";
    private static String PAYDAY_LIMIT = "paydayLimit";

    public void setCardName(String cardName) {
        dataToValidate.put(CARD_NAME, cardName);
    }

    public void setCardNumber(String cardNumber) {
        dataToValidate.put(CARD_NUMBER, cardNumber);
    }

    public void setCreditCardBrand(String creditCardBrand) {
        dataToValidate.put(CREDIT_CARD_BRAND, creditCardBrand);
    }

    public void setBank(String bank) {
        dataToValidate.put(BANK, bank);
    }

    public void setCreditLimit(String creditLimit) {
        dataToValidate.put(CREDIT_LIMIT, creditLimit);
    }

    public void setCurrentBalance(String currentBalance) {
        dataToValidate.put(CURRENT_BALANCE, currentBalance);
    }

    public void setCuttoffDate(String cuttoffDate) {
        dataToValidate.put(CUTTOFF_DATE, cuttoffDate);
    }

    public void setPaydayLimit(String paydayLimit) {
        dataToValidate.put(PAYDAY_LIMIT, paydayLimit);
    }

    public boolean isValidCardName() {
        return this.isValid(CARD_NAME);
    }

    public boolean isValidCardNumber() {
        return this.isValid(CARD_NUMBER);
    }

    public boolean isValidCardBrand() {
        return this.isValid(CREDIT_CARD_BRAND);
    }

    public boolean isValidCardBank() {
        return this.isValid(BANK);
    }

    public boolean isValidCreditLimit() {
        return this.isValid(CREDIT_LIMIT);
    }

    public boolean isValidCurrentBalance() {
        return this.isValid(CURRENT_BALANCE);
    }

    public boolean isValidCuttoffDate() {
        return this.isValid(CUTTOFF_DATE);
    }

    public boolean isValidPayDayLimit() {
        return this.isValid(PAYDAY_LIMIT);
    }

    public int getCardNameError() {
        return errorMessages.get(CARD_NAME);
    }

    public int getCardNumberError() {
        return errorMessages.get(CARD_NUMBER);
    }

    public int getCreditCardBrandError() {
        return errorMessages.get(CREDIT_CARD_BRAND);
    }

    public int getBankError() {
        return errorMessages.get(BANK);
    }

    public int getCreditLimitError() {
        return errorMessages.get(CREDIT_LIMIT);
    }

    public int getCurrentBalanceError() {
        return errorMessages.get(CURRENT_BALANCE);
    }

    public int getCuttoffDateError() {
        return errorMessages.get(CUTTOFF_DATE);
    }

    public int getPayDayLimitError() {
        return errorMessages.get(PAYDAY_LIMIT);
    }

    @Override
    protected void configureValidations() {

        validations.put(CARD_NAME, CompoundValidatorsFactory.cashConceptValidator());
        validations.put(CARD_NUMBER, CompoundValidatorsFactory.cardNumberValidator());
        validations.put(CREDIT_CARD_BRAND, CompoundValidatorsFactory.requiredValueValidator);
        validations.put(BANK, CompoundValidatorsFactory.requiredValueValidator);
        validations.put(CREDIT_LIMIT, CompoundValidatorsFactory.checkAmountValidator());
        validations.put(CURRENT_BALANCE, CompoundValidatorsFactory.checkAmountValidator());
        validations.put(CUTTOFF_DATE, CompoundValidatorsFactory.requiredValueValidator);
        validations.put(PAYDAY_LIMIT, CompoundValidatorsFactory.requiredValueValidator);
    }
}