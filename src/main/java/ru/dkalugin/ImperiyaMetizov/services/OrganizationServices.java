package ru.dkalugin.ImperiyaMetizov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dkalugin.ImperiyaMetizov.entities.Organization;
import ru.dkalugin.ImperiyaMetizov.entities.Subcategory;
import ru.dkalugin.ImperiyaMetizov.repositories.OrganizationRepository;
import ru.dkalugin.ImperiyaMetizov.repositories.SubcategoryRepository;

import java.util.List;

@Service
public class OrganizationServices {
    private OrganizationRepository organizationRepository;

    @Autowired
    public void setOrganizationRepository(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<Organization> getAllOrganization() {
        return organizationRepository.findAll();
    }

}
