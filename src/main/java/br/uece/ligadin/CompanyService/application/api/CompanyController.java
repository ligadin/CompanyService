package br.uece.ligadin.CompanyService.application.api;

import br.uece.ligadin.CompanyService.domain.entity.Company;
import br.uece.ligadin.CompanyService.domain.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> findAll() {
        var companies = this.companyService.findAll();
        return ResponseEntity.ok(companies);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Company> findById(@PathVariable long id) {
        var company = this.companyService.findById(id);
        return ResponseEntity.of(company);
    }

    @PostMapping
    public ResponseEntity<Company> create(@RequestBody Company newCompany) {
        var company = this.companyService.create(newCompany);
        return ResponseEntity.status(HttpStatus.CREATED).body(company);
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Company company) {
        return this.companyService.update(id, company)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return this.companyService.deleteById(id)
                .map(company -> ResponseEntity.ok().build())
                .orElse(ResponseEntity.notFound().build());
    }

}
