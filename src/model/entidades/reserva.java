package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class reserva {
	private Integer quartos;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
	
	public reserva() {
		super();
	}

	public reserva(Integer quartos, Date checkin, Date checkout) {
		super();
		this.quartos = quartos;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getQuartos() {
		return quartos;
	}

	public void setQuartos(Integer quartos) {
		this.quartos = quartos;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}
	
	public long duração(){
		long d = checkout.getTime()-checkin.getTime();
		return TimeUnit.DAYS.convert(d, TimeUnit.MILLISECONDS);	
	}
	
	public void update(Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		return "quarto "
				+ quartos
				+", check-in: "
				+ sdf.format(checkin)
				+", check-out: "
				+ sdf.format(checkout)
				+", "
				+duração()
				+" noites";
	}
	
	
	

}
