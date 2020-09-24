package eternal.hoge.spring.boot.example.simple.service;


import eternal.hoge.spring.boot.example.simple.data.request.TipoCambioRequest;
import eternal.hoge.spring.boot.example.simple.entity.TipoCambio;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

import java.util.List;

public interface TipoCambioService {

    Flowable<List<TipoCambio>> listsTipoCambio();

    Single<TipoCambio> saveTipoCambio(TipoCambioRequest tipoCambio);

    Maybe<TipoCambio> getTipoCambio(Long id);

    Single<TipoCambio> updateTipoCambio(TipoCambioRequest tipoCambio , Long id);

    Completable deleteTipoCambio(Long id);


}