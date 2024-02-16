import java.util.Scanner;

public class MenuClass {
	Scanner input=new Scanner(System.in);
	Scanner stringInput=new Scanner(System.in);
	CRMS crms=new CRMS();
	
	
	public void Menu() {
		crms.additionOfCars(); //default cars
		crms.additionOfRenters(); //default renters
		int choice=0;
		do {
			//_________main-menu_____________//
			System.out.println();
			System.out.println("1. Display Availabe Cars");
			System.out.println("2. Add Car in CRMS");
			System.out.println("3. Remove Car from CRMS");
			System.out.println("4. Add Renter in CRMS");
			System.out.println("5. Rent a Car to a Renter");
			System.out.println("6. Return Car");
			System.out.println("7. Calculate & Display Rental Fee for a Renter");
			System.out.println("8. Display Renter Details");
			System.out.println("9. Remove Renter from CRMS");
			System.out.println("10. Add Insaurance");
			System.out.println("11. Calculate & Display Rental Fee with Insaurance");
			System.out.println("12. Calculate & Display Damage Cost");
			System.out.println("13. Exit");
			System.out.println("Choice: ");
			choice=input.nextInt();
			switch(choice) {
			case 1:{
				crms.displayAvailabeCars();
				break;
			}
			case 2:{
		        System.out.println("Enter car type: (Compact/SUV/Luxury)");
		        String type=stringInput.next();
		        while(!type.equalsIgnoreCase("Compact")&& !type.equalsIgnoreCase("SUV")&& !type.equalsIgnoreCase("Luxury")) {
		        	System.out.println("Invalid input. Please try again.");
		        	type=stringInput.next();
		        }
		        stringInput.nextLine();
		        if(type.equalsIgnoreCase("Compact")) { //creating compact car
		        	Compact car=new Compact();
			        System.out.println("Enter car brand: ");
			        car.setCarBrand(stringInput.nextLine());
			        stringInput.nextLine();
			        System.out.println("Enter car model: ");
			        car.setCarModel(stringInput.nextLine());
			        System.out.println("Enter car plate No: ");
			        car.setCarPlateNo(stringInput.nextLine());
			        System.out.println("Enter car year: ");
			        car.setCarYear(input.nextInt());
			        input.nextLine();
			        System.out.println("Enter the rental status of car: (1 or 0)");
			        if(input.nextInt()==1) {
			        	car.setCarRentalStatus(true);
			        }
			        else {
			        	car.setCarRentalStatus(false);	
			        }
			        crms.addCar(car);
			        break;
		        }
		        else if(type.equalsIgnoreCase("SUV")) { //creating SUV car
		        	SUV car=new SUV();
		        	System.out.println("Enter car brand: ");
			        car.setCarBrand(stringInput.nextLine());
			        stringInput.nextLine();
			        System.out.println("Enter car model: ");
			        car.setCarModel(stringInput.nextLine());
			        System.out.println("Enter car plate No: ");
			        car.setCarPlateNo(stringInput.nextLine());
			        System.out.println("Enter car year: ");
			        car.setCarYear(input.nextInt());
			        input.nextLine();
			        System.out.println("Enter the rental status of car: (1 or 0)");
			        if(input.nextInt()==1) {
			        	car.setCarRentalStatus(true);
			        }
			        else {
			        	car.setCarRentalStatus(false);	
			        }
			        crms.addCar(car);
			        break;
		        }
		        else if(type.equalsIgnoreCase("Luxury")) { //creating luxury car
		        	Luxury car=new Luxury();
		        	System.out.println("Enter car brand: ");
			        car.setCarBrand(stringInput.nextLine());
			        stringInput.nextLine();
			        System.out.println("Enter car model: ");
			        car.setCarModel(stringInput.nextLine());
			        System.out.println("Enter car plate No: ");
			        car.setCarPlateNo(stringInput.nextLine());
			        System.out.println("Enter car year: ");
			        car.setCarYear(input.nextInt());
			        input.nextLine();
			        System.out.println("Enter the rental status of car: (1 or 0)");
			        if(input.nextInt()==1) {
			        	car.setCarRentalStatus(true);
			        }
			        else {
			        	car.setCarRentalStatus(false);	
			        }
			        crms.addCar(car);
			        break;
		        }
		        
				break;
			}
			case 3:{
		        System.out.println("Enter plate No of the car: ");
		        String plate=stringInput.next();
		        crms.removeCar(plate);
				break;
			}
			case 4:{
				System.out.println("Enter renter type: (Regular/Frequent/Corporate)"); 
				String type=stringInput.next();
				while(!type.equalsIgnoreCase("Regular")&& !type.equalsIgnoreCase("Frequent")&& !type.equalsIgnoreCase("Corporate")) {
		        	System.out.println("Invalid input. Please try again.");
		        	type=stringInput.next();
		        }
				stringInput.nextLine();
				if(type.equalsIgnoreCase("Regular")) { //creating regular renter object
					RegularRenter renter=new RegularRenter(); 
					System.out.println("Enter renter name: ");
					renter.setRenterName(stringInput.nextLine());
					stringInput.nextLine();
					System.out.println("Enter renter phone No: ");
					renter.setRenterPhoneNo(input.nextLong());
					System.out.println("Enter renter email: ");
					renter.setRenterEmail(stringInput.nextLine());
					System.out.println("Enter renter address: ");
					renter.setRenterAddress(stringInput.nextLine());
					crms.addRenter(renter);
				}
				else if(type.equalsIgnoreCase("Frequent")) { //creating frequent renter object
					FrequentRenter renter=new FrequentRenter();
					System.out.println("Enter renter name: ");
					renter.setRenterName(stringInput.nextLine());
					System.out.println("Enter renter phone No: ");
					renter.setRenterPhoneNo(input.nextLong());
					System.out.println("Enter renter email: ");
					renter.setRenterEmail(stringInput.nextLine());
					System.out.println("Enter renter address: ");
					renter.setRenterAddress(stringInput.nextLine());
					crms.addRenter(renter);
				}
				else if(type.equalsIgnoreCase("Corporate")) { //creating corporate renter
					CorporateRenter renter=new CorporateRenter();
					System.out.println("Enter renter name: ");
					renter.setRenterName(stringInput.nextLine());
					System.out.println("Enter renter phone No: ");
					renter.setRenterPhoneNo(input.nextLong());
					System.out.println();
					System.out.println("Enter renter email: ");
					renter.setRenterEmail(stringInput.nextLine());
					System.out.println("Enter renter address: ");
					renter.setRenterAddress(stringInput.nextLine());
					crms.addRenter(renter);
				}
				
				break;
			}
			case 5:{
				stringInput.nextLine();
				System.out.println("Enter car plate No: ");
				String plateNo=stringInput.nextLine();
				input.nextLine();
				System.out.println("Enter renter ID: ");
				int id=input.nextInt();
				input.nextLine();
				crms.rentCar(plateNo, id);
				break;
			}
			case 6:{
				System.out.println("Enter car plate No: ");
				String plateNo=stringInput.nextLine();
				System.out.println("Enter renter ID: ");
				int id=input.nextInt();
				input.nextLine();
				System.out.println("Enter distance covered by the car: (in miles)");
		    	double distance=input.nextDouble();
		    	crms.returnCar(plateNo, id, distance);
				break;
			}
			case 7:{
				System.out.println("Enter the renter ID: ");
				int id=input.nextInt();
				input.nextLine();
				crms.setDistancesCovered(id);
				for(Renter renter: crms.renters) {
					if(renter.getRenterID()==id) {
						if(renter.getRenterType().equalsIgnoreCase("Regular")) { //for regular renter
							System.out.println("Total Rental Cost for renter "+id+" is: $"+renter.calculateTotalRentalFee());
						}
						else if(renter.getRenterType().equalsIgnoreCase("Frequent")) { //for frequent
							FrequentRenter freq=new FrequentRenter();
							freq=(FrequentRenter)renter;
							System.out.println("Enter type of frequent renter: (Daily/Weekly/Monthly)"); //taking frequent renter type
							freq.setRenterType(stringInput.nextLine());
							System.out.println("Total Rental Cost for renter "+id+" is: $"+renter.calculateTotalRentalFee());
						}
						else if(renter.getRenterType().equalsIgnoreCase("Corporate")) { //for corporate renter
							CorporateRenter corp=new CorporateRenter();
							corp=(CorporateRenter)renter;
							System.out.println("Enter number of cars in package: "); //taking number of cars taken by the renter
							corp.setNumOfCars(input.nextInt());
							System.out.println("Total Rental Cost for renter "+id+" is: $"+renter.calculateTotalRentalFee());
						}
						
						break;
					}
				}
				break;
			}
			case 8:{
				crms.displayRenterDetails(); 
				break;
			}
			case 9:{
				System.out.println("Enter the renter ID: ");
				int id=input.nextInt();
				input.nextLine();
				crms.removeRenter(id);
				break;
			}
			case 10:{
				System.out.println("Enter car plate No: ");
				String plateNo=stringInput.nextLine();
				System.out.println("Enter renter ID: ");
				int id=input.nextInt();
				input.nextLine();
				crms.addInsaurance(plateNo, id);
				break;
			}
			case 11:{
				System.out.println("Enter the renter ID: ");
				int id=input.nextInt();
				input.nextLine();
				crms.setDistancesCovered(id);
				for(Renter renter: crms.renters) {
					if(renter.getRenterID()==id) {
						if(renter.getRenterType().equalsIgnoreCase("Regular")) { //for regular
							System.out.println("Total Rental Cost for renter "+id+" is: $"+renter.calculateTotalRentalFeeWithInsaurance());
						}
						else if(renter.getRenterType().equalsIgnoreCase("Frequent")) { //for frequent
							FrequentRenter freq=new FrequentRenter();
							freq=(FrequentRenter)renter;
							System.out.println("Enter type of frequent renter: (Daily/Weekly/Monthly)");
							freq.setRenterType(stringInput.nextLine());
							System.out.println("Total Rental Cost for renter "+id+" is: $"+renter.calculateTotalRentalFeeWithInsaurance());
						}
						else if(renter.getRenterType().equalsIgnoreCase("Corporate")) { //for corporate
							CorporateRenter corp=new CorporateRenter();
							corp=(CorporateRenter)renter;
							System.out.println("Enter number of cars in package: ");
							corp.setNumOfCars(input.nextInt());
							System.out.println("Total Rental Cost for renter "+id+" is: $"+renter.calculateTotalRentalFeeWithInsaurance());
						}
						break;
					}
				}
				break;
			}
			case 12:{
				System.out.println("Enter car plate No: ");
				String plateNo=stringInput.nextLine();
				System.out.println("Enter renter ID: ");
				int id=input.nextInt();
				input.nextLine();
				crms.calculateDamageCost(plateNo, id);
				break;
			}
			case 13:{
				System.out.println("Exiting the program...");
				return;
			}
			default:{
				System.out.println("Invalid Choice!");
				break;
			}
			}
		}while(choice!=13);
	}
	
}
