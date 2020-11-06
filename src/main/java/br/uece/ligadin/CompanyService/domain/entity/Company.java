package br.uece.ligadin.CompanyService.domain.entity;

import javax.persistence.*;

@Entity
@Table
public class Company {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

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
}
