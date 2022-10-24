package net.efrei.ws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.efrei.ws.database.DataBase;
import net.efrei.ws.model.Book;
import net.efrei.ws.model.Item;
import net.efrei.ws.model.Movie;
import net.efrei.ws.model.Videogame;

public class ItemService {

	private Map<String, Item> items = DataBase.getItems();
	
	public ItemService() {
		items.put("To kill a mockingbird",
				new Book(1L,
				"To kill a mockingbird", 
				"The unforgettable novel of a childhood in a sleepy Southern town and the crisis of conscience that rocked it. \"To Kill A Mockingbird\" became both an instant bestseller and a critical success when it was first published in 1960. It went on to win the Pulitzer Prize in 1961 and was later made into an Academy Award-winning film, also a classic.",
				"Harper Lee",
				"Drama",
				2006));
		items.put("Harry Potter and the Sorcerer's Stone",
				new Book(2L,
				"Harry Potter and the Sorcerer's Stone", 
				"Harry Potter has no idea how famous he is. That's because he's being raised by his miserable aunt and uncle who are terrified Harry will learn that he's really a wizard, just as his parents were. But everything changes when Harry is summoned to attend an infamous school for wizards, and he begins to discover some clues about his illustrious birthright. From the surprising way he is greeted by a lovable giant, to the unique curriculum and colorful faculty at his unusual school, Harry finds himself drawn deep inside a mystical world he never knew existed and closer to his own noble destiny.",
				"J.K Rowling",
				"Fantasy",
				2003));
		items.put("Pride and Prejudice",
				new Book(3L,
				"Pride and Prejudice", 
				"Since its immediate success in 1813, Pride and Prejudice has remained one of the most popular novels in the English language. Jane Austen called this brilliant work \"her own darling child\" and its vivacious heroine, Elizabeth Bennet, \"as delightful a creature as ever appeared in print.\" The romantic clash between the opinionated Elizabeth and her proud beau, Mr. Darcy, is a splendid performance of civilized sparring. And Jane Austen's radiant wit sparkles as her characters dance a delicate quadrille of flirtation and intrigue, making this book the most superb comedy of manners of Regency England.",
				"Jane Austen",
				"Drama",
				2000));
		items.put("The Diary of a Young Girl",
				new Book(4L,
				"The Diary of a Young Girl", 
				"In 1942, with the Nazis occupying Holland, a thirteen-year-old Jewish girl and her family fled their home in Amsterdam and went into hiding. For the next two years, until their whereabouts were betrayed to the Gestapo, the Franks and another family lived cloistered in the “Secret Annexe” of an old office building. Cut off from the outside world, they faced hunger, boredom, the constant cruelties of living in confined quarters, and the ever-present threat of discovery and death. In her diary Anne Frank recorded vivid impressions of her experiences during this period. By turns thoughtful, moving, and surprisingly humorous, her account offers a fascinating commentary on human courage and frailty and a compelling self-portrait of a sensitive and spirited young woman whose promise was tragically cut short.",
				"Anne Frank",
				"History",
				1993));
		items.put("The Little Prince",
				new Book(5L,
				"The Little Prince", 
				"A pilot stranded in the desert awakes one morning to see, standing before him, the most extraordinary little fellow. \"Please,\" asks the stranger, \"draw me a sheep.\" And the pilot realizes that when life's events are too difficult to understand, there is no choice but to succumb to their mysteries. He pulls out pencil and paper... And thus begins this wise and enchanting fable that, in teaching the secret of what is really important in life, has changed forever the world for its readers.",
				"Antoine de Saint-Exupéry",
				"Philosophy",
				2000));
		items.put("Le Parrain",
				new Movie(6L,
				"Le Parrain", 
				"Le patriarche vieillissant d'une dynastie de la mafia New Yorkaise passe le flambeau de son empire clandestin à son fils réticent.",
				"2h55",
				"Francis Ford Coppola",
				"Al Pacino, James Caan, Marlon Brando",
				1972));
		items.put("The Dark Knight: Le Chevalier Noir",
				new Movie(7L,
				"The Dark Knight: Le Chevalier Noir", 
				"Lorsqu'une menace mieux connue sous le nom du Joker émerge de son passé mystérieux et déclenche le chaos sur la ville de Gotham, Batman doit faire face au plus grand des défis psychologique et physique afin de combattre l'injustice.",
				"2h32",
				"Christopher Nolan",
				"Christian Bale, Heath Ledger, Aaron Eckhart",
				2008));
		items.put("La liste de Schindler",
				new Movie(8L,
				"La liste de Schindler", 
				"Dans la Pologne occupée par les Allemands durant la Seconde Guerre mondiale, Oskar Schindler se préoccupe peu à peu de sa main-d'oeuvre juive après avoir été témoin de la persécution des Allemands nazis.",
				"3h15",
				"Steven Spielberg",
				"Liam Neeson, Ralph Fiennes, Ben Kingsley",
				1993));
		items.put("Le seigneur des anneaux: le retour du roi",
				new Movie(9L,
				"Le seigneur des anneaux: le retour du roi", 
				"Gandalf et Aragorn mènent le monde des hommes contre l'armée de Sauron pour éloigner son regard de Frodon et Sam lorsqu'ils s'approchent du Mont Destin avec l'Anneau.",
				"3h21",
				"Peter Jackson",
				"Elijah Wood, Viggo Mortensen, Ian McKellen",
				2003));
		items.put("Pulp Fiction",
				new Movie(10L,
				"Pulp Fiction", 
				"Les vies de deux hommes de main, d'un boxeur, de la femme d'un gangster et de deux braqueurs s'entremêlent dans quatre histoires de violence et de rédemption.",
				"2h34",
				"Quentin Tarantino",
				"John Travolta, Uma Thurman, Samuel L. Jackson",
				1994));
		items.put("The legend of zelda: ocarina of time",
				new Videogame(11L,
				"The legend of zelda: ocarina of time", 
				"As a young boy, Link is tricked by Ganondorf, the King of the Gerudo Thieves. The evil human uses Link to gain access to the Sacred Realm, where he places his tainted hands on Triforce and transforms the beautiful Hyrulean landscape into a barren wasteland. Link is determined to fix the problems he helped to create, so with the help of Rauru he travels through time gathering the powers of the Seven Sages.",
				"Action Adventure Fantasy",
				"Nintendo",
				1998));
		items.put("Tony Hawk's pro Skater 2",
				new Videogame(12L,
				"Tony Hawk's pro Skater 2", 
				"As most major publishers' development efforts shift to any number of next-generation platforms, Tony Hawk 2 will likely stand as one of the last truly fantastic games to be released on the PlayStation.",
				"Sports",
				"Activision",
				2000));
		items.put("Grand Theft Auto IV",
				new Videogame(13L,
				"Grand Theft Auto IV", 
				"What does the American Dream mean today? For Niko Belic, fresh off the boat from Europe. It's the hope he can escape his past. For his cousin, Roman, it is the vision that together they can find fortune in Liberty City, gateway to the land of opportunity. As they slip into debt and are dragged into a criminal underworld by a series of shysters, thieves and sociopaths, they discover that the reality is very different from the dream in a city that worships money and status, and is heaven for those who have them an a living nightmare for those who don't.",
				"Action Adventure",
				"Rockstar Games",
				2008));
		items.put("Super Mario Galaxy",
				new Videogame(14L,
				"Super Mario Galaxy", 
				"The ultimate Nintendo hero is taking the ultimate step ... out into space. Join Mario as he ushers in a new era of video games, defying gravity across all the planets in the galaxy. When some creature escapes into space with Princess Peach, Mario gives chase, exploring bizarre planets all across the galaxy. Mario, Peach and enemies new and old are here. Players run, jump and battle enemies as they explore all the planets in the galaxy. Since this game makes full use of all the features of the Wii Remote, players have to do all kinds of things to succeed: pressing buttons, swinging the Wii Remote and the Nunchuk, and even pointing at and dragging things with the pointer. Since he's in space, Mario can perform mind-bending jumps unlike anything he's done before. He'll also have a wealth of new moves that are all based around tilting, pointing and shaking the Wii Remote. Shake, tilt and point! Mario takes advantage of all the unique aspects of the Wii Remote and Nunchuk controller, unleashing new moves as players shake the controller and even point at and drag items with the pointer.",
				"Action Platformer",
				"Nintendo",
				2007));
		items.put("Red Dead Redemption 2",
				new Videogame(15L,
				"Red Dead Redemption 2", 
				"Developed by the creators of Grand Theft Auto V and Red Dead Redemption, Red Dead Redemption 2 is an epic tale of life in America’s unforgiving heartland. The game’s vast and atmospheric world also provides the foundation for a brand new online multiplayer experience. America, 1899. The end of the Wild West era has begun. After a robbery goes badly wrong in the western town of Blackwater, Arthur Morgan and the Van der Linde gang are forced to flee. With federal agents and the best bounty hunters in the nation massing on their heels, the gang has to rob, steal and fight their way across the rugged heartland of America in order to survive. As deepening internal fissures threaten to tear the gang apart, Arthur must make a choice between his own ideals and loyalty to the gang that raised him.",
				"Action Adventure",
				"Rockstar Games",
				2018));
	}
	
	public List<Item> getAllItems(){
		return new ArrayList<Item>(items.values());
	}
	
	public Item getItem(String name) {
		return items.get(name);
	}
	
	public Item addItem(Item item) {
		item.setId(items.size() + 1);
		items.put(item.getName(), item);
		return item;
	}
	
	public Item updateItem(Item item) {
		if (item.getName().isEmpty()) {
			return null;
		}
		items.put(item.getName(), item);
		return item;
	}
	
	public Item removeItem(String name) {
		return items.remove(name);
	}
}
