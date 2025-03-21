package org.botnicholas.projects.demopagination.repo;

import org.botnicholas.projects.demopagination.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagesRepo extends JpaRepository<Page, Long> {
}
