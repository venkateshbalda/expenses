package balda.venkatesh.expenses.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="accounts")
public class AccountsPojo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="amount")
	private BigDecimal amount;
	@Column(name="account_name")
	private String account_name;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
	private UserPojo userPojo;
	public UserPojo getUserPojo() {
		return userPojo;
	}
	public void setUserPojo(UserPojo userPojo) {
		this.userPojo = userPojo;
	}
	@Override
	public String toString() {
		return "AccountsPojo [id=" + id + ", amount=" + amount + ", account_name=" + account_name + ", userPojo="
				+ userPojo + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

}
