# AffinitasPersonalityTest
Android Source Code for the Affinitas Code Challenge. This project aims to solve the Affinitas Personality Test Code Challenge. It is written in Kotlin.

Code Design and Architectural Solution

	The framework made for this challenge was initially made with the MVP pattern in mind. It also abides in CLEAN Architecture with SOLID principles (To meet up the universal rules requirements). Unit testing were also created for checking business and logic rules.

Requirements Fullfilled:
  
    •	Once the user opens the app. The app will call the [**REST Api**] (https://raw.githubusercontent.com/affinitas/coding_exercises_options/master/personality_test/database/personality_test.json) to get the JSON File.
	
    •	Then, the mapper will map the response to a POJO class to be used all throughout the duration of the app.
    
    •	The questions will then be displayed thru a simple viewpager. One question is displayed and it is swipeable with a view pager. 
    
    •	The simple drop down category will be displayed on top of the screen just below the toolbar. This category is taken also from the REST Api. 
    
    •	Once the answers were chosen, it will be automatically saved/edited in the local database. And will be seen once the app is reopened.
    
    •	The app can handle rotation and scalable for tablets.
	
Libraries Used:
	
	Kotlin 
	Retrofit 
	Dagger 2
	RxJava
	Realm
	Jackson

Classes Used:

Config:	- handles the class dependcies and main application class.
	MainApplication
	
	Dagger Components: 
		Application Component 
		Activities Component 
	
	Dagger Modules:
		ExecutorsModule
		InteractorModule
		MapperModule
		RepositoryModule
		ServiceModule
				
Interactor : - handles business logic CLEAN layer. Not needed for this application so it merely transfers the required views and database from the presenter to repository.
				
	QuestionnaireInteractor
	QuestionnaireInteractorImpl
				
Mapper : - handles the mapping of the response to the business objects. 

	DataMapper - mapper interface
	PersonalityTestMapper - DataMapper implementation. Trasforms the response object to a business object.
				
Models : - handles all the stored objects to used all over the app

	QuestionItem - holds the questions coming from the REST api.
	AnswerKey - holds the answers user chose
	Category - holds the category each question type would have. Mirrors the JSON Response
	QuestionType - holds the type of questions each QuestionItem . Mirros the JSON Response		

Repositories : - handles the data source CLEAN layer. 

	QuestionnaireRepository - repository interface
	QuestionnaireRepositoryImpl - QuestionnaireRepository implementation
	RealmAnswerKey - holds the database object from Realm. 

Rest : - part of the data source CLEAN layer that handles the classes needed for the REST Api. 

	PersonalityTestWrapper - holds the response object from REST Api. 
	QuestionnaireRest - the interface that will implemented by Retrofit for the REST Api endpoint. 
				
Schedulers :- handles thread Scheduling for the REST calls. 

	ObserveOnScheduler - thread class used for handling RxJava observation thread.
	ThreadScheduler - interface scheduler

Services :- handles the services to be used for the app. Such as the database

	ServiceManager - service class interface
	ServiceManagerImpl - service class implementation
	DatabaseService - database service class interface
	RealmDatabase - database service class implementation that uses Realm. 
				
UI :- ui class that handles the views for the app 

	MainActivity - activity class used for viewing the responses and behavior of the app. 
	MainPagerAdapter - pager adapter class to handle the swipeable question views
	MainPresenter - handles the decison making on which view will be seen on the activity
	MainView - a callback interface that is used by the presenter to show which views will be used. 

