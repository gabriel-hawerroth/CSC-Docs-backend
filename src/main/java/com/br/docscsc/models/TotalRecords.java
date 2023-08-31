package com.br.docscsc.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TotalRecords {
    private int amount_ps;
    private int amount_ss;
    private int amount_docs;
}
