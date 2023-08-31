package com.br.docscsc.documentation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "documentation_v")
public class PersonDocumentation {

    @Id
    private Long id;

    private String title;

    @Column(name = "sub_section_title")
    private String subSectionTitle;
}
