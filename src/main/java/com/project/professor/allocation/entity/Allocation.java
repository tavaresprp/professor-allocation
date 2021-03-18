package com.project.professor.allocation.entity;

import java.time.DayOfWeek;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "allocation")
@Data
@NoArgsConstructor
public class Allocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	@Enumerated(value = EnumType.STRING)
	private DayOfWeek day;
	
	@Column(nullable=false)
	@Temporal(value = TemporalType.TIME)
	private Date start;
	
	@Column(nullable=false)
	@Temporal(value = TemporalType.TIME)
	private Date end;

}
