package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class reserva {
	private Integer quartos;
	private Date ci;
	private Date co;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
	
	public reserva() {
		super();
	}

	public reserva(Integer quartos, Date checkin, Date checkout) {
		super();
		this.quartos = quartos;
		this.ci = checkin;
		this.co = checkout;
	}

	public Integer getQuartos() {
		return quartos;
	}

	public void setQuartos(Integer quartos) {
		this.quartos = quartos;
	}

	public Date getCheckin() {
		return ci;
	}

	public Date getCheckout() {
		return co;
	}
	
	public long duração(){
		long d = co.getTime()-ci.getTime();
		return TimeUnit.DAYS.convert(d, TimeUnit.MILLISECONDS);	
	}
	
	public String update(Date checkin, Date checkout) {
		
		Date agr = new Date();
		if (ci.before(agr) || co.before(agr)) {
			return "ERRO: As datas não são atuais.";
		} 
		if (!co.after(ci)) {
			return "ERRO: Check-Out deve ser depois do Check-In.";
		}
		
		this.ci = checkin;
		this.co = checkout;
		return null;
	}

	@Override
	public String toString() {
		return "quarto "
				+ quartos
				+", check-in: "
				+ sdf.format(ci)
				+", check-out: "
				+ sdf.format(co)
				+", "
				+duração()
				+" noites";
	}
	
	
	

}
