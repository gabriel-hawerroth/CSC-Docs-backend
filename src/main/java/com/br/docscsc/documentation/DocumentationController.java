package com.br.docscsc.documentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("documentation")
public class DocumentationController {

    private final String notFoundMessage = "Documentation not found: ";

    @Autowired
    private DocumentationRepository documentationRepository;

    @Autowired
    private PersonDocumentationRepository personDocumentationRepository;

    @GetMapping
    private List<Documentation> getDocumentations() {
        return documentationRepository.findAll();
    };

    @GetMapping("/person")
    private List<PersonDocumentation> getPersonDocs() {
        return personDocumentationRepository.findAll();
    }

    @GetMapping("/{id}")
    private Documentation getById(@PathVariable Long id) {
        return documentationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, notFoundMessage + id)
        );
    }

    @GetMapping("/search")
    private List<Documentation> searchInDocs(@RequestParam String title) {
        return documentationRepository.findByTitleContaining(title);
    }

    @GetMapping("/bySubSec/{subSectionId}")
    private List<Documentation> getBySubSection(@PathVariable Long subSectionId) {
        return documentationRepository.findBySubSectionId(subSectionId);
    }

    @PostMapping
    private ResponseEntity<Documentation> saveDocumentation(@RequestBody Documentation documentation) {
        if (documentation.getId() == null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(documentationRepository.save(documentation));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(documentationRepository.save(documentation));
        }
    }

    @DeleteMapping("/{id}")
    private void deleteDocumentation(@PathVariable Long id) {
        Documentation doc = documentationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, notFoundMessage + id)
        );
        documentationRepository.deleteById(id);
    }
}
