package com.br.docscsc.doc_section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("docSection")
public class DocSectionController {

    private final String notFoundMessage = "Documentation section not found: ";

    @Autowired
    private DocSectionRepository docSectionRepository;

    @GetMapping
    private List<DocSection> getDocSections() {
        return docSectionRepository.listOrderByPresentationSequence();
    }

    @GetMapping("/{id}")
    private DocSection getById(@PathVariable(name = "id") Long id) {
        return docSectionRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, notFoundMessage + id)
        );
    }

    @PostMapping
    private ResponseEntity<DocSection> saveDocSection(@RequestBody DocSection docSection) {
        if (docSection.getId() == null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(docSectionRepository.save(docSection));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(docSectionRepository.save(docSection));
        }
    }

    @DeleteMapping("/{id}")
    private void deleteDocSection(@PathVariable(name = "id") Long id) {
        DocSection ds = docSectionRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, notFoundMessage + id)
        );
        docSectionRepository.deleteById(id);
    }
}
