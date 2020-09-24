package eternal.hoge.spring.boot.example.simple.controller;


import eternal.hoge.spring.boot.example.simple.data.request.TipoCambioRequest;
import eternal.hoge.spring.boot.example.simple.entity.MonedaDestino;
import eternal.hoge.spring.boot.example.simple.service.MonedaDestinoService;
import io.reactivex.Flowable;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moneda")
@CrossOrigin(origins = "http://localhost:4200")
public class MonedaDestinoController {

    @Autowired
    private MonedaDestinoService monedaDestinoService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping
    public List<MonedaDestino> findAll(){
        return monedaDestinoService.listsMonedaDestino().blockingFirst();
    }

    @PostMapping("/{id}")
    public MonedaDestino update(@RequestBody MonedaDestino monedaDestino , @PathVariable Long id){
        return monedaDestinoService.updateMonedaDestino(monedaDestino, id).blockingGet();

    }


}