package dev.bitByte.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "CLIENT")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_id")
	private int cId; 
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password; 
	
	@Column(name = "is_Manager")
	private boolean isManager;
	
	@Column(name = "score")
	private int score;
	
	public Client() {
		super();
	}
	public Client(int cId, String username, String password, boolean isManager, int score) {
		super();
		this.cId = cId;
		this.username = username;
		this.password = password;
		this.isManager = isManager;
		this.score = score;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Client [cId=" + cId + ", username=" + username + ", password=" + password + ", isManager=" + isManager
				+ ", score=" + score + "]";
	}
}
