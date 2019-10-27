package pl.jnowacki;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock
    private PeopleRepository peopleRepository;

    @InjectMocks
    private PeopleService peopleService;

    @Test
    public void testMock() {
        when(peopleRepository.findOne()).thenReturn(new Person(23));

        Person person = peopleService.getOnePerson();

        assertEquals(person.getAge(), 23);
    }
}
