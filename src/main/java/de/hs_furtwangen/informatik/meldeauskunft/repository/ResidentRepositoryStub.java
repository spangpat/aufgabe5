package de.hs_furtwangen.informatik.meldeauskunft.repository;

import java.util.ArrayList;
import java.util.List;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;

public class ResidentRepositoryStub implements ResidentRepository{

	List<Resident> residents;
	
	public ResidentRepositoryStub(){
		residents = new ArrayList<Resident>();
	}
	
	public List<Resident> getResidents() {
		// TODO Auto-generated method stub
		return residents;
	}
	
	public void addResident(Resident r){
		residents.add(r);
	}

}
