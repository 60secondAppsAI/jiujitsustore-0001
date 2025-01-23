package com.jiujitsustore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.time.Year;
import jakarta.persistence.Transient;



@Entity
@Table(name="shipments")
@Getter @Setter @NoArgsConstructor
public class Shipment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  	@Column(name="shipment_id")
	private Integer shipmentId;
    
  	@Column(name="shipment_date")
	private Date shipmentDate;
    
  	@Column(name="carrier")
	private String carrier;
    
	




}
