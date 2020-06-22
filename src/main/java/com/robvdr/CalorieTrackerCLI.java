package com.robvdr;

import org.apache.commons.dbcp2.BasicDataSource;

import com.robvdr.model.FoodDAO;
import com.robvdr.model.jdbc.JDBCFoodDAO;
import com.robvdr.caloriecounter.view.Menu;

public class CalorieTrackerCLI {
	private static final String MAIN_MENU_OPTION_FOODS = "Food Database";
	private static final String MAIN_MENU_OPTION_LOG = "Daily Log";
	private static final String MAIN_MENU_OPTION_BMR = "BMR Calculator";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = new String[] { MAIN_MENU_OPTION_FOODS,
																	 MAIN_MENU_OPTION_LOG, 
																	 MAIN_MENU_OPTION_BMR, 
																	 MAIN_MENU_OPTION_EXIT};
	
	private static final String MENU_OPTION_RETURN_TO_MAIN = "Return to main menu";
	
	private static final String FOOD_MENU_OPTION_ALL_FOODS = "Show all foods in database";
	private static final String FOOD_MENU_OPTION_ADD_FOOD = "Add a new food";
	private static final String FOOD_MENU_OPTION_SEARCH = "Search database for food";
	private static final String FOOD_MENU_OPTION_MODIFY = "Edit an existing food";
	private static final String FOOD_MENU_OPTION_DELETE = "Delete an unused food from the database";
	private static final String[] FOOD_MENU_OPTIONS = new String[] { FOOD_MENU_OPTION_ALL_FOODS,
																	 FOOD_MENU_OPTION_ADD_FOOD,
																	 FOOD_MENU_OPTION_SEARCH,
																	 FOOD_MENU_OPTION_MODIFY,
																	 FOOD_MENU_OPTION_DELETE,
																	 MENU_OPTION_RETURN_TO_MAIN}; 
	
	private static final String LOG_MENU_OPTION_ENTER_NEW = "Enter new food log";
	private static final String LOG_MENU_OPTION_SHOW_TOTALS = "Show totals for a day";
	private static final String LOG_MENU_OPTION_DELETE_ENTRY = "Delete food entry";
	private static final String[] LOG_MENU_OPTIONS = new String[] {LOG_MENU_OPTION_ENTER_NEW,
																   LOG_MENU_OPTION_SHOW_TOTALS,
																   LOG_MENU_OPTION_DELETE_ENTRY,
																   MENU_OPTION_RETURN_TO_MAIN};
	
	private static final String BMR_MENU_OPTION_CALCULATE_BMR = "Calculate BMR";
	private static final String[] BMR_MENU_OPTIONS = new String[] {BMR_MENU_OPTION_CALCULATE_BMR,
																   MENU_OPTION_RETURN_TO_MAIN};
	
	private Menu menu;
	private FoodDAO foodDAO;
	
	public static void main(String[] args) {
		CalorieTrackerCLI application = new CalorieTrackerCLI();
		application.run();
	}
	
	public CalorieTrackerCLI() {
		this.menu = new Menu(System.in, System.out);
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/calories");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		foodDAO = new JDBCFoodDAO(dataSource);
	}
	
	//main menu
	private void run() {
		while(true) {
			System.out.println("Main Menu");
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if(choice.equals(MAIN_MENU_OPTION_FOODS)) {
				handleFoods();
			} else if (choice.equals(MAIN_MENU_OPTION_LOG)) {
				handleLog();
			} else if (choice.equals(MAIN_MENU_OPTION_BMR)) {
				handleBMR();
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.exit(0);
			}
		}
	}
	
	//food database sub-menu
	private void handleFoods() {
		System.out.println("Food Database");
		String choice = (String)menu.getChoiceFromOptions(FOOD_MENU_OPTIONS);
		if(choice.equals(FOOD_MENU_OPTION_ALL_FOODS)) {
			//handleListAllFoods();
		} else if (choice.equals(FOOD_MENU_OPTION_ADD_FOOD)) {
			//handleAddFood();
		} else if (choice.equals(FOOD_MENU_OPTION_SEARCH)) {
			//handleSearchFoodDatabase();
		} else if (choice.equals(FOOD_MENU_OPTION_MODIFY)) {
			//handleModifyFood();
		} else if (choice.equals(FOOD_MENU_OPTION_DELETE)) {
			//handleDeleteFood();
		}
	}
	
	//daily log sub-menu
	private void handleLog() {
		System.out.println("Daily Log");
		String choice = (String)menu.getChoiceFromOptions(LOG_MENU_OPTIONS);
		if(choice.equals(LOG_MENU_OPTION_ENTER_NEW)) {
			//handleEnterNewLog();
		} else if (choice.equals(LOG_MENU_OPTION_SHOW_TOTALS)) {
			//handleShowDayTotals();
		} else if (choice.equals(LOG_MENU_OPTION_DELETE_ENTRY)) {
			//handleDeleteLogEntry();
		}
	}
	
	//BMR sub-menu
	private void handleBMR() {
		System.out.println("BMR Calculator");
		String choice = (String)menu.getChoiceFromOptions(BMR_MENU_OPTIONS);
		if(choice.equals(BMR_MENU_OPTION_CALCULATE_BMR)) {
			//handleCalculatBMR
		}
	}
}
