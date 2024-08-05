package com.LoversDogs.Lovers.repository;


import com.LoversDogs.Lovers.entity.Dog;
//import com.LoversDogs.Lovers.dto.DogForm;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface DogRepository extends JpaRepository<Dog,Long> {
Optional<Dog> findByName(String name);

}
