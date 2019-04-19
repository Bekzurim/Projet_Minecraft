import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Mouvement extends Application {
	
	Point2D offset;
	Node selected;
	Point2D translateStart;
	double STARTX;
	double STARTY;
	int douquonest = 0;
	boolean caMarche = false;
	Integer clef;
	//Map<Integer, Double> dico;
	
  @Override public void start(final Stage stage) throws Exception {
	  //Liste pour récuprérer les images en fonction de l'ID
	  List<String> listImage = Arrays.asList("0","Base/Dirt.png","Base/bois.png","Base/rock.png","Base/sand.png","Base/wind.png","Base/fire_2.png","Base/stick.png","Base/bone.png","Base/water.png","Base/glass.png","Base/glaçon.png","Base/iron_nugget.png","Base/iron_ingot.png","Base/Poubelle_1.png","Base/Poubelle_2.png",
	  "Food/baguette.png","Food/beurre.png","Food/ble.png","Food/burger_pain.png","Food/burger.png","Food/farine.png","Food/fromage.png","Food/pomme.png","Food/salade.png","Food/tomate.png","Food/viande.png",
	  "Life/life.png","Life/sans.png","Life/fish.png","Life/bird.png","Life/egg.png",
	  "Weapon/ak.png","Weapon/axe.png","Weapon/backpack.png","Weapon/baseball_bat.png","Weapon/battle_axe.png","Weapon/battle_hammer.png","Weapon/bouclier.png","Weapon/bouteille_alcool.png","Weapon/bow.png","Weapon/bow-arrow.png","Weapon/butcher_knife.png","Weapon/chainsaw.png","Weapon/crossbow.png","Weapon/crossbow_arrow.png","Weapon/dague.png","Weapon/double_spear.png","Weapon/Epee_classique.png","Weapon/gas_mask.png","Weapon/grenade.png","Weapon/grenade_laucher.png","Weapon/guandao.png","Weapon/hunter_knife.png","Weapon/katana.png","Weapon/Katana1.png","Weapon/kunai.png","Weapon/lance.png","Weapon/lightsaber.png","Weapon/medkiy.png","Weapon/military_knife.png","Weapon/minigun.png","Weapon/molotov_cocktail.png","Weapon/pistol.png","Weapon/pistol_ammo.png","Weapon/revolver.png","Weapon/rocket.png","Weapon/rocket_launcher.png","Weapon/scythe.png","Weapon/shotgun.png","Weapon/shuriken.png","Weapon/smoke_grenade.png","Weapon/sniper.png","Weapon/tanto1.png","Weapon/throwing_knife.png","Weapon/thunder.png");
	  
	  //Les bases
	  ImageView decor = new ImageView(new File("fond_ecran2.png").toURI().toString());
	  ImageView craft = new ImageView(new File("fond_craft.png").toURI().toString());
	  ImageView Dossier = new ImageView(new File("Dossier.png").toURI().toString());
	  ImageView inventaire = new ImageView(new File("inventory.png").toURI().toString());
	  ImageView limite1 = new ImageView(new File("limitetresnul.png").toURI().toString());
	  ImageView limite2 = new ImageView(new File("limitetresnul.png").toURI().toString());
	  ImageView limite3 = new ImageView(new File("limitetresnul.png").toURI().toString());
	  ImageView limite4 = new ImageView(new File("limitetresnul.png").toURI().toString());
	  ImageView limite5 = new ImageView(new File("limitetresnul.png").toURI().toString());
	  ImageView limite6 = new ImageView(new File("limitetresnul.png").toURI().toString());
	  ImageView limite7 = new ImageView(new File("limitetresnul.png").toURI().toString());
	  ImageView limite8 = new ImageView(new File("limitetresnul.png").toURI().toString());
	  ImageView limite9 = new ImageView(new File("limitetresnul.png").toURI().toString());
	  ImageView limite10 = new ImageView(new File("limitetresnul.png").toURI().toString());
	  
	  creationImage dirt = new creationImage("Base/Dirt.png","1");
	  creationImage wood = new creationImage("Base/bois.png","2");
	  creationImage rock = new creationImage("Base/rock.png","3");
	  creationImage sand = new creationImage("Base/sand.png","4");
	  creationImage wind = new creationImage("Base/wind.png","5");
	  creationImage fire2 = new creationImage("Base/fire_2.png","6");
	  creationImage stick = new creationImage("Base/stick.png","7");
	  creationImage bone = new creationImage("Base/bone.png","8");
	  creationImage water = new creationImage("Base/water.png","9");
	  creationImage glass = new creationImage("Base/glass.png","10");
	  creationImage glaçon = new creationImage("Base/glaçon.png","11");
	  creationImage ironNugget = new creationImage("Base/iron_nugget.png","12");
	  creationImage ironIngot = new creationImage("Base/iron_ingot.png","13");
	  creationImage Poubelle_1 = new creationImage("Base/Poubelle_1.png","14");
	  creationImage Poubelle_2 = new creationImage("Base/Poubelle_2.png","15");
	  
	  //La bouffe
	  creationImage baguette = new creationImage("Food/baguette.png","16");
	  creationImage beurre = new creationImage("Food/beurre.png","17");
	  creationImage ble = new creationImage("Food/ble.png","18");
	  creationImage burgerPain = new creationImage("Food/burger_pain.png","19");
	  creationImage burger = new creationImage("Food/burger.png","20");
	  creationImage farine = new creationImage("Food/farine.png","21");
	  creationImage fromage = new creationImage("Food/fromage.png","22");
	  creationImage pomme = new creationImage("Food/pomme.png","23");
	  creationImage salade = new creationImage("Food/salade.png","24");
	  creationImage tomate = new creationImage("Food/tomate.png","25");
	  creationImage viande = new creationImage("Food/viande.png","26");
	  
	//La vie
	  creationImage life = new creationImage("Life/life.png","27");
	  creationImage Sans = new creationImage("Life/Sans.png","28");
	  creationImage fish = new creationImage("Life/fish.png","29");
	  creationImage bird = new creationImage("Life/bird.png","30");
	  creationImage egg = new creationImage("Life/egg.png","31");
	  
	  //Les armes
	  creationImage ak = new creationImage("Weapon/ak.png","32");
	  creationImage axe = new creationImage("Weapon/axe.png","33");
	  creationImage backpack = new creationImage("Weapon/backpack.png","34");
	  creationImage baseball_bat = new creationImage("Weapon/baseball_bat.png","35");
	  creationImage battle_axe = new creationImage("Weapon/battle_axe.png","36");
	  creationImage battle_hammer = new creationImage("Weapon/battle_hammer.png","37");
	  creationImage bouclier = new creationImage("Weapon/bouclier.png","38");
	  creationImage bouteille_alcool = new creationImage("Weapon/bouteille_alcool.png","39");
	  creationImage bow = new creationImage("Weapon/bow.png","40");
	  creationImage bow_arrow = new creationImage("Weapon/bow-arrow.png","41");
	  creationImage butcher_knife = new creationImage("Weapon/butcher_knife.png","42");
	  creationImage chainsaw = new creationImage("Weapon/chainsaw.png","43");
	  creationImage crossbow = new creationImage("Weapon/crossbow.png","44");
	  creationImage crossbow_arrow = new creationImage("Weapon/crossbow_arrow.png","45");
	  creationImage dague = new creationImage("Weapon/dague.png","46");
	  creationImage double_spear = new creationImage("Weapon/double_spear.png","47");
	  creationImage Epee_classique = new creationImage("Weapon/Epee_classique.png","48");
	  creationImage gas_mask = new creationImage("Weapon/gas_mask.png","49");
	  creationImage grenade = new creationImage("Weapon/grenade.png","50");
	  creationImage grenade_laucher = new creationImage("Weapon/grenade_laucher.png","51");
	  creationImage guandao = new creationImage("Weapon/guandao.png","52");
	  creationImage hunter_knife = new creationImage("Weapon/hunter_knife.png","53");
	  creationImage katana = new creationImage("Weapon/katana.png","54");
	  creationImage Katana1 = new creationImage("Weapon/Katana1.png","55");
	  creationImage kunai = new creationImage("Weapon/kunai.png","56");
	  creationImage lance = new creationImage("Weapon/lance.png","57");
	  creationImage lightsaber = new creationImage("Weapon/lightsaber.png","58");
	  creationImage medkiy = new creationImage("Weapon/medkiy.png","59");
	  creationImage military_knife = new creationImage("Weapon/military_knife.png","60");
	  creationImage minigun = new creationImage("Weapon/minigun.png","61");
	  creationImage molotov_cocktail = new creationImage("Weapon/molotov_cocktail.png","62");
	  creationImage pistol = new creationImage("Weapon/pistol.png","63");
	  creationImage pistol_ammo = new creationImage("Weapon/pistol_ammo.png","64");
	  creationImage revolver = new creationImage("Weapon/revolver.png","65");
	  creationImage rocket = new creationImage("Weapon/rocket.png","66");
	  creationImage rocket_launcher = new creationImage("Weapon/rocket_launcher.png","67");
	  creationImage scythe = new creationImage("Weapon/scythe.png","68");
	  creationImage shotgun = new creationImage("Weapon/shotgun.png","69");
	  creationImage shuriken = new creationImage("Weapon/shuriken.png","70");
	  creationImage smoke_grenade = new creationImage("Weapon/smoke_grenade.png","71");
	  creationImage sniper = new creationImage("Weapon/sniper.png","72");
	  creationImage tanto1 = new creationImage("Weapon/tanto1.png","73");
	  creationImage throwing_knife = new creationImage("Weapon/throwing_knife.png","74");
	  creationImage thunder = new creationImage("Weapon/thunder.png","75"); 
	  
	  //Création des crafts
	  creationCraft craft_1 = new creationCraft(new ArrayList(Arrays.asList(0,3,0,3,27,3,0,3,0)),31);
	  creationCraft craft_2 = new creationCraft(new ArrayList(Arrays.asList(0,0,0,4,0,0,6,0,0)),10);
	  creationCraft craft_3 = new creationCraft(new ArrayList(Arrays.asList(0,0,0,0,4,0,0,6,0)),10);
	  creationCraft craft_4 = new creationCraft(new ArrayList(Arrays.asList(0,0,0,0,0,4,0,0,6)),10);
	  creationCraft craft_5 = new creationCraft(new ArrayList(Arrays.asList(0,19,0,24,25,26,0,19,0)),20);
	  creationCraft craft_6 = new creationCraft(new ArrayList(Arrays.asList(0,19,0,25,24,26,0,19,0)),20);
	  creationCraft craft_7 = new creationCraft(new ArrayList(Arrays.asList(0,19,0,25,26,24,0,19,0)),20);
	  creationCraft craft_8 = new creationCraft(new ArrayList(Arrays.asList(0,19,0,24,26,25,0,19,0)),20);
	  creationCraft craft_9 = new creationCraft(new ArrayList(Arrays.asList(0,19,0,26,24,25,0,19,0)),20);
	  creationCraft craft_10 = new creationCraft(new ArrayList(Arrays.asList(0,19,0,26,25,24,0,19,0)),20);
	  creationCraft craft_11 = new creationCraft(new ArrayList(Arrays.asList(13,13,13,13,13,13,0,13,0)),38);
	  
	  //Creation du dico avec les crafts
	  Map<Integer,creationCraft> dicoCraft=new HashMap<Integer,creationCraft>();
	  dicoCraft.put(1, craft_1);
	  dicoCraft.put(10, craft_2);dicoCraft.put(11, craft_3);dicoCraft.put(12, craft_4);
	  dicoCraft.put(20, craft_5);dicoCraft.put(21, craft_6);dicoCraft.put(22, craft_7);dicoCraft.put(23, craft_8);dicoCraft.put(24, craft_9);dicoCraft.put(25, craft_10);
	  dicoCraft.put(30, craft_11);

    Button Bbase = new Button("Base");
    Button Bfood = new Button("Food");
    Button Bweapon = new Button("Weapon");
    Button Blife = new Button("Life");

    Button buttonAdd = new Button("ADD");
	Button buttonDel = new Button("DELETE");
	Bbase.setStyle("-fx-background-color: linear-gradient(#50FE80, #36DD0F) ");
	buttonAdd.setStyle("-fx-background-color: linear-gradient(#50FE80, #36DD0F) ");
	buttonDel.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00) ");
	
	ToolBar toolBar = new ToolBar();
	toolBar.getItems().add(Bbase);
	toolBar.getItems().add(Bfood);
	toolBar.getItems().add(Blife);
	toolBar.getItems().add(Bweapon);
	
	
	toolBar.setStyle("-fx-background-color: rgba(0, 100, 100, 0.7);");
	toolBar.setTranslateY(86);
	
	//Les 4 groupes, permet de clean facilement une catégorie. +reesayer stackpane
	Group Base = new Group();
	Group Food = new Group();
	Group Weapon = new Group();
	Group Life = new Group();
	Group Matrice = new Group();
	StackPane all = new StackPane();
	final StackPane layout = new StackPane();
	
	
    Base.getChildren().addAll(limite1,limite2,dirt.imageView,sand.imageView,water.imageView,wood.imageView,ironIngot.imageView,rock.imageView,fire2.imageView,wind.imageView,bone.imageView);
    Food.getChildren().addAll(limite3,limite4,baguette.imageView,beurre.imageView,ble.imageView,burgerPain.imageView,farine.imageView,fromage.imageView,pomme.imageView,salade.imageView,tomate.imageView,viande.imageView);
    Life.getChildren().addAll(limite7,limite8,life.imageView,Sans.imageView,fish.imageView,bird.imageView);
    Weapon.getChildren().addAll(limite5,limite6,chainsaw.imageView,axe.imageView);
    Matrice.getChildren().addAll(limite9,limite10);
    all.getChildren().addAll(Base);
    layout.getChildren().addAll(decor,craft,Dossier,inventaire,all,toolBar,buttonDel,buttonAdd,Matrice); //le Padre!
    
    
    //Positionnement des Nodes à la mano.
    for(int i=0; i<Base.getChildren().size()-2; i++){
    		selected = Base.getChildren().get(i+2);
    		selected.setTranslateX(-330+(51*Math.round(i/3)));selected.setTranslateY(130+51*(i%3));
    }
    for(int i=0; i<Food.getChildren().size()-2; i++){
		selected = Food.getChildren().get(i+2);
		selected.setTranslateX(-330+(51*Math.round(i/3)));selected.setTranslateY(130+51*(i%3));
    }
    for(int i=0; i<Life.getChildren().size()-2; i++){
		selected = Life.getChildren().get(i+2);
		selected.setTranslateX(-330+(51*Math.round(i/3)));selected.setTranslateY(130+51*(i%3));
    }
    for(int i=0; i<Weapon.getChildren().size()-2; i++){
		selected = Weapon.getChildren().get(i+2);
		selected.setTranslateX(-330+(51*Math.round(i/3)));selected.setTranslateY(130+51*(i%3));
    }
    
    //Ca j'ai vrmt honte faudra changer.
    limite1.setTranslateX(-1000);limite1.setTranslateY(-1000);
    limite2.setTranslateX(1000);limite2.setTranslateY(1000);
    limite3.setTranslateX(-1000);limite3.setTranslateY(-1000);
    limite4.setTranslateX(1000);limite4.setTranslateY(1000);
    limite5.setTranslateX(-1000);limite5.setTranslateY(-1000);
    limite6.setTranslateX(1000);limite6.setTranslateY(1000);
    limite7.setTranslateX(-1000);limite7.setTranslateY(-1000);
    limite8.setTranslateX(1000);limite8.setTranslateY(1000);
    limite9.setTranslateX(-1000);limite9.setTranslateY(-1000);
    limite10.setTranslateX(1000);limite10.setTranslateY(1000);
    
    //Positionnement du Décor.
    craft.setTranslateX(-55);craft.setTranslateY(-85);
    buttonAdd.setTranslateX(82);buttonAdd.setTranslateY(-9);buttonAdd.setMinWidth(54);buttonAdd.setMaxHeight(5);
    buttonDel.setTranslateX(82);buttonDel.setTranslateY(18);
    Dossier.setTranslateX(300);Dossier.setTranslateY(-185);
    inventaire.setTranslateY(179);
    
    //On lance la fenêtre
    stage.setScene(new Scene(layout,700,500));
    stage.show();
    
    //Matrice de craft
    int[][] matrice = new int[3][3];
    
////////////////////////////////////////////     Boutons event     ////////////////////////////////////////////
    
    //Affiche que les Nodes du Group Base (clear les autres).
    Bbase.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  all.getChildren().clear();
            	  all.getChildren().addAll(Base);
            	  douquonest = 0;
            	  
              }
            });
    
    //Affiche que les Nodes du Group Food (clear les autres).
    Bfood.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  all.getChildren().clear();
            	  all.getChildren().addAll(Food);
            	  douquonest = 1;
            	  
            	  
              }
            });
    
    //Affiche que les Nodes du Group Life (clear les autres).
    Blife.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  all.getChildren().clear();
            	  all.getChildren().addAll(Life);
            	  douquonest = 2;
            	  
            	  
              }
            });
    
    //Affiche que les Nodes du Group Weapon (clear les autres).
    Bweapon.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  all.getChildren().clear();
            	  all.getChildren().addAll(Weapon);
            	  douquonest = 3;
            	  
              }
            });
    
    //Animation du bouton delete + vide le Groupe Matrice
    buttonDel.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  caMarche = false;
            	  for(int i =0;i<matrice.length*matrice.length;i++){
            		  matrice[i%3][i/3] = 0;}
            	  buttonDel.setStyle("-fx-background-color: #ff0000;");
            	  Matrice.getChildren().clear();
            	  Matrice.getChildren().addAll(limite9,limite10); //peut etre pas necessaire
              }
            });
    
    buttonDel.addEventHandler(MouseEvent.MOUSE_RELEASED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  buttonDel.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00) ");
              }
            });
    
    buttonAdd.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  buttonAdd.setStyle("-fx-background-color: #00FF2D;");
            	  if(caMarche == true) {
            	  caMarche = false;
            	  clef = clef/10*10;
            	  for(int i=0;i<10;i++) {
              		dicoCraft.remove(clef+i);}
            	  int IdnouvelObjet = Integer.parseInt(Matrice.getChildren().get(Matrice.getChildren().size()-1).getId());
            	  if(1<=IdnouvelObjet && IdnouvelObjet<=15){
            		  Base.getChildren().add(Matrice.getChildren().get(Matrice.getChildren().size()-1));
            		  selected = Base.getChildren().get(Base.getChildren().size()-1);
            		  selected.setTranslateX(-330+(51*Math.round((Base.getChildren().size()-3)/3)));selected.setTranslateY(130+51*((Base.getChildren().size())%3));
            		  all.getChildren().clear();
                	  all.getChildren().addAll(Base);
                	  douquonest = 0;
            	  }
            	  else if(16<=IdnouvelObjet && IdnouvelObjet<=26){
            		  Food.getChildren().add(Matrice.getChildren().get(Matrice.getChildren().size()-1));
            		  selected = Food.getChildren().get(Food.getChildren().size()-1);
            		  selected.setTranslateX(-330+(51*Math.round((Food.getChildren().size()-3)/3)));selected.setTranslateY(130+51*((Food.getChildren().size())%3));
            		  all.getChildren().clear();
                	  all.getChildren().addAll(Food);
                	  douquonest = 1;
            	  }
            	  else if(27<=IdnouvelObjet && IdnouvelObjet<=31){
            		  Life.getChildren().add(Matrice.getChildren().get(Matrice.getChildren().size()-1));
            		  selected = Life.getChildren().get(Life.getChildren().size()-1);
              		  selected.setTranslateX(-330+(51*Math.round((Life.getChildren().size()-3)/3)));selected.setTranslateY(130+51*((Life.getChildren().size())%3));
            		  all.getChildren().clear();
                	  all.getChildren().addAll(Life);
                	  douquonest = 2;
            	  }
            	  else if(32<=IdnouvelObjet && IdnouvelObjet<=75){
            		  Weapon.getChildren().add(Matrice.getChildren().get(Matrice.getChildren().size()-1));
            		  selected = Weapon.getChildren().get(Weapon.getChildren().size()-1);
            		  selected.setTranslateX(-330+(51*Math.round((Weapon.getChildren().size()-3)/3)));selected.setTranslateY(130+51*((Weapon.getChildren().size())%3));
            		  all.getChildren().clear();
                	  all.getChildren().addAll(Weapon);
                	  douquonest = 3;
            	  }
            	  
            	  for(int i =0;i<matrice.length*matrice.length;i++){
            		  matrice[i%3][i/3] = 0;}
            	  Matrice.getChildren().clear();
            	  Matrice.getChildren().addAll(limite9,limite10); //peut etre pas necessaire
              }
              }
            });
    
    buttonAdd.addEventHandler(MouseEvent.MOUSE_RELEASED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  buttonAdd.setStyle("-fx-background-color: linear-gradient(#50FE80, #36DD0F) ");
              }
            });
    
////////////////////////////////////////////     Mouse event     ////////////////////////////////////////////
    
    //Selection de la Node
    all.setOnMousePressed(evt -> {
        Node target = (Node) evt.getTarget();
        if (target != all) { // si on est bien sur le Node
            selected = target;
            
            offset = new Point2D(evt.getX(), evt.getY());
            translateStart = new Point2D(selected.getTranslateX(), selected.getTranslateY());
            STARTX = (evt.getX() - offset.getX() + translateStart.getX()); // servent au cas ou
            STARTY = (evt.getY() - offset.getY() + translateStart.getY()); // d'un mauvais positionnement

        } else {
            selected = null;
        }
        evt.consume();
    });
    
    //Mouvement qui suit la souris
    all.setOnMouseDragged(evt -> {
        if (selected != null) {
            selected.setTranslateX(evt.getX() - offset.getX() + translateStart.getX());
            selected.setTranslateY(evt.getY() - offset.getY() + translateStart.getY());
            // Agrandissement de l'image
            ((ImageView) evt.getTarget()).setFitHeight(40);
            ((ImageView) evt.getTarget()).setFitWidth(40);
            
        }
        evt.consume();
    });
    
    all.setOnMouseReleased(evt -> {
    	
        if (selected != null) {
        	//Si on est dans la matrice
        	if(815<evt.getX() && evt.getX()<964 && 860<evt.getY() && evt.getY()<1009) {
        	for(int i=0; i<matrice.length*matrice.length;i++) {
        			if(815+50*(i%3)<=evt.getX() && evt.getX()<=864+50*(i%3) && 860+50*(i/3)<=evt.getY() && evt.getY()<=909+50*(i/3)) {
        				selected.setTranslateX(-175+50*(i%3));
                        selected.setTranslateY(-130+50*(i/3));
                        if (selected.getId() != null && matrice[i/3][i%3] ==0) {
                        	matrice[i/3][i%3] = Integer.valueOf(selected.getId()); //La matrice récupère l'ID de la Node.
                        if(caMarche ==true) { //delete le resultat si on rajoute un node dans la matrice
                        Matrice.getChildren().remove(Matrice.getChildren().size()-1);}
                        if(selected.getParent() != Matrice) {
                        Matrice.getChildren().add(selected);
                        creationImage newimage = new creationImage(listImage.get((Integer.parseInt(selected.getId()))),selected.getId());
                        if (douquonest ==0) {Base.getChildren().add(newimage.imageView);selected = Base.getChildren().get(Base.getChildren().size()-1);} 
                    	else if (douquonest ==1) {Food.getChildren().add(newimage.imageView);selected = Food.getChildren().get(Food.getChildren().size()-1);} 
                    	else if (douquonest ==2) {Life.getChildren().add(newimage.imageView);selected = Life.getChildren().get(Life.getChildren().size()-1);} 
                    	else if (douquonest ==3) {Weapon.getChildren().add(newimage.imageView);selected = Weapon.getChildren().get(Weapon.getChildren().size()-1);} 
                        
                        
                        selected.setTranslateX(STARTX);
                        selected.setTranslateY(STARTY);
                        }
                        }
                        else {
                    		selected.setTranslateX(STARTX);
                    		selected.setTranslateY(STARTY);
                    	}
        			}		
        	}
        	}
        	//Si on est dans l'inventaire
        	else if((evt.getY() - offset.getY() + translateStart.getY())>=100) {
        		double X;
        		selected.setTranslateY(Math.round((evt.getY() - offset.getY() + translateStart.getY()+25)/50)*50-20);
        		if((evt.getX() - offset.getX() + translateStart.getX())>=0) { //X positif
            	X = (Math.round((evt.getX() - offset.getX() + translateStart.getX()+25)/50)*50-25+Math.round((evt.getX() - offset.getX() + translateStart.getX())/50)/2);}
            	else { // X négatif
            	X = (Math.round((evt.getX() - offset.getX() + translateStart.getX()-25)/50)*50+25+Math.round((evt.getX() - offset.getX() + translateStart.getX())/50)/2);}
        		selected.setTranslateX(X);
        		
        	}
        	//Sinon retour au point de départ.
        	else {
        		selected.setTranslateX(STARTX);
        		selected.setTranslateY(STARTY);
        	}
        	//Redimensionnement de l'image
        	((ImageView) evt.getTarget()).setFitHeight(30);
            ((ImageView) evt.getTarget()).setFitWidth(30);
            
            evt.consume();
          
            for(int i=0; i<matrice.length;i++) {
        		for(int j=0; j<matrice.length;j++) {
        			System.out.print(matrice[i][j]);
        		}
        		System.out.println("");
        	}
            System.out.println("");
        }	
        //Parcourir et comparer avec la matrice
        
        ArrayList<Integer> liste = new ArrayList<Integer>();
        ArrayList<?> valeur;
        caMarche = false;
        Iterator<Integer> idico = dicoCraft.keySet().iterator();
        
        for(int i=0;i<matrice.length;i++) {
        	for(int j=0;j<matrice.length;j++) {
        		liste.add(matrice[i][j]);
        	}
        }
        while(idico.hasNext() && caMarche == false) {
        	int compteur=0;
        	clef=idico.next();
        	valeur = dicoCraft.get(clef).liste;
      	  
      	  	System.out.print(valeur);
      	    System.out.println(liste);
      	
        	for(int k=0;k<liste.size();k++) {
        		if (valeur.get(k)==liste.get(k)) {
        			compteur+=1;
        		}
        }
        	if(compteur==craft_1.liste.size() && compteur==liste.size()) {
        		caMarche = true;
        		creationImage newImage = new creationImage(listImage.get(dicoCraft.get(clef).resultat), String.valueOf(dicoCraft.get(clef).resultat));
        		
        		Matrice.getChildren().add(newImage.imageView);
        		Matrice.getChildren().get(Matrice.getChildren().size()-1).setTranslateX(85);
        		Matrice.getChildren().get(Matrice.getChildren().size()-1).setTranslateY(-80);
        	}
        	else {
        		caMarche = false;
        	}
        }
    System.out.println(caMarche);
    });
}



  public static void main(String[] args) { launch(args); }
}
