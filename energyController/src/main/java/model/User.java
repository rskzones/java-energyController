package model;

public class User {
	private Integer idUser;
	private String userName;
	private char[] passUser;
	
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public char[] getPassUser() {
		return passUser;
	}
	public void setPassUser(char[] passUser) {
		this.passUser = passUser;
	}
	
}
