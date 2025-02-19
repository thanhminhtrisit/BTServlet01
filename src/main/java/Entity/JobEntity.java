package entity;

import java.util.Date;

public class JobEntity {
	private int id;
	private String name;
	private Date Datestart_date;
	private Date end_date;
	public JobEntity() {
		super();
	}
	public JobEntity(int id, String name, Date datestart_date, Date end_date) {
		super();
		this.id = id;
		this.name = name;
		Datestart_date = datestart_date;
		this.end_date = end_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDatestart_date() {
		return Datestart_date;
	}

	public void setDatestart_date(Date datestart_date) {
		Datestart_date = datestart_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
}
