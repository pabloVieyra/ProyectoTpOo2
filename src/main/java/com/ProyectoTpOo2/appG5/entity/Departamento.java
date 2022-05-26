package com.ProyectoTpOo2.appG5.entity;



	import java.util.Objects;
	import java.util.Set;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;
	import javax.validation.constraints.NotBlank;

	@Entity
	@Table(name = "departamento")
	public class Departamento {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column 
		@NotBlank
		private String Name;

		@OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY,mappedBy="id")
		private Set<Carrera> carreras;
		
		public Departamento() {
			super();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public Set<Carrera> getCarreras() {
			return carreras;
		}

		public void setCarreras(Set<Carrera> carreras) {
			this.carreras = carreras;
		}

		@Override
		public String toString() {
			return "Departamento [id=" + id + ", Name=" + Name + ", carreras=" + carreras + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(Name, carreras, id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Departamento other = (Departamento) obj;
			return Objects.equals(Name, other.Name) && Objects.equals(carreras, other.carreras)
					&& Objects.equals(id, other.id);
		}

		
		

	}

