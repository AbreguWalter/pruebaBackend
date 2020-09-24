package eternal.hoge.spring.boot.example.simple.service.impl;


import eternal.hoge.spring.boot.example.simple.data.request.TipoCambioRequest;
import eternal.hoge.spring.boot.example.simple.entity.MonedaDestino;
import eternal.hoge.spring.boot.example.simple.entity.TipoCambio;
import eternal.hoge.spring.boot.example.simple.exceptions.InternalServerErrorException;
import eternal.hoge.spring.boot.example.simple.exceptions.NotFoundException;
import eternal.hoge.spring.boot.example.simple.repository.TipoCambioRepository;
import eternal.hoge.spring.boot.example.simple.service.MonedaDestinoService;
import eternal.hoge.spring.boot.example.simple.service.TipoCambioService;
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
public class TipoCambioImplement implements TipoCambioService {

    @Autowired
    private TipoCambioRepository tipoCambioRepository;

    @Autowired
    private MonedaDestinoService monedaDestinoService;

    private final Logger log = LoggerFactory.getLogger(getClass());


    @Override
    public Flowable<List<TipoCambio>> listsTipoCambio() {
        return Flowable.just(tipoCambioRepository.findAll());
    }

    @Override
    public Single<TipoCambio> saveTipoCambio(TipoCambioRequest tipoCambio) {
        log.info("::: tipoCambio.getMonedaDestino() " + tipoCambio.getMonedaDestino());
        Maybe<MonedaDestino> byMonedaDestino = monedaDestinoService.findByMonedaDestino(tipoCambio.getMonedaDestino());

        double montoParseado = Double.parseDouble(tipoCambio.getMonto());
        double tipoCambioParseado = Double.parseDouble(byMonedaDestino.blockingGet().getValue());
        double montoEvaluado = montoParseado / tipoCambioParseado;
        String montoString = String.valueOf(montoEvaluado);
        String montoMasTipoCambio = byMonedaDestino.blockingGet().getSimbolo() + " " + montoString;

        TipoCambio tc = new TipoCambio(tipoCambio.getMonto(),
                tipoCambio.getMonedaOrigen(),
                tipoCambio.getMonedaDestino(),
                montoMasTipoCambio,
                byMonedaDestino.blockingGet().getValue()
        );

        return Single.just(Optional.ofNullable(tipoCambioRepository.save(tc))
                .orElseThrow(() -> new InternalServerErrorException("Error al crear Tipo de Cambio")));

    }

    @Override
    public Maybe<TipoCambio> getTipoCambio(Long id) {
        Maybe<TipoCambio> byId = Maybe.just(Optional
                .ofNullable(tipoCambioRepository.findByIdTC(id))
                .orElseThrow(() -> new NotFoundException("tipo.cambio.not_found")));
        return byId;
    }


    @Override
    public Single<TipoCambio> updateTipoCambio(TipoCambioRequest tipoCambio, Long id) {

        return null;
    }

    @Override
    public Completable deleteTipoCambio(Long id) {
        return null;
    }
}