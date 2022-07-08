package com.backend.api.repository;

import com.backend.api.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProviderRepository extends JpaRepository<Provider,Long> {
}
