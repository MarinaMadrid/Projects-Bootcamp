package com.example.demo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
@NamedQuery(name = "findAllTasks", query = "from Task")
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", unique = true, nullable = false)
	private String title;

	@Column(name = "description", length = 300)
	private String description;

	@Column(name = "finished")
	private Boolean finished;

	@Column(name = "deliverydate")
	private LocalDate deliverydate;

	// user
	@ManyToOne // owner
	@JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "fk_task_user"))
	private User user;

	// tag
	@ManyToMany(mappedBy = "tasks")
	private List<Tag> tags = new ArrayList<>();

	public Task() {
	}

	public Task(Long id, String title, String description, Boolean finished, LocalDate deliverydate) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.finished = finished;
		this.deliverydate = deliverydate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Boolean getFinished() {
		return finished;
	}

	public LocalDate getDeliverydate() {
		return deliverydate;
	}

	public User getUser() {
		return user;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setFinished(Boolean finished) {
		this.finished = finished;
	}

	public void setDeliverydate(LocalDate deliverydate) {
		this.deliverydate = deliverydate;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", finished=" + finished
				+ ", deliverydate=" + deliverydate + ", user=" + user + ", tags=" + tags + "]";
	}

}