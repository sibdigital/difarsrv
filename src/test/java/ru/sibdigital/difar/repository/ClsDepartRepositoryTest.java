package ru.sibdigital.difar.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.ClsDepartEntity;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsDepartRepositoryTest {

    @Autowired
    private ClsDepartRepository clsDepartRepository;

    @Test
    public void findByIdTest() {
        ClsDepartEntity clsDepartEntity = clsDepartRepository.findById(1L).get();
        assertNotNull(clsDepartEntity);
    }
}