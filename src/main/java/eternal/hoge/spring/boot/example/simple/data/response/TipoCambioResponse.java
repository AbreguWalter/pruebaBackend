package eternal.hoge.spring.boot.example.simple.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;


public class TipoCambioResponse {

	@JsonProperty("id")
	private Long id;

	@Column(name="monto")
	private String monto;

	@Column(name="monto_tipo_cambio")
	private String montoTipoCambio;

	@Column(name="moneda_origen")
	private String monedaOrigen;

	@Column(name="moneda_destino")
	private String monedaDestino;

	@Column(name="tipo_de_cambio")
	private String tipoDeCambio;

	public Long getId() {
		return id;
	}

	public TipoCambioResponse setId(Long id) {
		this.id = id;
		return this;
	}

	public String getMonto() {
		return monto;
	}

	public TipoCambioResponse setMonto(String monto) {
		this.monto = monto;
		return this;
	}

	public String getMontoTipoCambio() {
		return montoTipoCambio;
	}

	public TipoCambioResponse setMontoTipoCambio(String montoTipoCambio) {
		this.montoTipoCambio = montoTipoCambio;
		return this;
	}

	public String getMonedaOrigen() {
		return monedaOrigen;
	}

	public TipoCambioResponse setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
		return this;
	}

	public String getMonedaDestino() {
		return monedaDestino;
	}

	public TipoCambioResponse setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
		return this;
	}

	public String getTipoDeCambio() {
		return tipoDeCambio;
	}

	public TipoCambioResponse setTipoDeCambio(String tipoDeCambio) {
		this.tipoDeCambio = tipoDeCambio;
		return this;
	}
}
