package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table
public class Room {

	 @Id @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private String type;
	    private int price;
	    private int Number_of_Rooms;
		public Room( String type, int price, int number_of_Rooms) {
			super();
			
			this.type = type;
			this.price = price;
			Number_of_Rooms = number_of_Rooms;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getNumber_of_Rooms() {
			return Number_of_Rooms;
		}
		public void setNumber_of_Rooms(int number_of_Rooms) {
			Number_of_Rooms = number_of_Rooms;
		}

	    
}
