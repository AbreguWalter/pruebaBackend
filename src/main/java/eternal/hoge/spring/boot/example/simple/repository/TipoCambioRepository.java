package eternal.hoge.spring.boot.example.simple.repository;

import eternal.hoge.spring.boot.example.simple.entity.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.reactive.RxJava2CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambio,Long> {

    @Query(value = "select * from TIPO_DE_CAMBIO where id = ?",nativeQuery = true)
    TipoCambio findByIdTC(Long id);
}