package de.patrick;

import static org.junit.Assert.*;

import java.util.List;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;
import de.hs_furtwangen.informatik.meldeauskunft.repository.ResidentRepositoryStub;
import de.hs_furtwangen.informatik.meldeauskunft.service.BaseResidentService;
import de.hs_furtwangen.informatik.meldeauskunft.service.ResidentServiceException;

public class BaseResidentServiceTest {

	BaseResidentService service;
	ResidentRepositoryStub repositoryStub;
	Date birthday1 = new Date();
	Date birthday2 = new Date();
	Resident resident1;
	Resident resident2;
	public BaseResidentServiceTest() {
		// TODO Auto-generated constructor stub
		service = new BaseResidentService();
		repositoryStub = new ResidentRepositoryStub();
		
		resident1 = new Resident("Patrick", "Spang", "Rohrstraße 26", "Rötenbach", birthday1);
		
		resident2 = new Resident("Julia", "Bucher", "Auf Schalmen 54", "Rönaueschingen", birthday2);
		
		repositoryStub.addResident(resident1);
		repositoryStub.addResident(resident2);
		service.setResidentRepository(repositoryStub);
	}
	
	@Test
	public void testFilteredResidentsList(){
		Resident residentFilter = new Resident("","","","Rö*", null);
		List<Resident> filteredList = service.getFilteredResidentsList(residentFilter);
		assertEquals(filteredList.size(), 2);
		
		residentFilter = new Resident("Patrick","","","", birthday1);
		filteredList = service.getFilteredResidentsList(residentFilter);
		assertEquals(filteredList.size(), 1);
		assertEquals(filteredList.get(0),  resident1);
		
		
	}
	
	@Test
	public void testUniqueResident(){
		Resident residentFilter = new Resident("Patrick","Spang","Rohrstraße 26","Rötenbach", birthday1);
		
		try {
			assertEquals(service.getUniqueResident(residentFilter), resident1);
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		residentFilter = new Resident("Julia","Bucher","Auf Schalmen 54","Rönaueschingen", birthday2);
		
		try {
			assertEquals(service.getUniqueResident(residentFilter), resident2);
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		residentFilter = new Resident("Julia","Bucher","Auf Schalmen 53","Rönaueschingen", birthday2);
		boolean keinTreffer = false;
		try {
			service.getUniqueResident(residentFilter);
			
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
			keinTreffer = true;
			System.out.println();
		}
		assertTrue(keinTreffer);
		
	}
}
