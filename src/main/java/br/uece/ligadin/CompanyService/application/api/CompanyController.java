package br.uece.ligadin.CompanyService.application.api;

import br.uece.ligadin.CompanyService.domain.entity.Company;
import br.uece.ligadin.CompanyService.domain.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAll() {
        List<Company> companies = companyService.getAll();
        return ResponseEntity.ok(companies);
    }

}
