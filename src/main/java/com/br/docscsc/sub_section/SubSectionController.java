package com.br.docscsc.sub_section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("subSection")
public class SubSectionController {

    private final String notFoundMessage = "Sub section not found: ";

    @Autowired
    private SubSectionRepository subSectionRepository;

    @Autowired
    private PersonSubSectionRepository personSubSectionRepository;

    @GetMapping
    private List<SubSection> getSubSections() {
        return subSectionRepository.findAll();
    }

    @GetMapping("/person")
    private List<PersonSubSection> getPersonSubSections() {
        return personSubSectionRepository.findAll();
    }

    @GetMapping("/{id}")
    private SubSection getById(@PathVariable(name = "id") Long id) {
        return subSectionRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, notFoundMessage + id)
        );
    }

    @GetMapping("/primarySection/{primarySectionId}")
    private List<SubSection> getByPrimarySectionId(@PathVariable Long primarySectionId) {
        return subSectionRepository.listByPrimarySec(primarySectionId);
    }

    @PostMapping
    private ResponseEntity<SubSection> saveSubSection(@RequestBody SubSection subSection) {
        if (subSection.getId() == null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(subSectionRepository.save(subSection));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(subSectionRepository.save(subSection));
        }
    }

    @DeleteMapping("/{id}")
    private void deleteSubSection(@PathVariable(name = "id") Long id) {
        SubSection sc = subSectionRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, notFoundMessage + id)
        );
        subSectionRepository.deleteById(id);
    }
}
