package com.br.docscsc.documentation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentationRepository extends JpaRepository<Documentation, Long> {

    List<Documentation> findByTitleContaining(String title);

    List<Documentation> findBySubSectionId(Long subSectionId);
}
