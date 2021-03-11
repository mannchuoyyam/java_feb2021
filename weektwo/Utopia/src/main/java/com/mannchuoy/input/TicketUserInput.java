/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.input;

import java.util.List;
import java.util.Scanner;

import com.mannchuoy.entity.Ticket;

/**
 * @author Mannchuoy Yam
 *
 */
public class TicketUserInput extends BaseUserInput{
	
	public TicketUserInput(Scanner scanner) {
		super(scanner);
	}
	
	public Ticket getSelectedTicket(List<Ticket> tickets) {
		String prompt = "Select one of the ticket from option above:";
		int indexStartAt = 1;
		int indexEndAt = tickets.size();

		int option = selectAnOption(indexStartAt, indexEndAt, prompt);

		// adjust to 0 base index
		int selectedIndex = option - 1;

		return tickets.get(selectedIndex);
	}
	
	public int getIndex(int max, String prompt) {
		String input = null;
		int index = -1;
		int QUIT = -1;
		int NO_CHANGE = -2;
		
		while (input == null) {
			print(prompt);
			input = scanner.nextLine();
			if (input.toLowerCase().equals("quit")) {
				return QUIT;
			} else if (input.toLowerCase().equals("n/a")) {
				return NO_CHANGE;
			}else {
				try {
					index = Integer.valueOf(input);
					if(index < 1 || index > max) {
						input = null;
					}
				}catch(NumberFormatException e) {
					println("Choose between 1 - " + max);
					input = null;
				}
			}
		}
		
		return index;
	}
}
