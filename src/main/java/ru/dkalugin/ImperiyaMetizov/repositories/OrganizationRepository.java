package ru.dkalugin.ImperiyaMetizov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dkalugin.ImperiyaMetizov.entities.Category;
import ru.dkalugin.ImperiyaMetizov.entities.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
