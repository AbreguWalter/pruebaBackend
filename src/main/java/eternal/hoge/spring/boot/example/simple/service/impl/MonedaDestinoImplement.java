package eternal.hoge.spring.boot.example.simple.service.impl;

import eternal.hoge.spring.boot.example.simple.entity.MonedaDestino;
import eternal.hoge.spring.boot.example.simple.entity.TipoCambio;
import eternal.hoge.spring.boot.example.simple.exceptions.InternalServerErrorException;
import eternal.hoge.spring.boot.example.simple.exceptions.NotFoundException;
import eternal.hoge.spring.boot.example.simple.repository.MonedaDestinoRepository;
import eternal.hoge.spring.boot.example.simple.service.MonedaDestinoService;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonedaDestinoImplement implements MonedaDestinoService {

    @Autowired
    private MonedaDestinoRepository monedaDestinoRepository;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Flowable<List<MonedaDestino>> listsMonedaDestino() {
        return Flowable.just(monedaDestinoRepository.findAll());
    }

    @Override
    public Single<MonedaDestino> saveMonedaDestino(MonedaDestino monedaDestino) {

        Single<MonedaDestino> just = Single.just(monedaDestinoRepository.save(monedaDestino));
        return just;
    }

    @Override
    public Maybe<MonedaDestino> getMonedaDestino(Long id) {

        Maybe<MonedaDestino> monedaDestino = Maybe.just( Optional
                .ofNullable(monedaDestinoRepository.findByMDId(id))
                .orElseThrow(() -> new NotFoundException("moneda.destino.not_found")));

        return monedaDestino;
    }

    @Override
    public Maybe<MonedaDestino> findByMonedaDestino(String md) {
        log.info("::: " + md);
        Maybe<MonedaDestino> just = Maybe.just(monedaDestinoRepository.findByMoneraDestino(md));
        return just;
    }


    @Override
    public Single<MonedaDestino> updateMonedaDestino(MonedaDestino monedaDestino, Long id) {
        Maybe<MonedaDestino> byId = Maybe.just( Optional
                .ofNullable(monedaDestinoRepository.findByMDId(id))
                .orElseThrow(() -> new NotFoundException("moneda.destino.not_found")));

        Single<MonedaDestino> monedaDestinoSingle = byId.map(md -> {
            md.setValue(monedaDestino.getValue());
            return md;
        }).toSingle()
                .flatMap(m -> {
                    Single<MonedaDestino> error_al_actualizar_moneda_destino = Single.just(Optional.ofNullable(monedaDestinoRepository.save(m))
                            .orElseThrow(() -> new InternalServerErrorException("Error al actualizar Moneda Destino")));
                    return error_al_actualizar_moneda_destino;
                        });

        return monedaDestinoSingle;
    }

    @Override
    public Completable deleteMonedaDestino(Long id) {
        return null;
    }
}