package com.br.docscsc.primary_section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("primarySection")
public class PrimarySectionController {

    private final String notFoundMessage = "Primary section not found: ";

    @Autowired
    private PrimarySectionRepository primarySectionRepository;

    @GetMapping
    private List<PrimarySection> getPrimarySections() {
        return primarySectionRepository.findAll();
    }

    @GetMapping("/{id}")
    private PrimarySection getById(@PathVariable(name = "id") Long id) {
        return primarySectionRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, notFoundMessage + id)
        );
    }

    @PostMapping
    private ResponseEntity<PrimarySection> savePrimarySection(@RequestBody PrimarySection primarySection) {
        if (primarySection.getId() == null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(primarySectionRepository.save(primarySection));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(primarySectionRepository.save(primarySection));
        }
    }

    @DeleteMapping("/{id}")
    private void deletePrimarySection(@PathVariable Long id) {
        PrimarySection ps = primarySectionRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, notFoundMessage + id)
        );
        primarySectionRepository.deleteById(id);
    }
}
