package com.example.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
@NamedQuery(name = "findAllTags", query = "from Tag")
public class Tag implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String tagname;

	@Enumerated(EnumType.STRING)
	private TagColor color;

	@ManyToMany
	@JoinTable(name = "tags_tasks", joinColumns = @JoinColumn(name = "id_tag", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_task", referencedColumnName = "id"))
	private List<Task> tasks = new ArrayList<>();

	public Tag() {
	}

	public Tag(Long id, String tagname, TagColor color) {
		this.id = id;
		this.tagname = tagname;
		this.color = color;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public String getTagname() {
		return tagname;
	}

	public TagColor getColor() {
		return color;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	public void setColor(TagColor color) {
		this.color = color;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", tagname=" + tagname + ", color=" + color + ", tasks=" + tasks + "]";
	}

}