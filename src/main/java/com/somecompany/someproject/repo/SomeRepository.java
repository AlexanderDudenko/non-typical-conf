package com.somecompany.someproject.repo;

import com.somecompany.someproject.model.SomeEntity;
import org.springframework.data.repository.CrudRepository;

public interface SomeRepository extends CrudRepository<SomeEntity, Long> {

}
