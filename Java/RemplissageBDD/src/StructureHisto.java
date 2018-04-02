import java.time.LocalDate;

public class StructureHisto {
	
	private int idHisto, idStructure;
	private LocalDate datepremierecreation;
	private LocalDate dateDisparition;
	private LocalDate dateDerniereCreation;
	

	
	public int getIdHisto() {
		return idHisto;
	}
	public void setIdHisto(int idHisto) {
		this.idHisto = idHisto;
	}
	public int getIdStructure() {
		return idStructure;
	}
	public void setIdStructure(int idStructure) {
		this.idStructure = idStructure;
	}
	public LocalDate getDatepremierecreation() {
		return datepremierecreation;
	}
	public void setDatepremierecreation(LocalDate datepremierecreation) {
		this.datepremierecreation = datepremierecreation;
	}
	public LocalDate getDateDisparition() {
		return dateDisparition;
	}
	public void setDateDisparition(LocalDate dateDisparition) {
		this.dateDisparition = dateDisparition;
	}
	public LocalDate getDateDerniereCreation() {
		return dateDerniereCreation;
	}
	public void setDateDerniereCreation(LocalDate dateDerniereCreation) {
		this.dateDerniereCreation = dateDerniereCreation;
	}

	@Override
	public String toString() {
		return "StructureHisto [idHisto=" + idHisto + ", idStructure=" + idStructure + ", datepremierecreation="
				+ datepremierecreation + ", dateDisparition=" + dateDisparition + ", dateDerniereCreation="
				+ dateDerniereCreation + "]";
	}
}
