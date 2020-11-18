package br.uece.ligadin.CompanyService.domain.entity;

import javax.persistence.*;

@Entity
@Table
public class Company {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String website;

    @Column
    private String email;

    @Column
    private String size;

    @Column
    private String industry;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
}
