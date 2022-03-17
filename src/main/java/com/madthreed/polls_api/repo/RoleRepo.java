package com.madthreed.polls_api.repo;

import com.madthreed.polls_api.model.Role;
import com.madthreed.polls_api.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(RoleName role);
}