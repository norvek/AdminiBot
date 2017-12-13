package dagger;

import io.dojogeek.adminibot.views.AddPaymentMethodActivity;
import io.dojogeek.adminibot.views.CardCreationActivity;
import io.dojogeek.adminibot.views.CheckActivity;
import io.dojogeek.adminibot.views.CreditCardActivity;
import io.dojogeek.adminibot.views.CreditCardDetailActivity;
import io.dojogeek.adminibot.views.FoodCouponsActivity;
import io.dojogeek.adminibot.views.InboxFragment;
import io.dojogeek.adminibot.views.LoginActivity;
import io.dojogeek.adminibot.views.MyCashActivity;
import io.dojogeek.adminibot.views.MyCreditCardsActivity;
import io.dojogeek.adminibot.views.MyFoodCouponsActivity;
import io.dojogeek.adminibot.views.PaymentMethodsActivity;
import io.dojogeek.adminibot.views.RegisterExpenseActivity;
import io.dojogeek.adminibot.views.RegisterUserActivity;

@AdminBotScope
@Subcomponent(modules = {AdminiBotModule.class})
public interface AdminiBotComponent {

    void inject(RegisterUserActivity activity);

    void inject(LoginActivity activity);

    void inject(InboxFragment fragment);

    void inject(RegisterExpenseActivity activity);

    void inject(PaymentMethodsActivity activity);

    void inject(AddPaymentMethodActivity activity);

    void inject(CardCreationActivity activity);

    void inject(CreditCardActivity activity);

    void inject(CheckActivity activity);

    void inject(FoodCouponsActivity activity);

    void inject(MyCreditCardsActivity activity);

    void inject(CreditCardDetailActivity activity);

    void inject(MyCashActivity activity);

    void inject(MyFoodCouponsActivity activity);
}