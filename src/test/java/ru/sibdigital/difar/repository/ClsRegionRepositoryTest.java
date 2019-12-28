package ru.sibdigital.difar.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.ClsRegionEntity;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsRegionRepositoryTest {

    @Autowired
    private ClsRegionRepository clsRegionRepository;

    @Test
    public void findByIdTest() {
        ClsRegionEntity clsRegionEntity = clsRegionRepository.findById(1L).get();
        assertNotNull(clsRegionEntity);
    }

}