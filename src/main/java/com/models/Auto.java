package com.models;


import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
    @Table(name = "auto")
    public class Auto {
		@Id
        private int id;
		@NotNull(message="must be specified.")
        private String statenumber;
		@NotNull(message="must be specified.")
        private String uin;
		@NotNull(message="must be specified.")
        private String parkname;
        private List<Route> routes;

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Basic
        @Column(name = "statenumber", nullable = false, length = 100)
        public String getStatenumber() {
            return statenumber;
        }

        public void setStatenumber(String statenumber) {
            this.statenumber = statenumber;
        }

        @Basic
        @Column(name = "uin", nullable = false, length = 100)
        public String getUin() {
            return uin;
        }

        public void setUin(String uin) {
            this.uin = uin;
        }

        @Basic
        @Column(name = "parkname", nullable = true, length = 100)
        public String getParkname() {
            return parkname;
        }

        public void setParkname(String parkname) {
            this.parkname = parkname;
        }

    private List<Driver> drivers;

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
	
	@ManyToMany(        
        //cascade = CascadeType.MERGE,
		fetch = FetchType.EAGER
    )

	@JoinTable(name = "driver_autos",
	joinColumns = { @JoinColumn(name = "driver_id") },
	inverseJoinColumns = { @JoinColumn(name = "autos_id") })
    public List<Driver> getDrivers() {			
        return drivers;
    }


	
	
        @Override
        public String toString() {
            return "Auto[" +
                    "id=" + id +
                    ", statenumber=" + statenumber +
                    ", uin=" + uin +
                    ", parkname='" + parkname+ ']';
        }


        @OneToMany(targetEntity=Route.class, mappedBy = "auto", fetch = FetchType.EAGER)    
        @Fetch(value = FetchMode.SUBSELECT)
		public List<Route> getRoutes() {
			return routes;
		}
		
		public void setRoutes(List<Route> routes) {
			this.routes = routes;
		}


}


