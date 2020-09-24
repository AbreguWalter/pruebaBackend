package eternal.hoge.spring.boot.example.simple.repository;

import eternal.hoge.spring.boot.example.simple.entity.MonedaDestino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MonedaDestinoRepository extends JpaRepository<MonedaDestino,Long> {

    @Query(value = "select * from MONEDA_DESTINO where id = ?",nativeQuery = true)
    MonedaDestino findByMDId(Long id);

    @Query(value = "select * from MONEDA_DESTINO where MONEDA = ?1",nativeQuery = true)
    MonedaDestino findByMoneraDestino(String moneda);

    //MonedaDestino findByMoneda(String moneda);
}