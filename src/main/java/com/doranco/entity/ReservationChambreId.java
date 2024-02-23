package com.doranco.entity;

import java.io.Serializable;
import java.util.Objects;

public class ReservationChambreId implements Serializable {

    private Integer hotel;  
    private Integer client; 
    private Integer facture;
    
	@Override
	public int hashCode() {
		return Objects.hash(client, facture, hotel);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationChambreId other = (ReservationChambreId) obj;
		return Objects.equals(client, other.client) && Objects.equals(facture, other.facture)
				&& Objects.equals(hotel, other.hotel);
	}
	public Integer getHotel() {
		return hotel;
	}
	public void setHotel(Integer hotel) {
		this.hotel = hotel;
	}
	public Integer getClient() {
		return client;
	}
	public void setClient(Integer client) {
		this.client = client;
	}
	public Integer getFacture() {
		return facture;
	}
	public void setFacture(Integer facture) {
		this.facture = facture;
	}


}