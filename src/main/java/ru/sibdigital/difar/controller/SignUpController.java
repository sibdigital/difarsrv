package ru.sibdigital.difar.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.repository.classifier.accs.ClsUserRepository;
import ru.sibdigital.difar.repository.classifier.dict.ClsOrganizationRepository;
import ru.sibdigital.difar.repository.classifier.org.ClsEmployeeRepository;

@RestController
public class SignUpController {

    private ClsUserRepository userRepository;
    private ClsOrganizationRepository organizationRepository;
    private ClsEmployeeRepository employeeRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public SignUpController(ClsUserRepository userRepository,
                            ClsOrganizationRepository organizationRepository,
                            ClsEmployeeRepository employeeRepository,
                            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.organizationRepository = organizationRepository;
        this.employeeRepository = employeeRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ClsUserEntity user) {
        user.setClsOrganizationByIdOrganization(organizationRepository.findById(1L).get());
        user.setClsEmployeeByIdEmployee(employeeRepository.findById(1L).get());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setNumber("0");
        userRepository.save(user);
    }
}
