package ru.sibdigital.difar.repository.classifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.breed.ClsBreedEntity;
import ru.sibdigital.difar.repository.classifier.breed.ClsBreedRepository;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsBreedRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsBreedRepository clsBreedRepository;

    @Test
    public void findByIdTest() {
        ClsBreedEntity clsBreedEntity = clsBreedRepository.findById(1L).get();
        assertNotNull(clsBreedEntity);
    }

}