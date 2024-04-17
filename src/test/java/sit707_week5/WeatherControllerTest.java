package sit707_week5;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class WeatherControllerTest {

	@Test
	public void testStudentIdentity() {
		String studentId = "216293263";
		Assert.assertNotNull("Student ID is 216293263", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Mark Przybylkiewicz";
		Assert.assertNotNull("Student name is Mark Przybylkiewicz", studentName);
	}

	@Test
	public void testTemperatureMin() {
		System.out.println("+++ testTemperatureMin +++");
		
		// Initialise controller
		
		   	WeatherController mockController = Mockito.mock(WeatherController.class);
	        Mockito.when(mockController.getTotalHours()).thenReturn(3);
	        Mockito.when(mockController.getTemperatureForHour(1)).thenReturn(25.0);
	        Mockito.when(mockController.getTemperatureForHour(2)).thenReturn(17.0);
	        Mockito.when(mockController.getTemperatureForHour(3)).thenReturn(22.0);
		
		// Retrieve all the hours temperatures recorded as for today
		int nHours = mockController.getTotalHours();
		double minTemperature = 1000;
		for (int i=0; i<nHours; i++) {
			// Hour range: 1 to nHours
			double temperatureVal = mockController.getTemperatureForHour(i+1); 
			if (minTemperature > temperatureVal) {
				minTemperature = temperatureVal;
			}
		}
		
		// Should be equal to the min value that is cached in the controller.
		 Assert.assertEquals("The minimum temperature should be 17.", 17.0, minTemperature, 0.001);
		
				
	}
	
	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");
		
		// Initialise controller
		  	WeatherController mockController = Mockito.mock(WeatherController.class);
	        Mockito.when(mockController.getTotalHours()).thenReturn(3);
	        Mockito.when(mockController.getTemperatureForHour(1)).thenReturn(22.0);
	        Mockito.when(mockController.getTemperatureForHour(2)).thenReturn(30.0);
	        Mockito.when(mockController.getTemperatureForHour(3)).thenReturn(24.0);
		
		// Retrieve all the hours temperatures recorded as for today
		int nHours = mockController.getTotalHours();
		double maxTemperature = -1;
		for (int i=0; i<nHours; i++) {
			// Hour range: 1 to nHours
			double temperatureVal = mockController.getTemperatureForHour(i+1); 
			if (maxTemperature < temperatureVal) {
				maxTemperature = temperatureVal;
			}
		}
		
		// Should be equal to the min value that is cached in the controller.
		Assert.assertEquals("The maximum temperature should be 30.", 30.0, maxTemperature, 0.001);
		
		// Shutdown controller
		
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");
		
		// Initialise controller
		WeatherController mockController = Mockito.mock(WeatherController.class);
        Mockito.when(mockController.getTotalHours()).thenReturn(3);
        Mockito.when(mockController.getTemperatureForHour(1)).thenReturn(22.0);
        Mockito.when(mockController.getTemperatureForHour(2)).thenReturn(26.0);
        Mockito.when(mockController.getTemperatureForHour(3)).thenReturn(21.0);
		
		// Retrieve all the hours temperatures recorded as for today
		int nHours = mockController.getTotalHours();
		double sumTemp = 0;
		for (int i=0; i<nHours; i++) {
			// Hour range: 1 to nHours
			double temperatureVal = mockController.getTemperatureForHour(i+1); 
			sumTemp += temperatureVal;
		}
		double averageTemp = sumTemp / nHours;
		
		// Should be equal to the min value that is cached in the controller.
		Assert.assertEquals("The average temperature should be 23.", 23.0, averageTemp, 0.001);
	
	}
	
	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}
