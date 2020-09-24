package eternal.hoge.spring.boot.example.simple.controller;


import eternal.hoge.spring.boot.example.simple.data.request.TipoCambioRequest;
import eternal.hoge.spring.boot.example.simple.entity.TipoCambio;
import eternal.hoge.spring.boot.example.simple.service.TipoCambioService;
import io.reactivex.Flowable;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-cambio")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoCambioController {

    @Autowired
    private TipoCambioService tipoCambioService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping
    public List<TipoCambio> findAll(){
        return tipoCambioService.listsTipoCambio().blockingFirst();
    }

    @PostMapping
    public Single<TipoCambio> save(@RequestBody TipoCambioRequest tipoCambioRequest ){
        Single<TipoCambio> tipoCambioSingle = tipoCambioService.saveTipoCambio(tipoCambioRequest);
        return tipoCambioSingle;
    }

    @PutMapping("/{id}")
    public Single<TipoCambio> update(@RequestBody TipoCambioRequest tipoCambioRequest , @PathVariable Long id){

        return tipoCambioService.updateTipoCambio(tipoCambioRequest, id);

    }


}