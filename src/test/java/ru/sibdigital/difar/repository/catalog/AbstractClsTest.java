package ru.sibdigital.difar.repository.catalog;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractClsTest {

    protected static long DEFAULT_ID = 1L;
    protected static long EMPTY_PARENT = 0L;
    protected static Integer MALE = 0;
    protected static Integer FEMALE = 1;

    @Autowired
    protected ClsUserRepository userRepository;
}