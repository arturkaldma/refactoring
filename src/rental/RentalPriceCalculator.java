package rental;

public class RentalPriceCalculator {
	
	// age - age of driver
	// licence - number of full years person holds driving licence
	// clazz - class of the car from 1 (smallest) to 5 (largest) that person wishes to rent
	// acc - has s/he caused any accidents within last year
	// acc2 - has s/he participated (but not caused) in any accidents within last year
	// season - if it is high season or not
	public double CalculatePrice(int age, int yearsOfExperience, int classOfCar, boolean causedAccident, boolean participatedInAccident, boolean highSeason) {
		
		if (age < 18) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
		if (age <= 21 && classOfCar > 2) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}
		
		double rentalprice = age;
		
		if (classOfCar >=4 && age <= 25 && highSeason != false) {
			rentalprice = rentalprice * 2;
		}
		
		if (yearsOfExperience < 1) {
			throw new IllegalArgumentException("Driver must hold driving yearsOfExperience at least for one year. Can not rent a car!");
		}
		
		if (yearsOfExperience < 3) {
			rentalprice = rentalprice * 1.3;
		}
		
		if (causedAccident == true && age < 30) {
			rentalprice += 15;
		}


		if (rentalprice > 1000) {
			return 1000.00;
		}
		return rentalprice;
	}
}