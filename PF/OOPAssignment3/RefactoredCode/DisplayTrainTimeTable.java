import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Sumitra this class contain the methods used to print the chart and to
 *         book the ticket and for payment.
 */
public class DisplayTrainTimeTable {

	@SuppressWarnings("unchecked")
	/**
	 * 
	 * @param type is to selected either the train is passenger or goods train
	 */
	void displayPassenger() {
		int i = 0;
		{
			Collections.sort(FetchFromFile.passengerList, new TimeComparator());
			Iterator<PassengerTrain> itrb = FetchFromFile.passengerList
					.iterator();
			while (itrb.hasNext()) {
				PassengerTrain passenger = itrb.next();
				if (i == 0) {
					// if user selected to travel by passenger.
					System.out
							.println("TRAIN NUMBER 		SOURCE		DESTINATION		TIME		SEATS		PRICE");
					i++;
				}
				System.out.println(passenger.getTrainNumber() + "		"
						+ passenger.getSource() + " 		"
						+ passenger.getDestination() + " 			"
						+ passenger.getTime() + " 		"
						+ passenger.getAvailable()+" 		"+ passenger.getPrice());

			}
		}
	}

	@SuppressWarnings("unchecked")
	void displayGoods() {
		// if user selected to send weight by goods train.
		Collections.sort(FetchFromFile.goodsList, new TimeComparatorForGoods());
		int i = 0;
		Iterator<GoodsTrain> itrb = FetchFromFile.goodsList.iterator();
		while (itrb.hasNext()) {
			GoodsTrain goods = itrb.next();
			if (i == 0) {
				System.out
						.println("TRAIN NUMBER		SOURCE 		DESTINATION		TIME		SEATS		PRICE");
				i++;
			}
			System.out.println(goods.getTrainNumber() + " 		"
					+ goods.getSource() + " 		" + goods.getDestination()
					+ " 			" + goods.getTime() + " 		" + goods.getavailable()
					+ " 		" + goods.getPrice());

		}
	}

	/**
	 * 
	 * @param type
	 *            passenger or goods train
	 * @param source
	 *            form where we have to travel
	 * @param destination
	 *            from where we have to reach
	 * @param wanted
	 *            no of seats u want to book
	 * @param user
	 *            the object of user to print whole information
	 */
	Scanner scanner = new Scanner(System.in);

	void requiredPassengerTrain(String source, String destination, int wanted,
			UserInformation user)

	{
		int i = 0;
		int flag = 0;
		Iterator<PassengerTrain> itr = FetchFromFile.passengerList.iterator();
		while (itr.hasNext()) {
			PassengerTrain passenger = itr.next();
			if (source.equalsIgnoreCase(passenger.getSource())
					&& destination.equalsIgnoreCase(passenger.getDestination())) {
				// if the train is available from source to destination
				if (i == 0) {
					System.out
							.println("Train Number 		SOURCE 		DESTINATION		TIME		SEATS		PRICE");
					i++;
				}
				System.out.println(passenger.getTrainNumber() + "		 "
						+ passenger.getSource() + "		 " + passenger.getDestination()
						+ " 		" + passenger.getTime() + " 		" +passenger.getAvailable()
						+ " 		" + passenger.getPrice());
				flag = 1;
			}
		}
		if (flag == 1) {
			bookPassengerTrain(source,destination,flag,user,wanted);
		} else {
			System.out.println("no trains available");
		}

	}

	void requiredGoodsTrain(String source, String destination, int wanted,
			UserInformation user) {
		int i = 0;
		int flag = 0;
		Iterator<GoodsTrain> itr = FetchFromFile.goodsList.iterator();
		while (itr.hasNext()) {
			GoodsTrain goods = itr.next();
			if (source.equalsIgnoreCase(goods.getSource())
					&& destination.equalsIgnoreCase(goods.getDestination())) {
				// if the train is available from source to destination
				if (i == 0) {
					System.out
							.println("Train Number 		SOURCE 		DESTINATION		TIME		SEATS		PRICE");
					i++;
				}
				System.out.println(goods.getTrainNumber() + "		 "
						+ goods.getSource() + "		 " + goods.getDestination()
						+ " 		" + goods.getTime() + " 		" + goods.getavailable()
						+ " 		" + goods.getPrice());
				flag = 1;
			}
		}
		if (flag == 1) 
			{
			bookGoodsTrain(source,destination,flag,user,wanted);
			}
		else {
			}
			System.out.println("no trains available");
		}

	

	void paymentMethod(int choice, Train train, UserInformation user) {
		Payment pay = new Payment();
		if (choice == 1) {
			pay.creditCard(user.getWantedSeat() * train.getPrice());
		} else if (choice == 2) {
			pay.wallet(user.getWantedSeat() * train.getPrice());
		} else if (choice == 3) {
			pay.netBanking(user.getWantedSeat() * train.getPrice());
		} else {
			System.out.println("you enterd a wrong choice");
		}

	}
	void printDetail(UserInformation user,Train train)
	{
		System.out.println("----DETAILS--------");
		System.out.println("NAME---			" + user.getName());
		System.out.println("TYPE---			passenger");
		System.out.println("SOURCE---		" + user.getTo());
		System.out.println("DESTINATION---		" + user.getFrom());
		System.out
				.println("SEATS--- 		" + user.getWantedSeat());
		System.out.println("AMOUNT--- 		"
				+ user.getWantedSeat() * train.getPrice());
	}


void bookPassengerTrain(String source,String destination,int flag,UserInformation user,int wanted)
{
	
	// if train is available
				Iterator<PassengerTrain> itrt = FetchFromFile.passengerList.iterator();

				System.out
						.println("enter the Train number in which you want to travel");
				int trainNum = scanner.nextInt();
				while (itrt.hasNext()) {

					PassengerTrain passenger = itrt.next();

					if (source.equalsIgnoreCase(passenger.getSource())
							&& destination.equalsIgnoreCase(passenger.getDestination())
							&& trainNum ==passenger.getTrainNumber()) {
						// if train is available and correct train number is
						// inserted.
						flag = 2;
						System.out.println("no of seat/weight you want to send");
						wanted = scanner.nextInt();

						user.setWantedSeat(wanted);
						if (0 <= passenger.getAvailable() - user.getWantedSeat()) {
							// if weight to be sent is possible
							passenger.setAvailable(passenger.getAvailable()
									- user.getWantedSeat());
							flag = 3;
							MenuList menu = new MenuList();
							System.out
									.println("know you can proceed for payment you seats are available");
							menu.displayPaymentMenu();
							int choice = scanner.nextInt();
							paymentMethod(choice, passenger, user);
							printDetail(user,passenger);
						} else {
							// if weight to be tranfered is not available then he
							// can again select the train.
							System.out.println("seats are not available");
							System.out.println("You can select another train");
							requiredGoodsTrain(source, destination, wanted, user);
						}
					}

				}
				if (flag != 2 && flag != 3) {
					// if the train number is not correct then he can again select
					// the train
					System.out.println("no trains are available of this number");
					System.out.println("You can select another train");
					requiredGoodsTrain(source, destination, wanted, user);
				}

}
void bookGoodsTrain(String source,String destination,int flag,UserInformation user,int wanted)
{
	// if train is available
	Iterator<GoodsTrain> itrt = FetchFromFile.goodsList.iterator();

	System.out
			.println("enter the Train number in which you want to travel");
	int trainNum = scanner.nextInt();
	while (itrt.hasNext()) {

		GoodsTrain goods = itrt.next();

		if (source.equalsIgnoreCase(goods.getSource())
				&& destination.equalsIgnoreCase(goods.getDestination())
				&& trainNum == goods.getTrainNumber()) {
			// if train is available and correct train number is
			// inserted.
			flag = 2;
			System.out.println("no of seat/weight you want to send");
			wanted = scanner.nextInt();

			user.setWantedSeat(wanted);
			if (0 <= goods.getavailable() - user.getWantedSeat()) {
				// if weight to be sent is possible
				goods.setavailable(goods.getavailable()
						- user.getWantedSeat());
				flag = 3;
				MenuList menu = new MenuList();
				System.out
						.println("know you can proceed for payment you seats are available");
				menu.displayPaymentMenu();
				int choice = scanner.nextInt();
				paymentMethod(choice, goods, user);
				printDetail(user,goods);
			} else {
				// if weight to be tranfered is not available then he
				// can again select the train.
				System.out.println("seats are not available");
				System.out.println("You can select another train");
				requiredGoodsTrain(source, destination, wanted, user);
			}
		}

	}
	if (flag != 2 && flag != 3) {
		// if the train number is not correct then he can again select
		// the train
		System.out.println("no trains are available of this number");
		System.out.println("You can select another train");
		requiredGoodsTrain(source, destination, wanted, user);
	}

}
}
