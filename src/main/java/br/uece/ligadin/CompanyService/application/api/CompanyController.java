package br.uece.ligadin.CompanyService.application.api;

import br.uece.ligadin.CompanyService.domain.entity.Company;
import br.uece.ligadin.CompanyService.domain.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Company")
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Operation(summary = "Get all companies")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Find companies",
            content = { @Content(mediaType = "application/json",
                schema = @Schema(implementation = Company.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid companies",
            content = @Content),
        @ApiResponse(responseCode = "404", description = "Companies not found",
            content = @Content) })
    @GetMapping
    public ResponseEntity<List<Company>> findAll() {
        var companies = this.companyService.findAll();
        return ResponseEntity.ok(companies);
    }

    @Operation(summary = "Get company by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Find company by id",
            content = { @Content(mediaType = "application/json",
                schema = @Schema(implementation = Company.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid company id",
            content = @Content),
        @ApiResponse(responseCode = "404", description = "Company not found",
            content = @Content) })
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Company> findById(@PathVariable long id) {
        var company = this.companyService.findById(id);
        return ResponseEntity.of(company);
    }

    @Operation(summary = "Create company")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Company sucessfully created",
            content = { @Content(mediaType = "application/json",
                schema = @Schema(implementation = Company.class)) }),
        @ApiResponse(responseCode = "400", description = "Company creation failed",
            content = @Content) })
    @PostMapping
    public ResponseEntity<Company> create(@RequestBody Company newCompany) {
        var company = this.companyService.create(newCompany);
        return ResponseEntity.status(HttpStatus.CREATED).body(company);
    }

    @Operation(summary = "Update company")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Company sucessfully updated",
            content = { @Content(mediaType = "application/json",
                schema = @Schema(implementation = Company.class)) }),
        @ApiResponse(responseCode = "400", description = "Company update failed",
            content = @Content) })
    @PutMapping(path = {"/{id}"})
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Company company) {
        return this.companyService.update(id, company)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete company")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Company sucessfully deleted",
            content = { @Content(mediaType = "application/json",
                schema = @Schema(implementation = Company.class)) }),
        @ApiResponse(responseCode = "400", description = "Company delete failed",
            content = @Content) })
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return this.companyService.deleteById(id)
                .map(company -> ResponseEntity.ok().build())
                .orElse(ResponseEntity.notFound().build());
    }

}
