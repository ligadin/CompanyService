package br.uece.ligadin.CompanyService.domain.service;

import br.uece.ligadin.CompanyService.domain.entity.Company;
import br.uece.ligadin.CompanyService.infrastructure.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAll() {
        return this.companyRepository.findAll();
    }

}
