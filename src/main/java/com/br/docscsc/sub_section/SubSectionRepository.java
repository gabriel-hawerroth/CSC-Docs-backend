package com.br.docscsc.sub_section;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubSectionRepository extends JpaRepository<SubSection, Long> {

    @Query(value =
            """
                    select
                        *
                    from
                        sub_section
                    where
                        primary_section_id = :PrimarySectionId""", nativeQuery = true)
    List<SubSection> listByPrimarySec(Long PrimarySectionId);

}
