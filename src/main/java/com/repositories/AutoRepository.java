package com.repositories;
import com.models.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.BitSet;
import java.util.Set;


@Repository
public interface AutoRepository extends JpaRepository<Auto, Integer> {

    Set<Auto> findByParkname(String parkname);

}

