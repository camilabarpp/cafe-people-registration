package sprint5.peoplepegistration.people.service.facade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sprint5.peoplepegistration.people.model.entity.PersonEntity;
import sprint5.peoplepegistration.people.service.PeopleService;

@Component
@AllArgsConstructor
public class PeopleServiceFacade {

    private final PeopleService peopleService;

    public Flux<PersonEntity> findAll() {
        return peopleService.findAll();
    }

    public Mono<PersonEntity> findById(String id) {
        return peopleService.findById(id);
    }

    public Mono<PersonEntity> create(PersonEntity personEntity) {
        return peopleService.create(personEntity);
    }

    public Mono<Void> deleteById(String id) {
        return peopleService.deleteById(id);
    }

    public Mono<PersonEntity> update(String id, PersonEntity personEntity) {
        return peopleService.update(id, personEntity);
    }

    public Mono<Void> deleteAll() {
        return peopleService.deleteAll();
    }
}