package eternal.hoge.spring.boot.example.simple.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="MONEDA_DESTINO")
public class MonedaDestino implements Serializable {

    private static final long serialVersionUID = 4327690299451102763L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="moneda")
    private String monedaDestino;

    @Column(name="valor")
    private String value;

    @Column(name="simbolo")
    private String simbolo;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public MonedaDestino setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public MonedaDestino setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
        return this;
    }

    public String getValue() {
        return value;
    }

    public MonedaDestino setValue(String value) {
        this.value = value;
        return this;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public MonedaDestino setSimbolo(String simbolo) {
        this.simbolo = simbolo;
        return this;
    }
}
