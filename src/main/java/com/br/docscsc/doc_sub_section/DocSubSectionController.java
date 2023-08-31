package com.br.docscsc.doc_sub_section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("docSubSection")
public class DocSubSectionController {

    private final String notFoundMessage = "Doc. Sub Section not found: ";

    @Autowired
    private DocSubSectionRepository docSubSecRepository;

    @GetMapping
    private List<DocSubSection> getDocSubSections() {
        return docSubSecRepository.findAll();
    }

    @GetMapping("/{id}")
    private DocSubSection getById(@PathVariable(name = "id") Long id) {
        return docSubSecRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, notFoundMessage + id)
        );
    }

    @PostMapping
    private ResponseEntity<DocSubSection> saveDocSubSection(@RequestBody DocSubSection docSubSection) {
        if (docSubSection.getId() == null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(docSubSecRepository.save(docSubSection));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(docSubSecRepository.save(docSubSection));
        }
    }

    @DeleteMapping("/{id}")
    private void deleteSubSection(@PathVariable(name = "id") Long id) {
        DocSubSection dss = docSubSecRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, notFoundMessage + id)
        );
        docSubSecRepository.deleteById(id);
    }
}
