package EntityBeans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the loai database table.
 * 
 */
@Entity
@NamedQuery(name="Loai.findAll", query="SELECT l FROM Loai l")
public class Loai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idLoai;

	@Column(name="ten_loai")
	private String tenLoai;

	//bi-directional many-to-many association to Monhoc
	@ManyToMany(mappedBy="loais")
	private List<Monhoc> monhocs;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="loai")
	private List<User> users;

	public Loai() {
	}

	public int getIdLoai() {
		return this.idLoai;
	}

	public void setIdLoai(int idLoai) {
		this.idLoai = idLoai;
	}

	public String getTenLoai() {
		return this.tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public List<Monhoc> getMonhocs() {
		return this.monhocs;
	}

	public void setMonhocs(List<Monhoc> monhocs) {
		this.monhocs = monhocs;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setLoai(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setLoai(null);

		return user;
	}

}