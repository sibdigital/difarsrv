package ru.sibdigital.difar.repository.classifier.base;

import org.springframework.beans.factory.annotation.Autowired;
import ru.sibdigital.difar.repository.classifier.accs.ClsUserRepository;
import ru.sibdigital.difar.repository.classifier.agrc.ClsCropRepository;
import ru.sibdigital.difar.repository.classifier.breed.ClsKindAnimalRepository;
import ru.sibdigital.difar.repository.classifier.dict.*;
import ru.sibdigital.difar.repository.classifier.org.ClsDepartRepository;
import ru.sibdigital.difar.repository.classifier.org.ClsEmployeeRepository;
import ru.sibdigital.difar.repository.classifier.org.ClsRanchRepository;

public abstract class ClsBaseTest {

    protected static long DEFAULT_ID = 1L;
    protected static long EMPTY_PARENT = 0L;
    protected static Integer MALE = 0;
    protected static Integer FEMALE = 1;
    protected static String DEFAULT_PASSWORD = "qwerty";

    @Autowired
    protected ClsUserRepository userRepository;

    @Autowired
    protected ClsOrganizationRepository organizationRepository;

    @Autowired
    protected ClsEmployeeRepository employeeRepository;

    @Autowired
    protected ClsCropRepository cropRepository;

    @Autowired
    protected ClsUnitRepository unitRepository;

    @Autowired
    protected ClsKindAnimalRepository kindAnimalRepository;

    @Autowired
    protected ClsRegionRepository regionRepository;

    @Autowired
    protected ClsStandardPeriodRepository standardPeriodRepository;

    @Autowired
    protected ClsDistrictRepository districtRepository;

    @Autowired
    protected ClsConsumableKindRepository consumableKindRepository;

    @Autowired
    protected ClsEquipmentTypeRepository equipmentTypeRepository;

    @Autowired
    protected ClsLegalEntityRepository legalEntityRepository;

    @Autowired
    protected ClsDepartRepository departRepository;

    @Autowired
    protected ClsRanchRepository ranchRepository;

}