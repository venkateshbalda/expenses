package balda.venkatesh.expenses.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

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
@Table(name="expense")
public class ExpensePojo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="accountid")
	private int accountid;
	public int getAccountid() {
		return accountid;
	}


	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}


	@Column(name="amount")
	private BigDecimal amount;
	@Column(name="date")
	private LocalDate date;
	@Column(name="type")
	private String type;
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Column(name="description")
	private String description;
	@Column(name="category")
	private String category;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
	private UserPojo userPojo;
	

	@Override
	public String toString() {
		return "ExpensePojo [id=" + id + ", amount=" + amount + ", date=" + date + ", description=" + description
				+ ", category=" + category + ", userPojo=" + userPojo + "]";
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


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public UserPojo getUserPojo() {
		return userPojo;
	}


	public void setUserPojo(UserPojo userPojo) {
		this.userPojo = userPojo;
	}


	public ExpensePojo() {
        this.date = LocalDate.now();
    }
	

}
