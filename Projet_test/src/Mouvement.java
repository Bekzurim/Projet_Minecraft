import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
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
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Mouvement extends Application {
	
	Scene scene1,scene2;
	Point2D offset,translateStart;
	Node selected;
	double STARTX,STARTY;
	double X,Y;
	int douquonest = 0;
	boolean caMarche,test,aideTxt,GreenPeace = false;
	Integer clef;
	int son = 100;

@Override public void start(final Stage stage) throws Exception {
	  // Liste pour récuprérer les images en fonction de l'ID
	  List<String> listImage = Arrays.asList("0","Base/Dirt.png","Base/bois.png","Base/wooden_block.png","Base/rock.png","Base/sand.png","Base/wind.png","Base/fire_2.png","Base/stick.png","Base/bone.png","Base/water.png","Base/glass.png","Base/glaçon.png","Base/iron_nugget.png","Base/iron_ingot.png","Base/feather.png","Base/silex2.png","Base/redstone.png",
	  "Food/baguette.png","Food/beurre.png","Food/ble.png","Food/burger_pain.png","Food/burger.png","Food/farine.png","Food/fromage.png","Food/pomme.png","Food/salade.png","Food/tomate.png","Food/viande.png","oeuf_brouillé.png","Food/noodles.png","Food/cake.png","Food/soda.png","Food/soupe_poisson.png",
	  "Life/life.png","Life/cow.png","Life/fish.png","Life/bird.png","Life/egg.png","Life/SMB.png","Life/sans.png","Life/human.png","Life/creeper.png",
	  "Weapon/ak.png","Weapon/axe.png","Weapon/backpack.png","Weapon/baseball_bat.png","Weapon/battle_axe.png","Weapon/battle_hammer.png","Weapon/bouclier.png","Weapon/bouteille_alcool.png","Weapon/bow.png","Weapon/bow-arrow.png","Weapon/briquet.png","Weapon/butcher_knife.png","Weapon/chainsaw.png","Weapon/double_spear.png","Weapon/Epee_classique.png","Weapon/gas_mask.png","Weapon/grenade.png","Weapon/grenade_laucher.png","Weapon/Katana1.png","Weapon/kunai.png","Weapon/lance.png","Weapon/lightsaber.png","Weapon/m4_petit.png","Weapon/medkiy.png","Weapon/military_knife.png","Weapon/molotov_cocktail.png","Weapon/pistol_ammo.png","Weapon/revolver.png","Weapon/rocket.png","Weapon/rocket_launcher.png","Weapon/scythe.png","Weapon/shotgun.png","Weapon/shuriken.png","Weapon/sniper.png","Weapon/poudre_a_canon.png",
	  "Weapon/TNT.png","Weapon/gameBoy.png");
	  // Liste pour afficher les Noms
	  List<String> listNom = Arrays.asList("0","Terre","Bois","Bloc de Bois","Pierre","Sable","Vent","Feu","Baton","Os","Eau","Verre","Glaçon","Pépite de Fer","Lingot de Fer","Plume","Silex","Redstone",
	  "Baguette","Beurre","Blé","Pain à Burger","Burger","Farine","Fromage","Pomme","Salade","Tomate","Viande","Oeuf_Brouillé","Noodles","Gateau","Soda","Soupe de Poisson",
	  "Vie","Vache","Poisson","Oiseau","Oeuf","Super Meat Boy","Sans","Humain","Creeper",
	  "Ak","Hache","Sac à dos","Batte de Baseball","Double Hache","Marteau","Bouclier","Bouteille","Arc","Flèche","Briquet","Couteau","Tronconneuse","Lance Double","Epée","Masque à Gaz","Grenade","Lance Grenade","Katana","Kunai","Lance","Sabre Laser","M4","Kit de Soin","Couteau Militaire","Cocktail Molotov","Balles","Revolver","Roquette","Lance Roquette","Faux","Fusil à Pompe","Shriken","Sniper","Poudre à Canon",
	  "TNT","GameBoy");

	  // Achievements
	  ImageView sansFA = new ImageView(new File("Achievements/sansFutureAchievement.png").toURI().toString());
	  ImageView sansFAT = new ImageView(new File("Achievements/sansFutureAchievementtxt.png").toURI().toString());
	  ImageView creeperFA = new ImageView(new File("Achievements/creeperFutureAchievement.png").toURI().toString());
	  ImageView creeperFAT = new ImageView(new File("Achievements/creeperFutureAchievementtxt.png").toURI().toString());
	  ImageView killFA = new ImageView(new File("Achievements/KillFutureAchievement.png").toURI().toString());
	  ImageView killFAT = new ImageView(new File("Achievements/KillFutureAchievementtxt.png").toURI().toString());
	  ImageView cakeFA = new ImageView(new File("Achievements/CakeFutureAchievement.png").toURI().toString());
	  ImageView cakeFAT = new ImageView(new File("Achievements/CakeFutureAchievementtxt.png").toURI().toString());
	  ImageView burgerFA = new ImageView(new File("Achievements/BurgerFutureAchievement.png").toURI().toString());
	  ImageView burgerFAT = new ImageView(new File("Achievements/BurgerFutureAchievementtxt.png").toURI().toString());
	  ImageView meatBoyFA = new ImageView(new File("Achievements/MeatBoyFutureAchievement.png").toURI().toString());
	  ImageView meatBoyFAT = new ImageView(new File("Achievements/MeatBoyFutureAchievementtxt.png").toURI().toString());
	  ImageView MLGFA = new ImageView(new File("Achievements/MLGFutureAchievement.png").toURI().toString());
	  ImageView MLGFAT = new ImageView(new File("Achievements/MLGFutureAchievementtxt.png").toURI().toString());
	  ImageView lightSaberFA = new ImageView(new File("Achievements/LightSaberFutureAchievement.png").toURI().toString());
	  ImageView lightSaberFAT = new ImageView(new File("Achievements/LightSaberFutureAchievementtxt.png").toURI().toString());
	  ImageView pingFA = new ImageView(new File("Achievements/PongFutureAchievement.png").toURI().toString());
	  ImageView pongFAT = new ImageView(new File("Achievements/PongFutureAchievementtxt.png").toURI().toString());
	  ImageView sansA = new ImageView(new File("Achievements/sansAchievement.png").toURI().toString());
	  ImageView creeperA = new ImageView(new File("Achievements/creeperAchievement.png").toURI().toString());
	  ImageView killA = new ImageView(new File("Achievements/KillAchievement.png").toURI().toString());
	  ImageView cakeA = new ImageView(new File("Achievements/CakeAchievement.png").toURI().toString());
	  ImageView burgerA = new ImageView(new File("Achievements/BurgerAchievement.png").toURI().toString());
	  ImageView meatBoyA = new ImageView(new File("Achievements/MeatBoyAchievement.png").toURI().toString());
	  ImageView MLGA = new ImageView(new File("Achievements/MLGAchievement.png").toURI().toString());
	  ImageView lightSaberA = new ImageView(new File("Achievements/LightSaberAchievement.png").toURI().toString());
	  ImageView pongA = new ImageView(new File("Achievements/PongAchievement.png").toURI().toString());
	  
	  ImageView sanstest = new ImageView(new File("Achievements/sansAchievement.png").toURI().toString());
	  ImageView creepertest = new ImageView(new File("Achievements/creeperAchievement.png").toURI().toString());
	  ImageView killtest = new ImageView(new File("Achievements/KillAchievement.png").toURI().toString());
	  ImageView caketest = new ImageView(new File("Achievements/CakeAchievement.png").toURI().toString());
	  ImageView burgertest = new ImageView(new File("Achievements/BurgerAchievement.png").toURI().toString());
	  ImageView meatBoytest = new ImageView(new File("Achievements/MeatBoyAchievement.png").toURI().toString());
	  ImageView MLGtest = new ImageView(new File("Achievements/MLGAchievement.png").toURI().toString());
	  ImageView lightSabertest = new ImageView(new File("Achievements/LightSaberAchievement.png").toURI().toString());
	  ImageView pongtest = new ImageView(new File("Achievements/PongAchievement.png").toURI().toString());
	  
	  // Les bases
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
	  creationImage silex = new creationImage("Base/silex2.png","16");
	  creationImage redstone = new creationImage("Base/redstone.png","17");
	  
	  // La bouffe
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
	  creationImage oeufBrouillé = new creationImage("Food/oeuf_brouillé.png","29");
	  creationImage noodles = new creationImage("Food/noodles.png","30");
	  creationImage cake = new creationImage("Food/cake.png","31");
	  creationImage soda = new creationImage("Food/soda.png","32");
	  creationImage soupe_poisson = new creationImage("Food/soupe_poisson.png","33");
	  
	  // La vie
	  creationImage life = new creationImage("Life/life.png","34");
	  creationImage cow = new creationImage("Life/cow.png","35");
	  creationImage fish = new creationImage("Life/fish.png","36");
	  creationImage bird = new creationImage("Life/bird.png","37");
	  creationImage egg = new creationImage("Life/egg.png","38");
	  creationImage SMB = new creationImage("Life/SMB.png","39");
	  creationImage Sans = new creationImage("Life/Sans.png","40");
	  creationImage human = new creationImage("Life/human.png","41");
	  creationImage creeper = new creationImage("Life/creeper.png","42");
	  
	  // Les armes
	  creationImage ak = new creationImage("Weapon/ak.png","43");
	  creationImage axe = new creationImage("Weapon/axe.png","44");
	  creationImage backpack = new creationImage("Weapon/backpack.png","45");
	  creationImage baseball_bat = new creationImage("Weapon/baseball_bat.png","46");
	  creationImage battle_axe = new creationImage("Weapon/battle_axe.png","47");
	  creationImage battle_hammer = new creationImage("Weapon/battle_hammer.png","48");
	  creationImage bouclier = new creationImage("Weapon/bouclier.png","49");
	  creationImage bouteille_alcool = new creationImage("Weapon/bouteille_alcool.png","50");
	  creationImage bow = new creationImage("Weapon/bow.png","51");
	  creationImage bow_arrow = new creationImage("Weapon/bow-arrow.png","52");
	  creationImage briquet = new creationImage("Weapon/briquet.png","53");
	  creationImage butcher_knife = new creationImage("Weapon/butcher_knife.png","54");
	  creationImage chainsaw = new creationImage("Weapon/chainsaw.png","55");
	  creationImage double_spear = new creationImage("Weapon/double_spear.png","56");
	  creationImage Epee_classique = new creationImage("Weapon/Epee_classique.png","57");
	  creationImage gas_mask = new creationImage("Weapon/gas_mask.png","58");
	  creationImage grenade = new creationImage("Weapon/grenade.png","59");
	  creationImage grenade_laucher = new creationImage("Weapon/grenade_laucher.png","60");
	  creationImage Katana1 = new creationImage("Weapon/Katana1.png","61");
	  creationImage kunai = new creationImage("Weapon/kunai.png","62");
	  creationImage lance = new creationImage("Weapon/lance.png","63");
	  creationImage lightsaber = new creationImage("Weapon/lightsaber.png","64");
	  creationImage m4 = new creationImage("Weapon/m4_petit.png","65");
	  creationImage medkiy = new creationImage("Weapon/medkiy.png","66");
	  creationImage military_knife = new creationImage("Weapon/military_knife.png","67");
	  creationImage molotov_cocktail = new creationImage("Weapon/molotov_cocktail.png","68");
	  creationImage pistol_ammo = new creationImage("Weapon/pistol_ammo.png","69");
	  creationImage revolver = new creationImage("Weapon/revolver.png","70");
	  creationImage rocket = new creationImage("Weapon/rocket.png","71");
	  creationImage rocket_launcher = new creationImage("Weapon/rocket_launcher.png","72");
	  creationImage scythe = new creationImage("Weapon/scythe.png","73");
	  creationImage shotgun = new creationImage("Weapon/shotgun.png","74");
	  creationImage shuriken = new creationImage("Weapon/shuriken.png","75");
	  creationImage sniper = new creationImage("Weapon/sniper.png","76");
	  creationImage gunPowder = new creationImage("Weapon/poudre_a_canon.png","77");
	  creationImage tnt = new creationImage("Weapon/TNT.png","78");
	  creationImage gameBoy = new creationImage("Weapon/gameBoy.png","79");
	  
	  // Création des crafts
	  
	// Base
	  creationCraft craft_16 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,2,2,0,2,2,0,0,0)),3); //Wooden blocs
	  creationCraft craft_17 = new creationCraft(new ArrayList<Integer>(Arrays.asList(2,2,0,2,2,0,0,0,0)),3);
	  creationCraft craft_18 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,2,2,0,2,2,0)),3);
	  creationCraft craft_19 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,2,2,0,2,2)),3);
	  creationCraft craft_26 = new creationCraft(new ArrayList<Integer>(Arrays.asList(3,0,0,3,0,0,0,0,0)),8); //Stick
	  creationCraft craft_27 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,3,0,0,3,0,0,0,0)),8);
	  creationCraft craft_28 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,3,0,0,3,0,0,0)),8);
	  creationCraft craft_29 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,3,0,0,3,0,0)),8);
	  creationCraft craft_30 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,3,0,0,3,0)),8);
	  creationCraft craft_31 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,3,0,0,3)),8);
	  creationCraft craft_35 = new creationCraft(new ArrayList<Integer>(Arrays.asList(54,36,0,0,0,0,0,0,0)),9); //Os
	  creationCraft craft_36 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,54,36,0,0,0,0)),9);
	  creationCraft craft_37 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,54,36,0)),9);
	  creationCraft craft_2 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,5,0,0,7,0,0)),11); //Verre 
	  creationCraft craft_3 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,5,0,0,7,0)),11);
	  creationCraft craft_4 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,5,0,0,7)),11);
	  creationCraft craft_5 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,13,0,0,7,0,0)),14); //Lingot de fer
	  creationCraft craft_6 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,13,0,0,7,0)),14);
	  creationCraft craft_7 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,13,0,0,7)),14);
	  creationCraft craft_45 = new creationCraft(new ArrayList<Integer>(Arrays.asList(54,37,0,0,0,0,0,0,0)),15); //Plume
	  creationCraft craft_46 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,54,37,0,0,0,0)),15);
	  creationCraft craft_47 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,54,37,0)),15);
	  
	  // Food
	  creationCraft craft_60 = new creationCraft(new ArrayList<Integer>(Arrays.asList(20,20,20,0,7,0,0,0,0)),18); //Baguette
	  creationCraft craft_61 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,20,20,20,0,7,0)),18);
	  creationCraft craft_burger_pain_1 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,54,18,0,0,0,0)),21); //Pain de burger
	  creationCraft craft_burger_pain_2 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,18,54,0,0,0)),21);
	  creationCraft craft_8 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,21,0,26,27,28,0,21,0)),22); //Burger
	  creationCraft craft_9 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,21,0,27,26,28,0,21,0)),22);
	  creationCraft craft_10 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,21,0,27,28,26,0,21,0)),22);
	  creationCraft craft_11 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,21,0,26,28,27,0,21,0)),22);
	  creationCraft craft_12 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,21,0,28,26,27,0,21,0)),22);
	  creationCraft craft_13 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,21,0,28,27,26,0,21,0)),22);
	  creationCraft craft_farine_1 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,48,20,0,0,0,0)),23); //Farine
	  creationCraft craft_farine_2 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,20,48,0,0,0)),23);
	  creationCraft craft_38 = new creationCraft(new ArrayList<Integer>(Arrays.asList(54,35,0,0,0,0,0,0,0)),28); //Viande
	  creationCraft craft_39 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,54,35,0,0,0,0)),28);
	  creationCraft craft_40 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,54,35,0)),28);
	  creationCraft craft_oeuf_brouille_1 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,38,0,0,7,0,0)),29); //Oeuf brouillés
	  creationCraft craft_oeuf_brouille_2 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,38,0,0,7,0)),29);
	  creationCraft craft_oeuf_brouille_3 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,38,0,0,7)),29);
	  creationCraft craft_noodle = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,38,8,23,0,10)),30); //Nouilles (selon Wadie)
	  creationCraft craft_62 = new creationCraft(new ArrayList<Integer>(Arrays.asList(25,25,25,19,19,19,23,23,23)),31); //Gateau
	  creationCraft craft_56 = new creationCraft(new ArrayList<Integer>(Arrays.asList(11,10,11,11,10,11,11,11,11)),32); //Soda
	  creationCraft craft_soupe_poisson_1 = new creationCraft(new ArrayList<Integer>(Arrays.asList(10,36,10,0,10,0,0,7,0)),33); //Soupe de poisson
	  creationCraft craft_soupe_poisson_2 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,36,0,10,10,10,0,7,0)),33); 
	  
	  // Life
	  creationCraft craft_41 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,34,0,0,1,0,0)),35); //Vache
	  creationCraft craft_42 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,34,0,0,1,0)),35);
	  creationCraft craft_43 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,34,0,0,1)),35);
	  creationCraft craft_20 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,10,0,0,38,0,0)),36); //Poisson
	  creationCraft craft_21 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,10,0,0,38,0)),36);
	  creationCraft craft_22 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,10,0,0,38)),36);
	  creationCraft craft_23 = new creationCraft(new ArrayList<Integer>(Arrays.asList(38,0,0,6,0,0,0,0,0)),37); //Oiseau
	  creationCraft craft_24 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,38,0,0,6,0,0,0,0)),37);
	  creationCraft craft_25 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,38,0,0,6,0,0,0)),37);
	  creationCraft craft_1 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,4,0,4,34,4,0,4,0)),38); //Oeuf
	  creationCraft craft_44 = new creationCraft(new ArrayList<Integer>(Arrays.asList(28,28,28,28,28,28,28,28,28)),39); //Super Meat Boy
	  creationCraft craft_15 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,9,0,9,34,9,0,9,0)),40); //Sans
	  creationCraft craft_human_1 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,57,34,0,0,0,0)),41); //Humain
	  creationCraft craft_human_2 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,34,57,0,0,0)),41);
	  creationCraft craft_human_3 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,70,34,0,0,0,0)),41); 
	  creationCraft craft_human_4 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,34,70,0,0,0)),41);
	  creationCraft craft_52 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,78,0,78,34,78,0,78,0)),42); //Creeper
	  
	  // Weapon
	  creationCraft craft_ak = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,3,3,70,3,0,0)),43); //Ak
	  creationCraft craft_hache = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,14,14,0,8,14,0,8,0)),44); //Hache
	  creationCraft craft_bat = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,3,3,0,3,3,8,0,0)),46); //Batte de baseball
	  creationCraft craft_battle_axe = new creationCraft(new ArrayList<Integer>(Arrays.asList(14,14,14,14,8,14,0,8,0)),47); //Hache de guerre
	  creationCraft craft_battle_hammer = new creationCraft(new ArrayList<Integer>(Arrays.asList(14,0,14,14,8,14,0,8,0)),48); //Marteau de guerre
	  creationCraft craft_14 = new creationCraft(new ArrayList<Integer>(Arrays.asList(14,14,14,14,14,14,0,14,0)),49); //Bouclier
	  creationCraft craft_bouteille_alcool = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,11,0,11,10,11,11,11,11)),50); //Bouteille alcool
	  creationCraft craft_48 = new creationCraft(new ArrayList<Integer>(Arrays.asList(9,0,0,8,0,0,15,0,0)),52); //Fleche d'arc
	  creationCraft craft_49 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,9,0,0,8,0,0,15,0)),52);
	  creationCraft craft_50 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,9,0,0,8,0,0,15)),52);
	  creationCraft craft_57 = new creationCraft(new ArrayList<Integer>(Arrays.asList(16,0,0,14,0,0,14,0,0)),53); //Briquet
	  creationCraft craft_58 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,16,0,0,14,0,0,14,0)),53);
	  creationCraft craft_59 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,16,0,0,14,0,0,14)),53);
	  creationCraft craft_butcher_knife_1 = new creationCraft(new ArrayList<Integer>(Arrays.asList(14,14,0,8,14,0,8,14,0)),54); //Couteau de boucher
	  creationCraft craft_butcher_knife_2 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,14,14,0,8,14,0,8,14)),54); 
	  creationCraft craft_chainsaw = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,3,13,14,3,13,14)),55); //Tronconeuse
	  creationCraft craft_double_spear = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,13,14,13,8,13,14,13,0)),56); //Double lance
	  creationCraft craft_32 = new creationCraft(new ArrayList<Integer>(Arrays.asList(14,0,0,14,0,0,8,0,0)),57); //Epee classique
	  creationCraft craft_33 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,14,0,0,14,0,0,8,0)),57);
	  creationCraft craft_34 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,14,0,0,14,0,0,8)),57);
	  creationCraft craft_grenade = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,5,13,5,77,5,0,5,0)),59); //Grenade
	  creationCraft craft_lance_grenade = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,59,0,59,70,59,0,59,0)),60); //Lance grenade
	  creationCraft craft_katana = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,13,0,0,13,0,0,8,0)),61); //Katana
	  creationCraft craft_kunai = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,14,14,0,13,14,13,0,0)),62); //Kunai
	  creationCraft craft_spear = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,14,0,8,0,8,0,0)),63); //Lance
	  creationCraft craft_53 = new creationCraft(new ArrayList<Integer>(Arrays.asList(17,0,0,17,0,0,8,0,0)),64); //Sabre laser
	  creationCraft craft_54 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,17,0,0,17,0,0,8,0)),64);
	  creationCraft craft_55 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,17,0,0,17,0,0,8)),64);
	  creationCraft craft_m4 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,70,14,14,0,0,0)),65); //M4
	  creationCraft craft_medkit = new creationCraft(new ArrayList<Integer>(Arrays.asList(34,34,34,34,41,34,34,34,34)),66); //Medkit
	  creationCraft craft_military_knife_1 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,14,13,0,13,14,0,8,8)),67); //Couteau militaire
	  creationCraft craft_military_knife_2 = new creationCraft(new ArrayList<Integer>(Arrays.asList(14,13,0,13,14,0,8,8,0)),67);
	  creationCraft craft_molotov_1 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,53,0,50,0,0)),68); //Cocktail molotof
	  creationCraft craft_molotov_2 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,53,0,50,0)),68);
	  creationCraft craft_63 = new creationCraft(new ArrayList<Integer>(Arrays.asList(16,0,0,77,0,0,14,0,0)),69); //Munitions
	  creationCraft craft_64 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,16,0,0,77,0,0,14,0)),69);
	  creationCraft craft_65 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,16,0,0,77,0,0,14)),69);
	  creationCraft craft_revolver = new creationCraft(new ArrayList<Integer>(Arrays.asList(17,14,14,3,14,0,3,0,0)),70); //Revolver
	  creationCraft craft_rocket = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,14,0,14,77,14,0,7,0)),71); //Roquette
	  creationCraft craft_lance_rocket = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,71,0,71,70,71,0,71,0)),72); //Lance roquette
	  creationCraft craft_scythe = new creationCraft(new ArrayList<Integer>(Arrays.asList(14,14,0,8,14,0,8,14,0)),73); //Faux
	  creationCraft craft_shotgun = new creationCraft(new ArrayList<Integer>(Arrays.asList(77,77,7,77,70,77,77,77,77)),74); //Fusil a pompe
	  creationCraft craft_shuriken = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,13,0,13,0,13,0,13,0)),75); //Shuriken
	  creationCraft craft_sniper = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,14,14,0,70,0,0,0,0)),76); //Fusil a lunette
	  creationCraft craft_51 = new creationCraft(new ArrayList<Integer>(Arrays.asList(77,5,77,5,77,5,77,5,77)),78); //TNT
	  creationCraft craft_66 = new creationCraft(new ArrayList<Integer>(Arrays.asList(8,0,0,0,69,0,0,0,8)),79); //GameBoy
	  creationCraft craft_67 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,0,8,69,8,0,0,0)),79);
	  creationCraft craft_68 = new creationCraft(new ArrayList<Integer>(Arrays.asList(0,0,8,0,69,0,8,0,0)),79);
	  
	  // Creation du dico avec les crafts
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
	  dicoCraft.put(150, craft_44);
	  dicoCraft.put(160, craft_45);dicoCraft.put(161, craft_46);dicoCraft.put(162, craft_47);
	  dicoCraft.put(170, craft_48);dicoCraft.put(171, craft_49);dicoCraft.put(172, craft_50);
	  dicoCraft.put(180, craft_51);
	  dicoCraft.put(190, craft_52);
	  dicoCraft.put(200, craft_53);dicoCraft.put(201, craft_54);dicoCraft.put(202, craft_55);
	  dicoCraft.put(210, craft_56);
	  dicoCraft.put(220, craft_57);dicoCraft.put(221, craft_58);dicoCraft.put(222, craft_59);
	  dicoCraft.put(230, craft_60);dicoCraft.put(231, craft_61);
	  dicoCraft.put(240, craft_62);
	  dicoCraft.put(250, craft_63);dicoCraft.put(251, craft_64);dicoCraft.put(252, craft_65);
	  dicoCraft.put(260, craft_66);dicoCraft.put(261, craft_67);dicoCraft.put(262, craft_68);
	  dicoCraft.put(270, craft_burger_pain_1);dicoCraft.put(271, craft_burger_pain_2);
	  dicoCraft.put(280, craft_farine_1);dicoCraft.put(281, craft_farine_2);
	  dicoCraft.put(290, craft_soupe_poisson_1);dicoCraft.put(291, craft_soupe_poisson_2);
	  dicoCraft.put(300, craft_oeuf_brouille_1);dicoCraft.put(301, craft_oeuf_brouille_2);dicoCraft.put(302, craft_oeuf_brouille_3);
	  dicoCraft.put(310, craft_human_1);dicoCraft.put(311, craft_human_2);dicoCraft.put(312, craft_human_3);dicoCraft.put(313, craft_human_4);
	  dicoCraft.put(320, craft_ak);
	  dicoCraft.put(330, craft_hache);
	  dicoCraft.put(340, craft_bat);
	  dicoCraft.put(350, craft_battle_axe);
	  dicoCraft.put(360, craft_battle_hammer);
	  dicoCraft.put(370, craft_bouteille_alcool);
	  dicoCraft.put(380, craft_butcher_knife_1);dicoCraft.put(381, craft_butcher_knife_2);
	  dicoCraft.put(390, craft_chainsaw);
	  dicoCraft.put(400, craft_double_spear);
	  dicoCraft.put(410, craft_grenade);
	  dicoCraft.put(420, craft_lance_grenade);
	  dicoCraft.put(430, craft_katana);
	  dicoCraft.put(440, craft_kunai);
	  dicoCraft.put(450, craft_spear);
	  dicoCraft.put(460, craft_noodle);
	  dicoCraft.put(470, craft_m4);
	  dicoCraft.put(480, craft_medkit);
	  dicoCraft.put(490, craft_military_knife_1);dicoCraft.put(491, craft_military_knife_2);
	  dicoCraft.put(500, craft_molotov_1);dicoCraft.put(501, craft_molotov_2);
	  dicoCraft.put(510, craft_revolver);
	  dicoCraft.put(520, craft_rocket);
	  dicoCraft.put(530, craft_lance_rocket);
	  dicoCraft.put(540, craft_scythe);
	  dicoCraft.put(550, craft_shotgun);
	  dicoCraft.put(560, craft_shuriken);
	  dicoCraft.put(570, craft_sniper);
	   
	AudioClip ASound = new AudioClip(new File("Sound/achievement.wav").toURI().toString());
	AudioClip BSound = new AudioClip(new File("Sound/BackgroundSound.wav").toURI().toString());
	AudioClip CSound = new AudioClip(new File("Sound/craft.wav").toURI().toString());
	
	MediaPlayer a =new MediaPlayer(new Media(new File("Sound/BackgroundSound.wav").toURI().toString())); 
	
	// Barre du Menu
	MenuBar menuBar = new MenuBar();
	Menu menu = new Menu("Menu");
	Menu menu2 = new Menu("Son");
	CheckMenuItem checkMenuItem = new CheckMenuItem("Afficher le nom des Objets");
	CustomMenuItem customMenuItem = new CustomMenuItem();
	Slider VolumeSlider = new Slider(0, 100, 50);
	menu.getItems().add(checkMenuItem);
	customMenuItem.setContent(VolumeSlider);
	menu2.getItems().add(customMenuItem);
	menuBar.setStyle("-fx-background-color: rgba(83, 87, 84, 0.9);");
	menuBar.setMinWidth(700); // Prend la longueur de l'écran car Group n'agit pas comme StackPane
	menuBar.getMenus().addAll(menu,menu2);
	
	final Group mb = new Group(menuBar);
	mb.setTranslateY(-237);
	
	VolumeSlider.valueProperty().addListener(new InvalidationListener() {
         public void invalidated(Observable observable) {
        	 	 son =  (int)VolumeSlider.getValue();
                 BSound.setVolume(son);
        	     System.out.println(BSound.getVolume());
         }
     });
	
	 a.setOnEndOfMedia(new Runnable() {
	       public void run() {
	         a.seek(Duration.ZERO);
	       }
	   });
	  
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
	vb.setSpacing(10);
    
    String style = "-fx-background-color: rgba(23, 27, 24, 0.9);";
    vb.setStyle(style);
    vb.getChildren().addAll(sanstest,creepertest,killtest,caketest,burgertest,meatBoytest,MLGtest,lightSabertest,pongtest);
    vb.setTranslateX(275);
    vb.setMaxWidth(150);
    
	
	// Les 4 groupes, permet de clean facilement une catégorie. +reessayer stackpane (peut être)
	Group Base = new Group();
	Group Food = new Group();
	Group Life = new Group();
	Group Weapon = new Group();
	Group Matrice = new Group();
	StackPane Succes = new StackPane();
	StackPane all = new StackPane();	
	final StackPane layout1 = new StackPane();
	final StackPane layout2 = new StackPane();
	final StackPane texte = new StackPane();
	
    Base.getChildren().addAll(limite1,limite2,dirt.imageView,sand.imageView,water.imageView,wood.imageView,rock.imageView,fire2.imageView,wind.imageView,ironNugget.imageView,redstone.imageView,silex.imageView);
    Food.getChildren().addAll(limite3,limite4,beurre.imageView,ble.imageView,burgerPain.imageView,farine.imageView,fromage.imageView,pomme.imageView,salade.imageView,tomate.imageView);
    Life.getChildren().addAll(limite5,limite6,life.imageView);
    Weapon.getChildren().addAll(limite7,limite8,gunPowder.imageView);
    Matrice.getChildren().addAll(limite9,limite10);
    all.getChildren().addAll(Base);
    layout1.getChildren().addAll(decor1,craft,Dossier,inventaire,texte,all,toolBar,buttonDel,buttonAdd,Matrice,mb); // le Padre!
    Succes.getChildren().addAll(sansFA,creeperFA,killFA,cakeFA,burgerFA,meatBoyFA,MLGFA,lightSaberFA,pingFA);
    layout2.getChildren().addAll(decor2,vb,mini_craft,Succes);
    
    // Positionnement des Nodes à la mano.
    for(int i=0; i<Base.getChildren().size()-2; i++){
    		selected = Base.getChildren().get(i+2);
    		selected.setTranslateX(-330+(51*Math.round(i/3)));selected.setTranslateY(130+50*(i%3));
    }
    for(int i=0; i<Food.getChildren().size()-2; i++){
		selected = Food.getChildren().get(i+2);
		selected.setTranslateX(-330+(51*Math.round(i/3)));selected.setTranslateY(130+50*(i%3));
    }
    for(int i=0; i<Life.getChildren().size()-2; i++){
		selected = Life.getChildren().get(i+2);
		selected.setTranslateX(-330+(51*Math.round(i/3)));selected.setTranslateY(130+50*(i%3));
    }
    for(int i=0; i<Weapon.getChildren().size()-2; i++){
		selected = Weapon.getChildren().get(i+2);
		selected.setTranslateX(-330+(51*Math.round(i/3)));selected.setTranslateY(130+50*(i%3));
    }
    selected = null;
    
    // Ca c'est pas jojo mais la classe Group s'étandant aux nodes les plus éloignées 
    // il fallait des limites qu'on ne pouvait franchir.
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
    
    // Positionnement du Décor dans le layout1
    craft.setTranslateX(-55);craft.setTranslateY(-85);
    craftOk.setTranslateX(-55);craftOk.setTranslateY(-85);
    buttonAdd.setTranslateX(82);buttonAdd.setTranslateY(-9);buttonAdd.setMinWidth(54);buttonAdd.setMaxHeight(5);
    buttonDel.setTranslateX(82);buttonDel.setTranslateY(18);
    Dossier.setTranslateX(300);Dossier.setTranslateY(-185);
    inventaire.setTranslateY(179);
    //Des achievements dans le layout2
    Succes.setTranslateX(-140);
    sansA.setTranslateX(-140);sansA.setTranslateY(-150);
    sansFA.setTranslateX(-140);sansFA.setTranslateY(-150);
    sansFAT.setTranslateX(-140);sansFAT.setTranslateY(-150);
    creeperA.setTranslateY(-150);
    creeperFA.setTranslateY(-150);
    creeperFAT.setTranslateY(-150);
    killA.setTranslateX(140);killA.setTranslateY(-150);
    killFA.setTranslateX(140);killFA.setTranslateY(-150);
    killFAT.setTranslateX(140);killFAT.setTranslateY(-150);
    cakeA.setTranslateX(-140);cakeA.setTranslateY(-20);
    cakeFA.setTranslateX(-140);cakeFA.setTranslateY(-20);
    cakeFAT.setTranslateX(-140);cakeFAT.setTranslateY(-20);
    burgerA.setTranslateY(-20);
    burgerFA.setTranslateY(-20);
    burgerFAT.setTranslateY(-20);
    meatBoyA.setTranslateX(140);meatBoyA.setTranslateY(-20);
    meatBoyFA.setTranslateX(140);meatBoyFA.setTranslateY(-20);
    meatBoyFAT.setTranslateX(140);meatBoyFAT.setTranslateY(-20);
    MLGA.setTranslateX(-140);MLGA.setTranslateY(110);
    MLGFA.setTranslateX(-140);MLGFA.setTranslateY(110);
    MLGFAT.setTranslateX(-140);MLGFAT.setTranslateY(110);
    lightSaberA.setTranslateY(110);
    lightSaberFA.setTranslateY(110);
    lightSaberFAT.setTranslateY(110);
    pongA.setTranslateX(140);pongA.setTranslateY(110);
    pingFA.setTranslateX(140);pingFA.setTranslateY(110);
    pongFAT.setTranslateX(140);pongFAT.setTranslateY(110);
    mini_craft.setTranslateX(130);mini_craft.setTranslateY(-200);

    // On lance la fenêtre
    scene1 = new Scene(layout1,700,500);
    scene2 = new Scene(layout2,700,500);
    stage.setMaxWidth(713);
    stage.setMaxHeight(535);
    stage.setScene(scene1);
    stage.getIcons().add(icon);
    stage.setTitle("Projet Minecraft");
    stage.show();
    a.play();
    
    // Matrice centrale
    int[][] matrice = new int[3][3];
    
////////////////////////////////////////////     Boutons event     ////////////////////////////////////////////
    
    // N'affiche que les Nodes du Group Base (clear les autres).
    Bbase.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {

            	  texte.getChildren().clear();
            	  all.getChildren().clear();
            	  all.getChildren().addAll(Base);
            	  douquonest = 0;	  
              }
            });
    
    // N'affiche que les Nodes du Group Food (clear les autres).
    Bfood.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  texte.getChildren().clear();
            	  all.getChildren().clear();	
            	  all.getChildren().addAll(Food);
            	  douquonest = 1;
            	  
              }
            });
    
    // N'affiche que les Nodes du Group Life (clear les autres).
    Blife.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  texte.getChildren().clear();
            	  all.getChildren().clear();
            	  all.getChildren().addAll(Life);
            	  douquonest = 2;	  
              }
            });
    
    // N'affiche que les Nodes du Group Weapon (clear les autres).
    Bweapon.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  texte.getChildren().clear();
            	  all.getChildren().clear();
            	  all.getChildren().addAll(Weapon);
            	  douquonest = 3;	  
              }
            });
    
    // Animation du bouton delete + vide le Groupe Matrice
    buttonDel.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  layout1.getChildren().clear();
              	  layout1.getChildren().addAll(decor1,craft,Dossier,inventaire,texte,all,toolBar,buttonDel,buttonAdd,Matrice,mb);//change le fond Craft au cas ou il y avait un craft valide.
            	  caMarche = false;
            	  for(int i =0;i<matrice.length*matrice.length;i++){
            		  matrice[i%3][i/3] = 0;}
            	  buttonDel.setStyle("-fx-background-color: #ff0000;");
            	  Matrice.getChildren().clear();
            	  Matrice.getChildren().addAll(limite9,limite10); //peut être pas necessaire
              }
            });
    
    // Animation du bouton delete
    buttonDel.addEventHandler(MouseEvent.MOUSE_RELEASED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  buttonDel.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00) ");
              }
            });
    
    // Animation du Bouton Add + ajout si possible de la nouvelle Node à son groupe (et clean de la matrice)
    buttonAdd.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  buttonAdd.setStyle("-fx-background-color: #00FF2D;");
            	  if(caMarche == true) {
            	  layout1.getChildren().clear();
                  layout1.getChildren().addAll(decor1,craft,Dossier,inventaire,texte,all,toolBar,buttonDel,buttonAdd,Matrice,mb);//Remet fond craft
            	  caMarche = false;
            	  clef = clef/10*10;
            	  for(int i=0;i<10;i++) {
              		dicoCraft.remove(clef+i);}// Clean toutes autres les possibilités de craft
            	  int IdnouvelObjet = Integer.parseInt(Matrice.getChildren().get(Matrice.getChildren().size()-1).getId());
            	  
            	  if(1<=IdnouvelObjet && IdnouvelObjet<=17){ // Place nouvelle node dans Base
            		  Base.getChildren().add(Matrice.getChildren().get(Matrice.getChildren().size()-1));
            		  selected = Base.getChildren().get(Base.getChildren().size()-1);
            		  ((ImageView) selected).setFitHeight(30);
            		  ((ImageView) selected).setFitWidth(30);
            		  selected.setTranslateX(-330+(51*Math.round((Base.getChildren().size()-3)/3)));selected.setTranslateY(130+51*((Base.getChildren().size())%3));
            		  all.getChildren().clear();
                	  all.getChildren().addAll(Base);
                	  douquonest = 0;
            	  }
            	  else if(18<=IdnouvelObjet && IdnouvelObjet<=33){ // Place nouvelle node dans Food
            		  Food.getChildren().add(Matrice.getChildren().get(Matrice.getChildren().size()-1));
            		  selected = Food.getChildren().get(Food.getChildren().size()-1);
            		  ((ImageView) selected).setFitHeight(30);
            		  ((ImageView) selected).setFitWidth(30);
            		  selected.setTranslateX(-330+(51*Math.round((Food.getChildren().size()-3)/3)));selected.setTranslateY(130+51*((Food.getChildren().size())%3));
            		  all.getChildren().clear();
                	  all.getChildren().addAll(Food);
                	  douquonest = 1;
            	  }
            	  else if(34<=IdnouvelObjet && IdnouvelObjet<=42){ // Place nouvelle node dans Life
            		  Life.getChildren().add(Matrice.getChildren().get(Matrice.getChildren().size()-1));
            		  selected = Life.getChildren().get(Life.getChildren().size()-1);
            		  ((ImageView) selected).setFitHeight(30);
            		  ((ImageView) selected).setFitWidth(30);
              		  selected.setTranslateX(-330+(51*Math.round((Life.getChildren().size()-3)/3)));selected.setTranslateY(130+51*((Life.getChildren().size())%3));
            		  all.getChildren().clear();
                	  all.getChildren().addAll(Life);
                	  douquonest = 2;
            	  }
            	  else if(43<=IdnouvelObjet && IdnouvelObjet<=79){ // Place nouvelle node dans Weapon
            		  Weapon.getChildren().add(Matrice.getChildren().get(Matrice.getChildren().size()-1));
            		  selected = Weapon.getChildren().get(Weapon.getChildren().size()-1);
            		  ((ImageView) selected).setFitHeight(30);
            		  ((ImageView) selected).setFitWidth(30);
            		  selected.setTranslateX(-330+(51*Math.round((Weapon.getChildren().size()-3)/3)));selected.setTranslateY(130+51*((Weapon.getChildren().size())%3));
            		  all.getChildren().clear();
                	  all.getChildren().addAll(Weapon);
                	  douquonest = 3;
            	  }
            	  // Si on débloque les Achievements
            	  if(Integer.parseInt(selected.getId()) == 40) {
            		  Succes.getChildren().remove(sansFA);
            		  Succes.getChildren().addAll(sansA);
            		  ASound.play();
            	  }	
            	  else if(Integer.parseInt(selected.getId()) == 42) {
            		  Succes.getChildren().remove(creeperFA);
            		  Succes.getChildren().addAll(creeperA);
            		  ASound.play();
            	  }
            	  else if((Integer.parseInt(selected.getId()) == 9 || Integer.parseInt(selected.getId()) == 15 || Integer.parseInt(selected.getId()) == 28) && GreenPeace == false) {
            		  GreenPeace = true;
            		  Succes.getChildren().remove(killFA);
            		  Succes.getChildren().addAll(killA);
            		  ASound.play();
            	  }
            	 else if(Integer.parseInt(selected.getId()) == 22) {
            		  Succes.getChildren().remove(burgerFA);
            		  Succes.getChildren().addAll(burgerA);
            		  ASound.play();
            	  }
            	 else if(Integer.parseInt(selected.getId()) == 39) {
            		  Succes.getChildren().remove(meatBoyFA);
            		  Succes.getChildren().addAll(meatBoyA);
            		  ASound.play();
            	  }	
            	 else if(Integer.parseInt(selected.getId()) == 31) {
            		  Succes.getChildren().remove(cakeFA);
            		  Succes.getChildren().addAll(cakeA);
            		  ASound.play();
            	  }	
            	 else if(Integer.parseInt(selected.getId()) == 64) {
            		  Succes.getChildren().remove(lightSaberFA);
            		  Succes.getChildren().addAll(lightSaberA);
            		  ASound.play();
            	  }	
            	 else if(Integer.parseInt(selected.getId()) == 79) {
            		  Succes.getChildren().remove(pingFA);
            		  Succes.getChildren().addAll(pongA);
            		  ASound.play();
            	  }
            	 else {
            		 CSound.play();
            	 }
            	  
            	  for(int i =0;i<matrice.length*matrice.length;i++){
            		  matrice[i%3][i/3] = 0;}
            	  Matrice.getChildren().clear();
            	  Matrice.getChildren().addAll(limite9,limite10);
              }
              }
            });
    
    // Animation du bouton Add
    buttonAdd.addEventHandler(MouseEvent.MOUSE_RELEASED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  buttonAdd.setStyle("-fx-background-color: linear-gradient(#50FE80, #36DD0F) ");
              }
            });
    
////////////////////////////////////////////     Mouse event     ////////////////////////////////////////////
    
    // Retour au Layout1
    layout2.setOnMousePressed(evt -> {
    	if(439<evt.getX() && evt.getX()<520 && 25<evt.getY() && evt.getY()<75) {
    	selected = null; //evite de garder un objet séléctionné car en cas de reclick l'objet se téléportait à l'endroit en question dans le layout 1.
    	test = false;
    	texte.getChildren().clear();
		stage.setScene(scene1);
    	}
    	
    });
    
    // Scroll pour l'historique
    vb.setOnScroll((ScrollEvent event) -> {
    	
        double deltaY = event.getDeltaY();
        if (deltaY < 0 && vb.getChildren().get(vb.getChildren().size()-1).getTranslateY()>-300){
        	for(int i=0; i<vb.getChildren().size(); i++) {
        	vb.getChildren().get(i).setTranslateY((vb.getChildren().get(i).getTranslateY()) + deltaY);
        	}
        }
        if(deltaY > 0 && vb.getChildren().get(0).getTranslateY()<280) {
        	for(int i=0; i<vb.getChildren().size(); i++) {
            	vb.getChildren().get(i).setTranslateY((vb.getChildren().get(i).getTranslateY()) + deltaY);
            	}
        }
        
        
        
    });
    
    //Change les images des Achievements au passage de la souris
    sansFA.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {Succes.getChildren().add(sansFAT);}});

    sansFAT.setOnMouseExited(new EventHandler<MouseEvent>() {
    	@Override
        public void handle(MouseEvent t) {Succes.getChildren().remove(sansFAT);}});
    
    creeperFA.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {Succes.getChildren().add(creeperFAT);}});

    creeperFAT.setOnMouseExited(new EventHandler<MouseEvent>() {
    	@Override
        public void handle(MouseEvent t) {Succes.getChildren().remove(creeperFAT);}});
    
    killFA.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {Succes.getChildren().add(killFAT);}});

    killFAT.setOnMouseExited(new EventHandler<MouseEvent>() {
    	@Override
        public void handle(MouseEvent t) {Succes.getChildren().remove(killFAT);}});
    
    cakeFA.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {Succes.getChildren().add(cakeFAT);}});

    cakeFAT.setOnMouseExited(new EventHandler<MouseEvent>() {
    	@Override
        public void handle(MouseEvent t) {Succes.getChildren().remove(cakeFAT);}});
    
    burgerFA.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {Succes.getChildren().add(burgerFAT);}});

    burgerFAT.setOnMouseExited(new EventHandler<MouseEvent>() {
    	@Override
        public void handle(MouseEvent t) {Succes.getChildren().remove(burgerFAT);}});
    
    meatBoyFA.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {Succes.getChildren().add(meatBoyFAT);}});

    meatBoyFAT.setOnMouseExited(new EventHandler<MouseEvent>() {
    	@Override
        public void handle(MouseEvent t) {Succes.getChildren().remove(meatBoyFAT);}});
    
    MLGFA.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {Succes.getChildren().add(MLGFAT);}});

    MLGFAT.setOnMouseExited(new EventHandler<MouseEvent>() {
    	@Override
        public void handle(MouseEvent t) {Succes.getChildren().remove(MLGFAT);}});
    
    lightSaberFA.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {Succes.getChildren().add(lightSaberFAT);}});

    lightSaberFAT.setOnMouseExited(new EventHandler<MouseEvent>() {
    	@Override
        public void handle(MouseEvent t) {Succes.getChildren().remove(lightSaberFAT);}});
    
    pingFA.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {Succes.getChildren().add(pongFAT);}});

    pongFAT.setOnMouseExited(new EventHandler<MouseEvent>() {
    	@Override
        public void handle(MouseEvent t) {Succes.getChildren().remove(pongFAT);}});
    
    // Permet de choisir si on veut ou non afficher le nom des Nodes 
    checkMenuItem.setOnAction(e -> {
    	if(checkMenuItem.isSelected()) {
    		aideTxt = true;}
    	else {aideTxt = false;}
    });
    
    // Affiche le nom des Objets au passage 
    all.setOnMouseMoved(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {
        	Node target = (Node) t.getTarget();
        	
        	 if (target != all && aideTxt == true) {
        		 clef = Integer.parseInt(target.getId());
        		 final Text text = new Text (listNom.get(clef));
        		 text.setTranslateY(-1.1);
        		 int longueur = text.getText().length();
        		 
        		 final Rectangle Rect = new Rectangle(longueur*5+15,13);
        		 Rect.setFill(Color.BISQUE);
        		 
        		 texte.getChildren().clear();
        		 texte.setTranslateX(target.getTranslateX());
        		 if(target.getTranslateX()== -330){texte.setTranslateX(target.getTranslateX()+longueur*2-5);};
        		 if(target.getTranslateY()==130) {texte.setTranslateY(target.getTranslateY()+27);}
        		 else {texte.setTranslateY(target.getTranslateY()-27);}
        		 texte.getChildren().addAll(Rect, text);
        		 
        	 }
        	 else {
        		 texte.getChildren().clear();
        	 }
        }});
    
    
    // Selection de la Node dans Layout1
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
    
    // Mouvement
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
        	// Si on est dans la matrice
        	if(815<evt.getX() && evt.getX()<964 && 860<evt.getY() && evt.getY()<1009) {
        	for(int i=0; i<matrice.length*matrice.length;i++) {
        			if(815+50*(i%3)<=evt.getX() && evt.getX()<865+50*(i%3) && 860+50*(i/3)<=evt.getY() && evt.getY()<910+50*(i/3)) {
        				selected.setTranslateX(-175+50*(i%3));
                        selected.setTranslateY(-130+50*(i/3));
                        if (selected.getId() != null && matrice[i/3][i%3] ==0) {
                        	matrice[i/3][i%3] = Integer.valueOf(selected.getId()); //La matrice récupère l'ID de la Node.
                        if(caMarche ==true) { // delete le resultat si on rajoute un node dans la matrice
                        layout1.getChildren().clear();
                    	layout1.getChildren().addAll(decor1,craft,Dossier,inventaire,texte,all,toolBar,buttonDel,buttonAdd,Matrice,mb);//Remet fond craft
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
        	// Si on est dans l'inventaire
        	else if((evt.getY() - offset.getY() + translateStart.getY())>=100) {
        		double X;
        		selected.setTranslateY(Math.round((evt.getY() - offset.getY() + translateStart.getY()+25)/50)*50-20);
        		if((evt.getX() - offset.getX() + translateStart.getX())>=0) { //X positif
            	X = (Math.round((evt.getX() - offset.getX() + translateStart.getX()+25)/50)*50-25+Math.round((evt.getX() - offset.getX() + translateStart.getX())/50)/2);}
            	else { // X négatif
            	X = (Math.round((evt.getX() - offset.getX() + translateStart.getX()-25)/50)*50+25+Math.round((evt.getX() - offset.getX() + translateStart.getX())/50)/2);}
        		selected.setTranslateX(X);
        		
        	}
        	// Sinon retour au point de départ.
        	else {
        		selected.setTranslateX(STARTX);
        		selected.setTranslateY(STARTY);
        	}
        	// Redimensionnement de l'image
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
        // Parcourir et comparer avec la matrice
        
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
      	
        	for(int k=0;k<liste.size();k++) {
        		if (valeur.get(k)==liste.get(k)) {
        			compteur+=1;
        		}
        }
        	if(compteur==craft_1.liste.size() && compteur==liste.size()) {
        		caMarche = true;
        		creationImage newImage = new creationImage(listImage.get(dicoCraft.get(clef).resultat), String.valueOf(dicoCraft.get(clef).resultat));
        		layout1.getChildren().clear();
        		layout1.getChildren().addAll(decor1,craftOk,Dossier,inventaire,texte,all,toolBar,buttonDel,buttonAdd,Matrice,mb);//remplace fond craft
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
