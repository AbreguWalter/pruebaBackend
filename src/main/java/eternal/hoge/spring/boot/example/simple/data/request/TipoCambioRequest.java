package eternal.hoge.spring.boot.example.simple.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;


public class TipoCambioRequest {

	@NotNull(message = "tipo.cambio.creation.monto.null")
	@JsonProperty(value="monto")
	private String monto;

	@NotNull(message = "tipo.cambio.creation.moneda.origen.null")
	@JsonProperty(value="moneda_origen")
	private String monedaOrigen;

	@NotNull(message = "tipo.cambio.creation.moneda.destino.null")
	@JsonProperty(value="moneda_destino")
	private String monedaDestino;

	public String getMonto() {
		return monto;
	}

	public TipoCambioRequest setMonto(String monto) {
		this.monto = monto;
		return this;
	}

	public String getMonedaOrigen() {
		return monedaOrigen;
	}

	public TipoCambioRequest setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
		return this;
	}

	public String getMonedaDestino() {
		return monedaDestino;
	}

	public TipoCambioRequest setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
		return this;
	}
}
