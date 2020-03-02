package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.OneToOne;

@Entity
@Table(name="OIL_CHANGE_LOG")
public class DateOfLastOilChange {
	@Id
	private int id;
	@Column(name="SERVICE_DATE")
	private LocalDate serviceDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "SERVICE_ID")
	private ListItem car;
	
	public DateOfLastOilChange() {
		super();
	}
	
	public DateOfLastOilChange(LocalDate serviceDate) {
		super();
		this.serviceDate = serviceDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(LocalDate serviceDate) {
		this.serviceDate = serviceDate;
	}
	
	public ListItem getCar() {
		return car;
	}

	public void setCar(ListItem car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "DateOfLastOilChange [id=" + id + ", serviceDate=" + serviceDate + "]";
	}
}