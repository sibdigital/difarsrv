package ru.sibdigital.difar.controller;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.catalog.accs.ClsUserEntity;
import ru.sibdigital.difar.repository.catalog.ClsUserRepository;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class ClsUserController {

    private ClsUserRepository clsUserRepository;

    public ClsUserController(ClsUserRepository clsUserRepository) {
        this.clsUserRepository = clsUserRepository;
    }

    @PostMapping("/create")
    public void create(@RequestBody ClsUserEntity user) {
        clsUserRepository.save(user);
    }

    @GetMapping("/{id}")
    public ClsUserEntity read(@PathVariable long id) {
        Optional<ClsUserEntity> userOptional = clsUserRepository.findById(id);

        return userOptional.orElse(null);
    }

    @PutMapping("/{id}")
    public void updateName(@PathVariable long id, @RequestBody Map<String, Object> body) {
        Optional<ClsUserEntity> userOptional = clsUserRepository.findById(id);

        if (userOptional.isPresent()) {
            ClsUserEntity userFromDB = userOptional.get();
            userFromDB.setName((String) body.get("name"));

            clsUserRepository.save(userFromDB);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        Optional<ClsUserEntity> userOptional = clsUserRepository.findById(id);
        userOptional.ifPresent(clsUserEntity -> clsUserRepository.delete(clsUserEntity));
    }

}
