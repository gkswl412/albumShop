package org.albumshop.security.oauth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository2 extends JpaRepository<UserDTO, Long> {
	Optional<UserDTO> findByEmail(String email); 
}
