package sprint5.peoplepegistration.cafe.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import sprint5.peoplepegistration.cafe.controller.facade.PaymentControllerFacade;
import sprint5.peoplepegistration.people.model.entity.PersonEntity;

@RestController
@RequestMapping("/api/v1/payment")
@AllArgsConstructor
public class PaymentController {
    private final PaymentControllerFacade paymentControllerFacade;

    @GetMapping("/credit/")
    public Flux<String> verifyAndPayCreditCard(@RequestBody PersonEntity personEntity) {
        return paymentControllerFacade.verifyAndPayCreditCard(personEntity);
    }
    @GetMapping("/debit/")
    public Flux<String> verifyAndPayDebitCard(@RequestBody PersonEntity personEntity) {
        return paymentControllerFacade.verifyAndPayDebitCard(personEntity);
    }
    @GetMapping("/paypal/")
    public Flux<String> verifyAndPayPayPal(@RequestBody PersonEntity personEntity) {
        return paymentControllerFacade.verifyAndPayPayPal(personEntity);
    }
}
