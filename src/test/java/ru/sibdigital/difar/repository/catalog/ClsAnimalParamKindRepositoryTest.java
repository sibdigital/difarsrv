package ru.sibdigital.difar.repository.catalog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.catalog.breed.ClsAnimalParamKindEntity;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsAnimalParamKindRepositoryTest {

    @Autowired
    private ClsAnimalParamKindRepository clsAnimalParamKindRepository;

    @Test
    public void findByIdTest() {
        ClsAnimalParamKindEntity clsAnimalParamKindEntity = clsAnimalParamKindRepository.findById(1L).get();
        assertNotNull(clsAnimalParamKindEntity);
    }
}