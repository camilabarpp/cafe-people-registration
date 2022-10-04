package sprint5.peoplepegistration.people.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sprint5.peoplepegistration.cep.service.CepService;
import sprint5.peoplepegistration.configuration.webClient.cep.IntegrationCepClient;
import sprint5.peoplepegistration.people.model.entity.PersonEntity;
import sprint5.peoplepegistration.people.model.mapper.PersonMapper;
import sprint5.peoplepegistration.people.model.request.PersonRequest;
import sprint5.peoplepegistration.people.model.response.PersonResponse;
import sprint5.peoplepegistration.people.service.PeopleService;

import java.util.concurrent.ExecutionException;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static sprint5.peoplepegistration.people.model.mapper.PersonMapper.*;

@RestController
@RequestMapping("/api/v1/registration")
@AllArgsConstructor
public class Peoplecontroller {

    private final PeopleService peopleService;
    private final CepService integration;

    @GetMapping
    public Flux<PersonResponse> findAll() {
        return peopleService.findAll()
                .map(PersonMapper::pessoaResponse);
    }

    @GetMapping("/{id}")
    public Mono<PersonResponse> findById(@PathVariable String id) {
        return peopleService.findById(id)
                .map(PersonMapper::pessoaResponse);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Mono<PersonResponse> create(@RequestBody PersonRequest personRequest) {
        return peopleService.create(requestPessoa(personRequest))
                .map(PersonMapper::pessoaResponse);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public Mono<Void> deleteById(@PathVariable String id) {
       return peopleService.deleteById(id);
    }

    @DeleteMapping
    @ResponseStatus(NO_CONTENT)
    public Mono<Void> deleteAll() {
        return peopleService.deleteAll();
    }
}
