package sprint5.peoplepegistration.cafe.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import sprint5.peoplepegistration.cafe.model.payment.CreditCard;
import sprint5.peoplepegistration.cafe.service.PaymentService;
import sprint5.peoplepegistration.cep.model.entity.CepEntity;
import sprint5.peoplepegistration.configuration.exception.ApiNotFoundException;
import sprint5.peoplepegistration.people.model.entity.PersonEntity;
import sprint5.peoplepegistration.people.repository.PeopleRepository;
import sprint5.peoplepegistration.people.service.PeopleService;

import static reactor.core.publisher.Mono.just;

@RestController
@RequestMapping("/api/v1/payment")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final PeopleRepository peopleRepository;

    @GetMapping("/credito/")
    public Mono<String> verifyAndPayCreditCard(@RequestBody PersonEntity personEntity) {
        return paymentService.payAndVerifyCreditCard(personEntity);
    }

    @GetMapping("/debit/")
    public Mono<String> verifyAndPayDebitCard(@RequestBody PersonEntity personEntity) {
        return paymentService.payAndVerifyDebitCard(personEntity);
    }

    @GetMapping("/paypal/")
    public Mono<String> verifyAndPayPayPal(@RequestBody PersonEntity personEntity) {
        return paymentService.payAndVerifyPayPal(personEntity);
    }
}
