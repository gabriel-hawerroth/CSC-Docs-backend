package com.br.docscsc.sub_section;

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
@Table(name = "sub_section_v")
public class PersonSubSection {

    @Id
    private Long id;

    private String title;

    @Column(name = "primary_section_title")
    private String primarySectionTitle;
}
// view criada no banco