package ru.sibdigital.difar.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.ClsCropEntity;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsCropVarietyRepositoryTest {

    @Autowired
    private ClsCropRepository clsCropRepository;

    @Test
    public void findById() {
        ClsCropEntity clsCropEntity = clsCropRepository.findById(1L).get();
        assertNotNull(clsCropEntity);
    }
}