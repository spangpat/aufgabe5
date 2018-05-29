package de.patrick;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;
import de.hs_furtwangen.informatik.meldeauskunft.repository.ResidentRepository;
import de.hs_furtwangen.informatik.meldeauskunft.repository.ResidentRepositoryStub;
import de.hs_furtwangen.informatik.meldeauskunft.service.BaseResidentService;
import de.hs_furtwangen.informatik.meldeauskunft.service.ResidentService;

public class ResidentRepositroyMockTest {

	@Test
	public void test(){
		Date birthday1 = new Date();
		Date birthday2 = new Date();
		Resident resident1;
		Resident resident2;
		resident1 = new Resident("Patrick", "Spang", "Rohrstraße 26", "Rötenbach", birthday1);
		resident2 = new Resident("Julia", "Bucher", "Auf Schalmen 54", "Rönaueschingen", birthday2);
		List<Resident> residents = new ArrayList<Resident>();
		residents.add(resident1);
		residents.add(resident2);
		
		
		ResidentRepository repositoryMock = createMock(ResidentRepository.class);
		expect(repositoryMock.getResidents()).andReturn(residents);
		
		replay(repositoryMock);
		BaseResidentService service = new BaseResidentService();
		service.setResidentRepository(repositoryMock);
		
		
		Resident residentFilter = new Resident("","","","Rö*", null);
		List<Resident> filteredList = service.getFilteredResidentsList(residentFilter);
		assertEquals(filteredList.size(), 2);
		verify(repositoryMock);
	}
}
