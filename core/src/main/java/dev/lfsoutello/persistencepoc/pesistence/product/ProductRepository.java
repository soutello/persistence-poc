package dev.lfsoutello.persistencepoc.pesistence.product;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    @Modifying
    @Query("update Product p set p.deleted = true where p.id = :id")
    void deleteById(@NonNull @Param("id") Long id);

    Optional<Product> findByIdAndDeletedFalse(Long id);
}
