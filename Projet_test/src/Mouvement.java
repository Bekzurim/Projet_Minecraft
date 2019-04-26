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
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Mouvement extends Application {
	
	Scene scene1,scene2;
	Point2D offset,translateStart;
	Node selected;
	double STARTX,STARTY;
	double X,Y;
	int douquonest = 0;
	boolean caMarche,test = false;
	Integer clef;
	//Map<Integer, Double> dico;

@Override public void start(final Stage stage) throws Exception {
	  //Liste pour récuprérer les images en fonction de l'ID
	  List<String> listImage = Arrays.asList("0","Base/Dirt.png","Base/bois.png","Base/wooden_block.png","Base/rock.png","Base/sand.png","Base/wind.png","Base/fire_2.png","Base/stick.png","Base/bone.png","Base/water.png","Base/glass.png","Base/glaçon.png","Base/iron_nugget.png","Base/iron_ingot.png","Base/feather.png","Base/Poubelle_1.png","Base/Poubelle_2.png",
	  "Food/baguette.png","Food/beurre.png","Food/ble.png","Food/burger_pain.png","Food/burger.png","Food/farine.png","Food/fromage.png","Food/pomme.png","Food/salade.png","Food/tomate.png","Food/viande.png",
	  "Life/life.png","Life/cow.png","Life/fish.png","Life/bird.png","Life/egg.png","Life/SMB.png","Life/sans.png",
	  "Weapon/ak.png","Weapon/axe.png","Weapon/backpack.png","Weapon/baseball_bat.png","Weapon/battle_axe.png","Weapon/battle_hammer.png","Weapon/bouclier.png","Weapon/bouteille_alcool.png","Weapon/bow.png","Weapon/bow-arrow.png","Weapon/butcher_knife.png","Weapon/chainsaw.png","Weapon/crossbow.png","Weapon/crossbow_arrow.png","Weapon/dague.png","Weapon/double_spear.png","Weapon/Epee_classique.png","Weapon/gas_mask.png","Weapon/grenade.png","Weapon/grenade_laucher.png","Weapon/guandao.png","Weapon/hunter_knife.png","Weapon/katana.png","Weapon/Katana1.png","Weapon/kunai.png","Weapon/lance.png","Weapon/lightsaber.png","Weapon/medkiy.png","Weapon/military_knife.png","Weapon/minigun.png","Weapon/molotov_cocktail.png","Weapon/pistol.png","Weapon/pistol_ammo.png","Weapon/revolver.png","Weapon/rocket.png","Weapon/rocket_launcher.png","Weapon/scythe.png","Weapon/shotgun.png","Weapon/shuriken.png","Weapon/smoke_grenade.png","Weapon/sniper.png","Weapon/tanto1.png","Weapon/throwing_knife.png","Weapon/thunder.png"
	  );

	  //Achievements
	  ImageView sansFA1 = new ImageView(new File("sansFutureAchievement.png").toURI().toString());
	  ImageView sansFAT1 = new ImageView(new File("sansFutureAchievementtxt.png").toURI().toString());
	  ImageView sansFA2 = new ImageView(new File("sansFutureAchievement.png").toURI().toString());
	  ImageView sansFAT2 = new ImageView(new File("sansFutureAchievementtxt.png").toURI().toString());
	  ImageView sansFA3 = new ImageView(new File("sansFutureAchievement.png").toURI().toString());
	  ImageView sansFAT3 = new ImageView(new File("sansFutureAchievementtxt.png").toURI().toString());
	  ImageView sansFA4 = new ImageView(new File("sansFutureAchievement.png").toURI().toString());
	  ImageView sansFAT4 = new ImageView(new File("sansFutureAchievementtxt.png").toURI().toString());
	  ImageView sansFA5 = new ImageView(new File("sansFutureAchievement.png").toURI().toString());
	  ImageView sansFAT5 = new ImageView(new File("sansFutureAchievementtxt.png").toURI().toString());
	  ImageView sansFA6 = new ImageView(new File("sansFutureAchievement.png").toURI().toString());
	  ImageView sansFAT6 = new ImageView(new File("sansFutureAchievementtxt.png").toURI().toString());
	  ImageView sansFA7 = new ImageView(new File("sansFutureAchievement.png").toURI().toString());
	  ImageView sansFAT7 = new ImageView(new File("sansFutureAchievementtxt.png").toURI().toString());
	  ImageView sansFA8 = new ImageView(new File("sansFutureAchievement.png").toURI().toString());
	  ImageView sansFAT8 = new ImageView(new File("sansFutureAchievementtxt.png").toURI().toString());
	  ImageView sansA1 = new ImageView(new File("sansAchievement.png").toURI().toString());
	  ImageView sansA2 = new ImageView(new File("sansAchievement.png").toURI().toString());
	  ImageView sansA3 = new ImageView(new File("sansAchievement.png").toURI().toString());
	  ImageView sansA4 = new ImageView(new File("sansAchievement.png").toURI().toString());
	  ImageView sansA5 = new ImageView(new File("sansAchievement.png").toURI().toString());
	  ImageView sansA6 = new ImageView(new File("sansAchievement.png").toURI().toString());
	  ImageView sansA7 = new ImageView(new File("sansAchievement.png").toURI().toString());
	  ImageView sansA8 = new ImageView(new File("sansAchievement.png").toURI().toString());
	  ImageView sansTest1 = new ImageView(new File("sansAchievement.png").toURI().toString());
	  ImageView sansTest2 = new ImageView(new File("sansAchievement.png").toURI().toString());
	  
	  //Les bases
	  Image icon = new Image(new File("icon.png").toURI().toString());
	  ImageView decor1 = new ImageView(new File("fond_ecran2.png").toURI().toString());
	  ImageView decor2 = new ImageView(new File("fond_ecran2.png").toURI().toString());
	  ImageView craft = new ImageView(new File("fond_craft.png").toURI().toString());
	  ImageView craftOk = new ImageView(new File("fond_craft_ok.png").toURI().toString());
	  ImageView mini_craft = new ImageView(new File("mini_fond_craft.png").toURI().toString());
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
	  creationImage wooden = new creationImage("Base/wooden_block.png","3");
	  creationImage rock = new creationImage("Base/rock.png","4");
	  creationImage sand = new creationImage("Base/sand.png","5");
	  creationImage wind = new creationImage("Base/wind.png","6");
	  creationImage fire2 = new creationImage("Base/fire_2.png","7");
	  creationImage stick = new creationImage("Base/stick.png","8");
	  creationImage bone = new creationImage("Base/bone.png","9");
	  creationImage water = new creationImage("Base/water.png","10");
	  creationImage glass = new creationImage("Base/glass.png","11");
	  creationImage glaçon = new creationImage("Base/glaçon.png","12");
	  creationImage ironNugget = new creationImage("Base/iron_nugget.png","13");
	  creationImage ironIngot = new creationImage("Base/iron_ingot.png","14");
	  creationImage feather = new creationImage("Base/feather.png","15");
	  creationImage Poubelle_1 = new creationImage("Base/Poubelle_1.png","16");
	  creationImage Poubelle_2 = new creationImage("Base/Poubelle_2.png","17");
	  
	  //La bouffe
	  creationImage baguette = new creationImage("Food/baguette.png","18");
	  creationImage beurre = new creationImage("Food/beurre.png","19");
	  creationImage ble = new creationImage("Food/ble.png","20");
	  creationImage burgerPain = new creationImage("Food/burger_pain.png","21");
	  creationImage burger = new creationImage("Food/burger.png","22");
	  creationImage farine = new creationImage("Food/farine.png","23");
	  creationImage fromage = new creationImage("Food/fromage.png","24");
	  creationImage pomme = new creationImage("Food/pomme.png","25");
	  creationImage salade = new creationImage("Food/salade.png","26");
	  creationImage tomate = new creationImage("Food/tomate.png","27");
	  creationImage viande = new creationImage("Food/viande.png","28");
	  
	//La vie
	  creationImage life = new creationImage("Life/life.png","29");
	  creationImage cow = new creationImage("Life/cow.png","30");
	  creationImage fish = new creationImage("Life/fish.png","31");
	  creationImage bird = new creationImage("Life/bird.png","32");
	  creationImage egg = new creationImage("Life/egg.png","33");
	  creationImage SMB = new creationImage("Life/SMB.png","34");
	  creationImage Sans = new creationImage("Life/Sans.png","35");
	  
	  //Les armes
	  creationImage ak = new creationImage("Weapon/ak.png","36");
	  creationImage axe = new creationImage("Weapon/axe.png","37");
	  creationImage backpack = new creationImage("Weapon/backpack.png","38");
	  creationImage baseball_bat = new creationImage("Weapon/baseball_bat.png","39");
	  creationImage battle_axe = new creationImage("Weapon/battle_axe.png","40");
	  creationImage battle_hammer = new creationImage("Weapon/battle_hammer.png","41");
	  creationImage bouclier = new creationImage("Weapon/bouclier.png","42");
	  creationImage bouteille_alcool = new creationImage("Weapon/bouteille_alcool.png","43");
	  creationImage bow = new creationImage("Weapon/bow.png","44");
	  creationImage bow_arrow = new creationImage("Weapon/bow-arrow.png","45");
	  creationImage butcher_knife = new creationImage("Weapon/butcher_knife.png","46");
	  creationImage chainsaw = new creationImage("Weapon/chainsaw.png","47");
	  creationImage crossbow = new creationImage("Weapon/crossbow.png","48");
	  creationImage crossbow_arrow = new creationImage("Weapon/crossbow_arrow.png","49");
	  creationImage dague = new creationImage("Weapon/dague.png","50");
	  creationImage double_spear = new creationImage("Weapon/double_spear.png","51");
	  creationImage Epee_classique = new creationImage("Weapon/Epee_classique.png","52");
	  creationImage gas_mask = new creationImage("Weapon/gas_mask.png","53");
	  creationImage grenade = new creationImage("Weapon/grenade.png","54");
	  creationImage grenade_laucher = new creationImage("Weapon/grenade_laucher.png","55");
	  creationImage guandao = new creationImage("Weapon/guandao.png","56");
	  creationImage hunter_knife = new creationImage("Weapon/hunter_knife.png","57");
	  creationImage katana = new creationImage("Weapon/katana.png","58");
	  creationImage Katana1 = new creationImage("Weapon/Katana1.png","59");
	  creationImage kunai = new creationImage("Weapon/kunai.png","60");
	  creationImage lance = new creationImage("Weapon/lance.png","61");
	  creationImage lightsaber = new creationImage("Weapon/lightsaber.png","62");
	  creationImage medkiy = new creationImage("Weapon/medkiy.png","63");
	  creationImage military_knife = new creationImage("Weapon/military_knife.png","64");
	  creationImage minigun = new creationImage("Weapon/minigun.png","65");
	  creationImage molotov_cocktail = new creationImage("Weapon/molotov_cocktail.png","66");
	  creationImage pistol = new creationImage("Weapon/pistol.png","67");
	  creationImage pistol_ammo = new creationImage("Weapon/pistol_ammo.png","68");
	  creationImage revolver = new creationImage("Weapon/revolver.png","69");
	  creationImage rocket = new creationImage("Weapon/rocket.png","70");
	  creationImage rocket_launcher = new creationImage("Weapon/rocket_launcher.png","71");
	  creationImage scythe = new creationImage("Weapon/scythe.png","72");
	  creationImage shotgun = new creationImage("Weapon/shotgun.png","73");
	  creationImage shuriken = new creationImage("Weapon/shuriken.png","74");
	  creationImage smoke_grenade = new creationImage("Weapon/smoke_grenade.png","75");
	  creationImage sniper = new creationImage("Weapon/sniper.png","76");
	  creationImage tanto1 = new creationImage("Weapon/tanto1.png","77");
	  creationImage throwing_knife = new creationImage("Weapon/throwing_knife.png","78");
	  creationImage thunder = new creationImage("Weapon/thunder.png","79");
	  
	  //Création des crafts
	  
	  //Base
	  creationCraft craft_16 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,2,2,0,2,2,0,0,0)),3);
	  creationCraft craft_17 = new creationCraft(new ArrayList<Integer>(Arrays.asList(2,2,0,2,2,0,0,0,0)),3);
	  creationCraft craft_18 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,2,2,0,2,2,0)),3);
	  creationCraft craft_19 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,2,2,0,2,2)),3);
	  creationCraft craft_26 = new creationCraft(new ArrayList<Integer>(Arrays.asList(3,0,0,3,0,0,0,0,0)),8);
	  creationCraft craft_27 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,3,0,0,3,0,0,0,0)),8);
	  creationCraft craft_28 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,3,0,0,3,0,0,0)),8);
	  creationCraft craft_29 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,3,0,0,3,0,0)),8);
	  creationCraft craft_30 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,3,0,0,3,0)),8);
	  creationCraft craft_31 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,3,0,0,3)),8);
	  creationCraft craft_35 = new creationCraft(new ArrayList<Integer>(Arrays.asList(52,31,0,0,0,0,0,0,0)),9);
	  creationCraft craft_36 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,52,31,0,0,0,0)),9);
	  creationCraft craft_37 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,52,31,0)),9);
	  creationCraft craft_2 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,5,0,0,7,0,0)),11);
	  creationCraft craft_3 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,5,0,0,7,0)),11);
	  creationCraft craft_4 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,5,0,0,7)),11);
	  creationCraft craft_5 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,13,0,0,7,0,0)),14);
	  creationCraft craft_6 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,13,0,0,7,0)),14);
	  creationCraft craft_7 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,13,0,0,7)),14);
	  creationCraft craft_45 = new creationCraft(new ArrayList<Integer>(Arrays.asList(52,32,0,0,0,0,0,0,0)),15);
	  creationCraft craft_46 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,52,32,0,0,0,0)),15);
	  creationCraft craft_47 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,52,32,0)),15);
	  
	  //Food
	  creationCraft craft_8 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,21,0,26,27,28,0,21,0)),22);
	  creationCraft craft_9 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,21,0,27,26,28,0,21,0)),22);
	  creationCraft craft_10 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,21,0,27,28,26,0,21,0)),22);
	  creationCraft craft_11 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,21,0,26,28,27,0,21,0)),22);
	  creationCraft craft_12 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,21,0,28,26,27,0,21,0)),22);
	  creationCraft craft_13 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,21,0,28,27,26,0,21,0)),22);
	  creationCraft craft_38 = new creationCraft(new ArrayList<Integer>(Arrays.asList(52,30,0,0,0,0,0,0,0)),28);
	  creationCraft craft_39 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,52,30,0,0,0,0)),28);
	  creationCraft craft_40 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,52,30,0)),28);
	  
	  //Life
	  creationCraft craft_20 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,10,0,0,33,0,0)),31);
	  creationCraft craft_21 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,10,0,0,32,0)),31);
	  creationCraft craft_22 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,10,0,0,32)),31);
	  creationCraft craft_23 = new creationCraft(new ArrayList<Integer>(Arrays.asList(33,0,0,6,0,0,0,0,0)),32);
	  creationCraft craft_24 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,33,0,0,6,0,0,0,0)),32);
	  creationCraft craft_25 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,33,0,0,6,0,0,0)),32);
	  creationCraft craft_1 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,4,0,4,29,4,0,4,0)),33);
	  creationCraft craft_15 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,9,0,9,29,9,0,9,0)),34);
	  creationCraft craft_41 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,29,0,0,1,0,0)),30);
	  creationCraft craft_42 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,29,0,0,1,0)),30);
	  creationCraft craft_43 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,29,0,0,1)),30);
	  creationCraft craft_44 = new creationCraft(new ArrayList<Integer>(Arrays.asList(28,28,28,28,28,28,28,28,28)),34);
	  
	  //Weapon
	 
	  creationCraft craft_14 = new creationCraft(new ArrayList<Integer>(Arrays.asList(14,14,14,14,14,14,0,14,0)),42);
	  creationCraft craft_32 = new creationCraft(new ArrayList<Integer>(Arrays.asList(14,0,0,14,0,0,8,0,0)),52);
	  creationCraft craft_33 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,14,0,0,14,0,0,8,0)),52);
	  creationCraft craft_34 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,14,0,0,14,0,0,8)),52);
	  creationCraft craft_48 = new creationCraft(new ArrayList<Integer>(Arrays.asList(9,0,0,3,0,0,15,0,0)),45);
	  creationCraft craft_49 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,9,0,0,3,0,0,15,0)),45);
	  creationCraft craft_50 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,9,0,0,3,0,0,15)),45);

	  
	  //Creation du dico avec les crafts
	  Map<Integer,creationCraft> dicoCraft=new HashMap<Integer,creationCraft>();
	  dicoCraft.put(1, craft_1);
	  dicoCraft.put(10, craft_2);dicoCraft.put(11, craft_3);dicoCraft.put(12, craft_4);
	  dicoCraft.put(20, craft_5);dicoCraft.put(21, craft_6);dicoCraft.put(22, craft_7);
	  dicoCraft.put(30, craft_8);dicoCraft.put(31, craft_9);dicoCraft.put(32, craft_10);dicoCraft.put(33, craft_11);dicoCraft.put(34, craft_12);dicoCraft.put(35, craft_13);
	  dicoCraft.put(40, craft_14);
	  dicoCraft.put(50, craft_15);
	  dicoCraft.put(60, craft_16);dicoCraft.put(61, craft_17);dicoCraft.put(62, craft_18);dicoCraft.put(63, craft_19);
	  dicoCraft.put(70, craft_20);dicoCraft.put(71, craft_21);dicoCraft.put(72, craft_22);
	  dicoCraft.put(80, craft_23);dicoCraft.put(81, craft_24);dicoCraft.put(82, craft_25);
	  dicoCraft.put(90, craft_26);dicoCraft.put(91, craft_27);dicoCraft.put(92, craft_28);dicoCraft.put(93, craft_29);dicoCraft.put(94, craft_30);dicoCraft.put(95, craft_31);
	  dicoCraft.put(100, craft_32);dicoCraft.put(101, craft_33);dicoCraft.put(102, craft_34);
	  dicoCraft.put(110, craft_35);dicoCraft.put(111, craft_36);dicoCraft.put(112, craft_37);
	  dicoCraft.put(120, craft_38);dicoCraft.put(121, craft_39);dicoCraft.put(122, craft_40);
	  dicoCraft.put(130, craft_41);dicoCraft.put(131, craft_42);dicoCraft.put(132, craft_43);
	  dicoCraft.put(140, craft_44);
	  dicoCraft.put(140, craft_45);dicoCraft.put(141, craft_46);dicoCraft.put(142, craft_47);
	  dicoCraft.put(150, craft_48);dicoCraft.put(151, craft_49);dicoCraft.put(152, craft_50);
	  
    Button Bbase = new Button("Base");
    Button Bfood = new Button("Food");
    Button Blife = new Button("Life");
    Button Bweapon = new Button("Weapon");

    Button buttonAdd = new Button("ADD");
	Button buttonDel = new Button("DELETE");
	
	String bStyle = "-fx-background-color: linear-gradient(to right , #1c389b, #2d47ae, #3b57c1, #4967d4, #5777e8); -fx-text-fill: white ";
	Bbase.setStyle(bStyle);
	Bfood.setStyle(bStyle);
	Blife.setStyle(bStyle);
	Bweapon.setStyle(bStyle);
	buttonAdd.setStyle("-fx-background-color: linear-gradient(#50FE80, #36DD0F) ");
	buttonDel.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00) ");

	ToolBar toolBar = new ToolBar();
	toolBar.getItems().add(Bbase);
	toolBar.getItems().add(Bfood);
	toolBar.getItems().add(Blife);
	toolBar.getItems().add(Bweapon);
	
	toolBar.setMaxWidth(700);
	
	
	toolBar.setStyle("-fx-background-color: rgba(83, 87, 84, 0.9);");
	toolBar.setTranslateY(86);
	
	final VBox vb = new VBox();
	vb.setLayoutX(5);
    vb.setSpacing(10);
    
    String style = "-fx-background-color: rgba(23, 27, 24, 0.9);";
    vb.setStyle(style);
    vb.getChildren().addAll(sansTest1,sansTest2);
    vb.setTranslateX(580);
    
	
	//Les 4 groupes, permet de clean facilement une catégorie. +reessayer stackpane (peut être)
	Group Base = new Group();
	Group Food = new Group();
	Group Weapon = new Group();
	Group Life = new Group();
	Group Matrice = new Group();
	StackPane Succes = new StackPane();
	StackPane all = new StackPane();	
	final StackPane layout1 = new StackPane();
	final StackPane layout2 = new StackPane();
	
	
    Base.getChildren().addAll(limite1,limite2,dirt.imageView,sand.imageView,water.imageView,wood.imageView,rock.imageView,fire2.imageView,wind.imageView,ironNugget.imageView);
    Food.getChildren().addAll(limite3,limite4,beurre.imageView,ble.imageView,burgerPain.imageView,farine.imageView,fromage.imageView,pomme.imageView,salade.imageView,tomate.imageView);
    Life.getChildren().addAll(limite5,limite6,life.imageView);
    Weapon.getChildren().addAll(limite7,limite8);
    Matrice.getChildren().addAll(limite9,limite10);
    all.getChildren().addAll(Base);
    layout1.getChildren().addAll(decor1,craft,Dossier,inventaire,all,toolBar,buttonDel,buttonAdd,Matrice); //le Padre!
    Succes.getChildren().addAll(sansFA1,sansFA2,sansFA3,sansFA4,sansFA5,sansFA6,sansFA7,sansFA8);
    layout2.getChildren().addAll(decor2,vb,mini_craft,Succes);
    
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
    selected = null;
    
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
    
    //Positionnement du Décor dans le layout1
    craft.setTranslateX(-55);craft.setTranslateY(-85);
    craftOk.setTranslateX(-55);craftOk.setTranslateY(-85);
    buttonAdd.setTranslateX(82);buttonAdd.setTranslateY(-9);buttonAdd.setMinWidth(54);buttonAdd.setMaxHeight(5);
    buttonDel.setTranslateX(82);buttonDel.setTranslateY(18);
    Dossier.setTranslateX(300);Dossier.setTranslateY(-185);
    inventaire.setTranslateY(179);
    //Des achievements dans le layout2
    Succes.setTranslateX(-140);
    sansA1.setTranslateX(-140);sansA1.setTranslateY(-150);
    sansFA1.setTranslateX(-140);sansFA1.setTranslateY(-150);
    sansFAT1.setTranslateX(-140);sansFAT1.setTranslateY(-150);
    sansA2.setTranslateY(-150);
    sansFA2.setTranslateY(-150);
    sansFAT2.setTranslateY(-150);
    sansA3.setTranslateX(140);sansA3.setTranslateY(-150);
    sansFA3.setTranslateX(140);sansFA3.setTranslateY(-150);
    sansFAT3.setTranslateX(140);sansFAT3.setTranslateY(-150);
    sansA4.setTranslateX(-140);sansA4.setTranslateY(-20);
    sansFA4.setTranslateX(-140);sansFA4.setTranslateY(-20);
    sansFAT4.setTranslateX(-140);sansFAT4.setTranslateY(-20);
    sansA5.setTranslateY(-20);
    sansFA5.setTranslateY(-20);
    sansFAT5.setTranslateY(-20);
    sansA6.setTranslateX(140);sansA6.setTranslateY(-20);
    sansFA6.setTranslateX(140);sansFA6.setTranslateY(-20);
    sansFAT6.setTranslateX(140);sansFAT6.setTranslateY(-20);
    sansA7.setTranslateX(-140);sansA7.setTranslateY(110);
    sansFA7.setTranslateX(-140);sansFA7.setTranslateY(110);
    sansFAT7.setTranslateX(-140);sansFAT7.setTranslateY(110);
    sansA8.setTranslateY(110);
    sansFA8.setTranslateY(110);
    sansFAT8.setTranslateY(110);
    mini_craft.setTranslateX(130);mini_craft.setTranslateY(-200);
    
    
    //On lance la fenêtre
    scene1 = new Scene(layout1,700,500);
    scene2 = new Scene(layout2,700,500);
    stage.setScene(scene1);
    stage.getIcons().add(icon);
    stage.setTitle("Projet Minecraft");
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
            	  layout1.getChildren().clear();
              	  layout1.getChildren().addAll(decor1,craft,Dossier,inventaire,all,toolBar,buttonDel,buttonAdd,Matrice);//change le fond Craft au cas ou il y avait un craft valide.
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
            	  layout1.getChildren().clear();
                  layout1.getChildren().addAll(decor1,craft,Dossier,inventaire,all,toolBar,buttonDel,buttonAdd,Matrice);//Remet fond craft
            	  caMarche = false;
            	  clef = clef/10*10;
            	  for(int i=0;i<10;i++) {
              		dicoCraft.remove(clef+i);}
            	  int IdnouvelObjet = Integer.parseInt(Matrice.getChildren().get(Matrice.getChildren().size()-1).getId());
            	  
            	  if(1<=IdnouvelObjet && IdnouvelObjet<=17){
            		  Base.getChildren().add(Matrice.getChildren().get(Matrice.getChildren().size()-1));
            		  selected = Base.getChildren().get(Base.getChildren().size()-1);
            		  selected.setTranslateX(-330+(51*Math.round((Base.getChildren().size()-3)/3)));selected.setTranslateY(130+51*((Base.getChildren().size())%3));
            		  all.getChildren().clear();
                	  all.getChildren().addAll(Base);
                	  douquonest = 0;
            	  }
            	  else if(18<=IdnouvelObjet && IdnouvelObjet<=28){
            		  Food.getChildren().add(Matrice.getChildren().get(Matrice.getChildren().size()-1));
            		  selected = Food.getChildren().get(Food.getChildren().size()-1);
            		  selected.setTranslateX(-330+(51*Math.round((Food.getChildren().size()-3)/3)));selected.setTranslateY(130+51*((Food.getChildren().size())%3));
            		  all.getChildren().clear();
                	  all.getChildren().addAll(Food);
                	  douquonest = 1;
            	  }
            	  else if(29<=IdnouvelObjet && IdnouvelObjet<=35){
            		  Life.getChildren().add(Matrice.getChildren().get(Matrice.getChildren().size()-1));
            		  selected = Life.getChildren().get(Life.getChildren().size()-1);
              		  selected.setTranslateX(-330+(51*Math.round((Life.getChildren().size()-3)/3)));selected.setTranslateY(130+51*((Life.getChildren().size())%3));
            		  all.getChildren().clear();
                	  all.getChildren().addAll(Life);
                	  douquonest = 2;
            	  }
            	  else if(36<=IdnouvelObjet && IdnouvelObjet<=79){
            		  Weapon.getChildren().add(Matrice.getChildren().get(Matrice.getChildren().size()-1));
            		  selected = Weapon.getChildren().get(Weapon.getChildren().size()-1);
            		  selected.setTranslateX(-330+(51*Math.round((Weapon.getChildren().size()-3)/3)));selected.setTranslateY(130+51*((Weapon.getChildren().size())%3));
            		  all.getChildren().clear();
                	  all.getChildren().addAll(Weapon);
                	  douquonest = 3;
            	  }
            	  if(Integer.parseInt(selected.getId()) == 35) {
            		  Succes.getChildren().remove(sansFA1);
            		  Succes.getChildren().addAll(sansA1);
            	  }	
            	  
            	  for(int i =0;i<matrice.length*matrice.length;i++){
            		  matrice[i%3][i/3] = 0;}
            	  Matrice.getChildren().clear();
            	  Matrice.getChildren().addAll(limite9,limite10);
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
    
    layout2.setOnMousePressed(evt -> {
    	if(439<evt.getX() && evt.getX()<520 && 25<evt.getY() && evt.getY()<75) {
    	selected = null; //evite de garder un objet séléctionné car en cas de reclick l'objet se téléportait à l'endroit en question dans le layout 1.
    	test = false;
		stage.setScene(scene1);
    	}
    	
    });
    
    vb.setOnScroll((ScrollEvent event) -> {
        // Adjust the zoom factor as per your requirement
        double deltaY = event.getDeltaY();
        if (deltaY < 0 && vb.getChildren().get(vb.getChildren().size()-1).getTranslateY()>-110){
        	for(int i=0; i<vb.getChildren().size(); i++) {
        	vb.getChildren().get(i).setTranslateY((vb.getChildren().get(i).getTranslateY()) + deltaY/2);
        	}
        }
        if(deltaY > 0 && vb.getChildren().get(0).getTranslateY()<380) {
        	for(int i=0; i<vb.getChildren().size(); i++) {
            	vb.getChildren().get(i).setTranslateY((vb.getChildren().get(i).getTranslateY()) + deltaY/2);
            	}
        }
        
        
        
    });
    sansFA1.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {Succes.getChildren().add(sansFAT1);}});

    sansFAT1.setOnMouseExited(new EventHandler<MouseEvent>() {
    	@Override
        public void handle(MouseEvent t) {Succes.getChildren().remove(sansFAT1);}});
    
    sansFA2.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {Succes.getChildren().add(sansFAT2);}});

    sansFAT2.setOnMouseExited(new EventHandler<MouseEvent>() {
    	@Override
        public void handle(MouseEvent t) {Succes.getChildren().remove(sansFAT2);}});
    
    sansFA3.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {Succes.getChildren().add(sansFAT3);}});

    sansFAT3.setOnMouseExited(new EventHandler<MouseEvent>() {
    	@Override
        public void handle(MouseEvent t) {Succes.getChildren().remove(sansFAT3);}});
    
    sansFA4.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {Succes.getChildren().add(sansFAT4);}});

    sansFAT4.setOnMouseExited(new EventHandler<MouseEvent>() {
    	@Override
        public void handle(MouseEvent t) {Succes.getChildren().remove(sansFAT4);}});
    
    sansFA5.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {Succes.getChildren().add(sansFAT5);}});

    sansFAT5.setOnMouseExited(new EventHandler<MouseEvent>() {
    	@Override
        public void handle(MouseEvent t) {Succes.getChildren().remove(sansFAT5);}});
    
    sansFA6.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {Succes.getChildren().add(sansFAT6);}});

    sansFAT6.setOnMouseExited(new EventHandler<MouseEvent>() {
    	@Override
        public void handle(MouseEvent t) {Succes.getChildren().remove(sansFAT6);}});
    
    sansFA7.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {Succes.getChildren().add(sansFAT7);}});

    sansFAT7.setOnMouseExited(new EventHandler<MouseEvent>() {
    	@Override
        public void handle(MouseEvent t) {Succes.getChildren().remove(sansFAT7);}});
    
    sansFA8.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {Succes.getChildren().add(sansFAT8);}});

    sansFAT8.setOnMouseExited(new EventHandler<MouseEvent>() {
    	@Override
        public void handle(MouseEvent t) {Succes.getChildren().remove(sansFAT8);}});
    
    //Selection de la Node dans Layout1
    all.setOnMousePressed(evt -> {
    	
    	X = evt.getX();
    	Y = evt.getY();
    	
    	if(1294<evt.getX() && evt.getX()<1335 && 809<evt.getY() && evt.getY()<839) {
    		test = true;
    		stage.setScene(scene2);
    		
    	}
    	else {
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
    	}
    });
    
    //Mouvement
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
        if (selected != null && test == false) {
        	//Si on est dans la matrice
        	if(815<evt.getX() && evt.getX()<964 && 860<evt.getY() && evt.getY()<1009) {
        	for(int i=0; i<matrice.length*matrice.length;i++) {
        			if(815+50*(i%3)<=evt.getX() && evt.getX()<865+50*(i%3) && 860+50*(i/3)<=evt.getY() && evt.getY()<910+50*(i/3)) {
        				selected.setTranslateX(-175+50*(i%3));
                        selected.setTranslateY(-130+50*(i/3));
                        if (selected.getId() != null && matrice[i/3][i%3] ==0) {
                        	matrice[i/3][i%3] = Integer.valueOf(selected.getId()); //La matrice récupère l'ID de la Node.
                        if(caMarche ==true) { //delete le resultat si on rajoute un node dans la matrice
                        layout1.getChildren().clear();
                    	layout1.getChildren().addAll(decor1,craft,Dossier,inventaire,all,toolBar,buttonDel,buttonAdd,Matrice);//Remet fond craft
                        Matrice.getChildren().remove(Matrice.getChildren().size()-1);}
                        
                        Matrice.getChildren().add(selected);
                        creationImage newimage = new creationImage(listImage.get((Integer.parseInt(selected.getId()))),selected.getId());
                        // Ajoute ds le groupe actuel la copie de la Node;  change le selected en la copie pour la placer aux coords START(X/Y).
                        if (douquonest ==0) {Base.getChildren().add(newimage.imageView);selected = Base.getChildren().get(Base.getChildren().size()-1);} 
                    	else if (douquonest ==1) {Food.getChildren().add(newimage.imageView);selected = Food.getChildren().get(Food.getChildren().size()-1);} 
                    	else if (douquonest ==2) {Life.getChildren().add(newimage.imageView);selected = Life.getChildren().get(Life.getChildren().size()-1);} 
                    	else if (douquonest ==3) {Weapon.getChildren().add(newimage.imageView);selected = Weapon.getChildren().get(Weapon.getChildren().size()-1);} 

                        selected.setTranslateX(STARTX);
                        selected.setTranslateY(STARTY);
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
        while(idico.hasNext() && caMarche == false && test ==false) {
        	int compteur=0;
        	clef=idico.next();
        	valeur = dicoCraft.get(clef).liste;
      	  
      	  	//System.out.print(valeur);
      	    //System.out.println(liste);
      	
        	for(int k=0;k<liste.size();k++) {
        		if (valeur.get(k)==liste.get(k)) {
        			compteur+=1;
        		}
        }
        	if(compteur==craft_1.liste.size() && compteur==liste.size()) {
        		caMarche = true;
        		creationImage newImage = new creationImage(listImage.get(dicoCraft.get(clef).resultat), String.valueOf(dicoCraft.get(clef).resultat));
        		layout1.getChildren().clear();
        		layout1.getChildren().addAll(decor1,craftOk,Dossier,inventaire,all,toolBar,buttonDel,buttonAdd,Matrice);
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
