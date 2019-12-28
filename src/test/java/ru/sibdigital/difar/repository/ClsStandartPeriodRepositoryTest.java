package ru.sibdigital.difar.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.ClsResourceEntity;
import ru.sibdigital.difar.domain.ClsStandartPeriodEntity;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsStandartPeriodRepositoryTest {

    @Autowired
    private ClsStandartPeriodRepository clsStandartPeriodRepository;

    @Test
    public void findByIdTest() {
        ClsStandartPeriodEntity clsStandartPeriodEntity = clsStandartPeriodRepository.findById(1L).get();
        assertNotNull(clsStandartPeriodEntity);
    }

}