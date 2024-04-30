package com.coderscampus.Unit_18_Hibernate.repository;

import com.coderscampus.Unit_18_Hibernate.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//                                                 entity , data type
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
