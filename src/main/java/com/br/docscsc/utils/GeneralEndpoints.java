package com.br.docscsc.utils;

import com.br.docscsc.documentation.DocumentationRepository;
import com.br.docscsc.models.TotalRecords;
import com.br.docscsc.primary_section.PrimarySectionRepository;
import com.br.docscsc.sub_section.SubSectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("general")
public class GeneralEndpoints {

    @Autowired
    private PrimarySectionRepository primarySectionRepository;
    @Autowired
    private SubSectionRepository subSectionRepository;
    @Autowired
    private DocumentationRepository documentationRepository;

    @GetMapping("/total-records")
    public TotalRecords getTotalOfRecords() {
        int amount_ps = primarySectionRepository.findAll().size();
        int amount_ss = subSectionRepository.findAll().size();
        int amount_docs = documentationRepository.findAll().size();
        TotalRecords totRecords = new TotalRecords(amount_ps, amount_ss, amount_docs);
        System.out.println(totRecords);
        System.out.println("TESTANDO CLASSE");
        return totRecords;
    }

    @GetMapping("/tot-records")
    public List<Integer> getTotRecords() {
        List<Integer> records = new ArrayList<>();

        Integer amount_ps = primarySectionRepository.findAll().size();
        Integer amount_ss = subSectionRepository.findAll().size();
        Integer amount_docs = documentationRepository.findAll().size();

        records.add(amount_ps);
        records.add(amount_ss);
        records.add(amount_docs);

        return records;
    }
}
