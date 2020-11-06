package br.uece.ligadin.CompanyService.domain.service;

import br.uece.ligadin.CompanyService.domain.entity.Company;
import br.uece.ligadin.CompanyService.infrastructure.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> findAll() {
        return this.companyRepository.findAll();
    }

    public Optional<Company> findById(long id) {
        return this.companyRepository.findById(id);
    }

    public Company create(Company company) {
        return this.companyRepository.save(company);
    }

    public Optional<Company> update(long id, Company company) {
        return this.companyRepository.findById(id)
                .map(currentCompany -> {
                    company.setId(id);
                    var updatedCompany = this.companyRepository.save(company);
                    return Optional.of(updatedCompany);
                })
                .orElse(Optional.empty());
    }

    public Optional<Company> deleteById(long id) {
        return this.companyRepository.findById(id)
                .map(company -> {
                    this.companyRepository.deleteById(id);
                    return Optional.of(company);
                })
                .orElse(Optional.empty());
    }

}
