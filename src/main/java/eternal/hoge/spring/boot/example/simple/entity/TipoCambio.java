package eternal.hoge.spring.boot.example.simple.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name="TIPO_DE_CAMBIO")
public class TipoCambio implements Serializable {

	private static final long serialVersionUID = 4327690299451102763L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="monto")
	@NotEmpty
	private String monto;

	@Column(name="moneda_origen")
	@NotEmpty
	private String moneraOrigen;

	@Column(name="moneda_destino")
	@NotEmpty
	private String moneraDestino;

	@Column(name="monto_tipo_cambio")
	@NotEmpty
	private String montoTipoCambio;

	@Column(name="tipo_cambio")
	@NotEmpty
	private String tipoCambio;

	public TipoCambio(@NotEmpty String monto, @NotEmpty String moneraOrigen, @NotEmpty String moneraDestino, @NotEmpty String montoTipoCambio, @NotEmpty String tipoCambio) {
		this.monto = monto;
		this.moneraOrigen = moneraOrigen;
		this.moneraDestino = moneraDestino;
		this.montoTipoCambio = montoTipoCambio;
		this.tipoCambio = tipoCambio;
	}

	public TipoCambio() {

	}

	public String getMontoTipoCambio() {
		return montoTipoCambio;
	}

	public TipoCambio setMontoTipoCambio(String montoTipoCambio) {
		this.montoTipoCambio = montoTipoCambio;
		return this;
	}

	public String getTipoCambio() {
		return tipoCambio;
	}

	public TipoCambio setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
		return this;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public TipoCambio setId(Long id) {
		this.id = id;
		return this;
	}

	public String getMonto() {
		return monto;
	}

	public TipoCambio setMonto(String monto) {
		this.monto = monto;
		return this;
	}

	public String getMoneraOrigen() {
		return moneraOrigen;
	}

	public TipoCambio setMoneraOrigen(String moneraOrigen) {
		this.moneraOrigen = moneraOrigen;
		return this;
	}

	public String getMoneraDestino() {
		return moneraDestino;
	}

	public TipoCambio setMoneraDestino(String moneraDestino) {
		this.moneraDestino = moneraDestino;
		return this;
	}


}
