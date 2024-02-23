package entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table
public class Hotel {

	 @Id @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private String name;
	    private String adress;
	    private int number_rooms;
	    private boolean Spa_IsActive;
	    private boolean Restau_IsActive;
	    private boolean Piscine_IsActive;
		public Hotel( String name, String adress, int number_rooms, boolean spa_IsActive, boolean restau_IsActive,
				boolean piscine_IsActive) {
			super();
			
			this.name = name;
			this.adress = adress;
			this.number_rooms = number_rooms;
			Spa_IsActive = spa_IsActive;
			Restau_IsActive = restau_IsActive;
			Piscine_IsActive = piscine_IsActive;
		}
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAdress() {
			return adress;
		}
		public void setAdress(String adress) {
			this.adress = adress;
		}
		public int getNumber_rooms() {
			return number_rooms;
		}
		public void setNumber_rooms(int number_rooms) {
			this.number_rooms = number_rooms;
		}
		public boolean isSpa_IsActive() {
			return Spa_IsActive;
		}
		public void setSpa_IsActive(boolean spa_IsActive) {
			Spa_IsActive = spa_IsActive;
		}
		public boolean isRestau_IsActive() {
			return Restau_IsActive;
		}
		public void setRestau_IsActive(boolean restau_IsActive) {
			Restau_IsActive = restau_IsActive;
		}
		public boolean isPiscine_IsActive() {
			return Piscine_IsActive;
		}
		public void setPiscine_IsActive(boolean piscine_IsActive) {
			Piscine_IsActive = piscine_IsActive;
		}
		@Override
		public String toString() {
			return "hotel [id=" + id + ", name=" + name + ", adress=" + adress + ", number_rooms=" + number_rooms
					+ ", Spa_IsActive=" + Spa_IsActive + ", Restau_IsActive=" + Restau_IsActive + ", Piscine_IsActive="
					+ Piscine_IsActive + "]";
		}
	    
	    
		

}




