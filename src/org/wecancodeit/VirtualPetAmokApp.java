package org.wecancodeit;

import java.util.Collection;

import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;

public class VirtualPetAmokApp {

	public static void main(String[] args) {

		String userName = "";
		String response = "";

		boolean yesNo = true;
		int shelterCageID = 0;

		Scanner userInput = new Scanner(System.in);
		QuestionApp asker = new QuestionApp(userInput);
		VirtualPetShelter petShelter = new VirtualPetShelter();
		Dog dog1 = new Dog("Hazel", "likes to pee on people!");
		Dog dog2 = new Dog("Bella", "is so hyper!");

		RoboDog roboDog1 = new RoboDog("Zeus", "likes to eat shoes!");

		Cat cat1 = new Cat("Garfield", "is lazy and hates mondays");
		Cat cat2 = new Cat("Sauron", "wants to take over middle earth!");

		RoboCat roboCat1 = new RoboCat("Felix", "has flees!");

		Cage cage1 = new Cage(shelterCageID++);
		Cage cage2 = new Cage(shelterCageID++);
		Cage cage3 = new Cage(shelterCageID++);
		LitterBox litterBox = new LitterBox(shelterCageID++);
		
		cage1.addPet(dog1);
		cage2.addPet(dog2);
		cage3.addPet(roboDog1);
		litterBox.addPet(cat1);
		litterBox.addPet(cat2);
		litterBox.addPet(roboCat1);
		petShelter.addToShelter(cage1.getBoxID(), cage1);
		petShelter.addToShelter(cage2.getBoxID(), cage2);
		petShelter.addToShelter(cage3.getBoxID(), cage3);
		petShelter.addToShelter(litterBox.getBoxID(), litterBox);

		Map<String, VirtualPet> petCollection = new HashMap<String, VirtualPet>();

		for(VirtualPet pet : petShelter.getAllPets()) {

			petCollection.put(pet.getPetName(), pet);

		}

		userName = asker.verifyString("Hello, what is your first name?");

		System.out.println("\nWelcome " + userName + " to Dylan's wackey Animal Rescue Shelter!"
				+ " Thank you for Stopping by!"
				+ "\nAll we ask is that you care for our wild ones by simply keeping them"
				+ " happy\nby feeding, walking,"
				+ " playing with them and keeping their cages and\nlitter box tidy\n");

		yesNo = asker.yesOrNo("Let's meet the animals shall we (Y or N)?");

		if (yesNo) {

			System.out.println(userName + ", let me introduce you to our magnificant animals...");
			petShelter.introducePets();			

		} else {

			System.out.println("Well, better luck next time!");
			System.exit(0);

		}

		System.out.println("\nTo interact with the animals hit enter...");

		response = userInput.nextLine();

		if (response.toLowerCase().equals("quit") || response.toLowerCase().equals("exit") || response.toLowerCase().equals("q")) {
			System.exit(0);

		}

		while (true) {

			petShelter.allPetStatus();
			System.out.println("What would you like to do (1 - 6)?\n");
			System.out.println(" 1. Feed the pets\t\t6. Clean the litter box"
					   + "\n 2. Water the pets\t\t7. Oil all RoboPets"
					   + "\n 3. Play with a pet\t\t8. Adopt a pet"
					   + "\n 4. Walk the Dogs\t\t9. Admit a pet"
					   + "\n 5. Clean dog cage(s)\t\t10. Quit");

			response = userInput.nextLine();

			switch(response) {

			case "1" : 

				petShelter.feedAllPets();

				break;

			case "2" : 

				petShelter.waterAllPets();

				break;

			case "3":
				
				while(true) {

					System.out.println("Roger that boss! Who would you like to play with? Type their name or \"Quit\" to cancel:");

					petShelter.introducePets();	
					response = userInput.nextLine();

					if(response.toLowerCase().equals("quit")) {							

						break; 

					} else if (petShelter.getAllPets().contains(petCollection.get(response))){	

						petShelter.playWith(response);

						break;

					} else {

						System.out.println("Schreeeeeeching!!!! Please I only accept valid responses.");

						continue;

					}
				}

				break;

			case "4" :

				petShelter.walkAllDogs();

				break;

			case "5" : 

				Collection<Dog> dogs = petShelter.getAllShelterDogs();

				for (Dog dog : dogs) {

					System.out.println(dog.getPetName() + "'s Cage: " + dog.getPetBoxID());

				}

				boolean continueClean = true;

				while (continueClean) {

					System.out.println("Which cage would you like to clean? " + "\n Enter cage id or type 'All' to clean all cages.");
					response = userInput.nextLine();

					if (response.toLowerCase().equals("all")) { 

						petShelter.cleanAllCages();

						break;

					} else if (response.toLowerCase().equals("quit") || response.toLowerCase().equals("q") 

							|| response.toLowerCase().equals("exit")) {

						break;

					} else {

						try {

							int cageID = Integer.parseInt(response); 

							petShelter.cleanCage(cageID);	

							break;

						} catch ( NumberFormatException e){

							System.out.println("Schreeeeeeching!!!! Please I only accept valid responses.");
							continue;

						} 
					} 
				} 

				break;

			case "6": 	

				petShelter.cleanAllLitterBoxes();

				break;

			case "7": 

				petShelter.oilAllRobots();

				break;
				
			case "8":

				System.out.println("I knew I was right about you!");
				System.out.println("I'm great at reading perople!");
				System.out.println(" Who would you like to adopt? Type their name or \"Quit\" to cancel");

				boolean selectionMade = false;

				while (!selectionMade) {

					petShelter.introducePets();
					response = userInput.nextLine();

					if(response.toLowerCase().equals("quit")) {

						break;

					} else if (petShelter.getAllPets().contains(petCollection.get(response))) {

						System.out.println("I think " + petCollection.get(response).getPetName() + " and you will rock out every day!");
						petShelter.adoptPet(response);
						selectionMade = true;

						break;

					} else {

						System.out.println("Please pick a name from the list or 'quit'. Thank you.");

					}
				} 

				break;				

				

			case "9":

				System.out.println("Please select the type of animal to admit... ");
				System.out.println("1. Cat\t\t3. RoboCat" + "\n2. Dog\t\t4. RoboDog");
				String newPetType = userInput.nextLine();
				String newPetName = asker.verifyString("Please choose a name for our new guest...");
				System.out.println("Please give a brief description of our new guest...");
				String newPetDescription = userInput.nextLine();
				VirtualPet newPet;
				Cage newCage;

				switch (newPetType.toLowerCase()) {

				case "1": 

					newPet = new Cat(newPetName, newPetDescription);
					litterBox.addPet(newPet);

					break;

				

				case "2": 

					newPet = new Dog(newPetName, newPetDescription);
					newCage = new Cage(shelterCageID++);
					newCage.addPet(newPet);
					petShelter.addToShelter(newCage.getBoxID(), newCage);

					break;

				

				case "3":

					newPet = new RoboCat(newPetName, newPetDescription);
					litterBox.addPet(newPet);

					break;

				case "4":

					newPet = new RoboDog(newPetName, newPetDescription);
					newCage = new Cage(shelterCageID++);
					newCage.addPet(newPet);
					petShelter.addToShelter(newCage.getBoxID(), newCage);

					break;

				case "quit": 

					break;

				default:

					System.out.println("Please select from the list or type \"Quit\".");

				} 

				System.out.println(newPetName + ", we're all family here!");

				break;				

			case "10": 

				userInput.close();

				System.out.println("Thank you come again " + userName + "!");

				System.exit(0);

				break;

			default :

				System.out.println("Please make a valid selection (1 - 6)");

			}

			petShelter.runAllTicks();

		} 
	}
} 