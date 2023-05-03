package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceção.CheckException;

public class reserva {
	private Integer quartos;
	private Date ci;
	private Date co;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
	
	public reserva() {
	}

	public reserva(Integer quartos, Date checkin, Date checkout) throws CheckException {
		if (!co.after(ci)) {
			throw new CheckException("ERRO: Check-Out deve ser depois do Check-In.") ;
		}
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
	
	public void update(Date checkin, Date checkout) throws CheckException {
		Date agr = new Date();
		if (ci.before(agr) || co.before(agr)) {
			throw new CheckException("ERRO: As datas não são atuais.");
		} 
		if (!co.after(ci)) {
			throw new CheckException("ERRO: Check-Out deve ser depois do Check-In.") ;
		}
		this.ci = checkin;
		this.co = checkout;
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
