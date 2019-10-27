package pl.jnowacki;

public class PeopleService {

    private PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Person getOnePerson (){
        return peopleRepository.findOne();
    }

    public PeopleRepository getPeopleRepository() {
        return peopleRepository;
    }

    public void setPeopleRepository(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
}
