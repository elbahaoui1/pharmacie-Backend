package ma.project.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@ManyToMany
	@JoinTable(
			name="User_Role", joinColumns = {@JoinColumn(name="role_id")}, inverseJoinColumns = {@JoinColumn(name="user_id")})
	private List<User> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Role() {
		super();
	}
	
	
	
	
}
