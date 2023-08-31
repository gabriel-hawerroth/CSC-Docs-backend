package com.br.docscsc.doc_section;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocSectionRepository extends JpaRepository<DocSection, Long> {

    @Query(value =
            """
               select
                  *
               from
                  doc_section
               order by
                  presentation_sequence\s""",
            nativeQuery = true)
    List<DocSection> listOrderByPresentationSequence();
}
