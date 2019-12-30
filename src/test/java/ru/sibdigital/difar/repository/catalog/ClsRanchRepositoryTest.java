package ru.sibdigital.difar.repository.catalog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.catalog.ClsRanchEntity;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsRanchRepositoryTest {

    @Autowired
    private ClsRanchRepository clsRanchRepository;

    @Test
    public void findByIdTest() {
        ClsRanchEntity clsRanchEntity = clsRanchRepository.findById(1L).get();
        assertNotNull(clsRanchEntity);
    }
}