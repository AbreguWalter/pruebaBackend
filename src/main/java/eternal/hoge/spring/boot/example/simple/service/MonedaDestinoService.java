package eternal.hoge.spring.boot.example.simple.service;

import eternal.hoge.spring.boot.example.simple.entity.MonedaDestino;
import eternal.hoge.spring.boot.example.simple.entity.TipoCambio;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

import java.util.List;

public interface MonedaDestinoService {

    Flowable<List<MonedaDestino>> listsMonedaDestino();

    Single<MonedaDestino> saveMonedaDestino(MonedaDestino monedaDestino);

    Maybe<MonedaDestino> getMonedaDestino(Long id);

    Single<MonedaDestino> updateMonedaDestino(MonedaDestino monedaDestino , Long id);

    Completable deleteMonedaDestino(Long id);

    Maybe<MonedaDestino> findByMonedaDestino(String id);

}