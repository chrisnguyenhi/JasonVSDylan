import java.awt.Color;

public class Main {

	public static void main(String[] args) throws java.io.IOException {

		// Setup EZ graphics system.
		EZ.initialize(800, 600);
		EZImage background;
		background = EZ.addImage("./img/pkbt.png", 400, 300);
		EZSound defaultbgmusic;
		defaultbgmusic = EZ.addSound("./sound/bgmusic.wav");
		defaultbgmusic.play();

		// TODO Auto-generated method stub
		cnguyen7_Animator Background = new cnguyen7_Animator("./txt/Background.txt", "./img/background.jpg", 1000,
				1000);
		// Grudge background to scare audience during presentations in large
		// classrooms
		cnguyen7_Animator Dylan = new cnguyen7_Animator("./txt/Dylan.txt", "./img/dylansprite.png", 250, 450);
		cnguyen7_Animator Jason = new cnguyen7_Animator("./txt/Jason.txt", "./img/jasonsprite.png", 0, 0);
		cnguyen7_Animator BlastOff = new cnguyen7_Animator("./txt/Blastoff.txt", "./img/text14.png", 400, 520);
		cnguyen7_Animator SuperEffective = new cnguyen7_Animator("./txt/SuperEffective.txt", "./img/text13.png", 400,
				520);
		cnguyen7_Animator ProjAttack = new cnguyen7_Animator("./txt/ProjAttack.txt", "./img/project 4.png", 600, 200);
		cnguyen7_Animator JasonProj4 = new cnguyen7_Animator("./txt/JasonProj4.txt", "./img/text12.png", 400, 520);
		cnguyen7_Animator JasonPhD = new cnguyen7_Animator("./txt/JasonPhD.txt", "./img/text11.png", 400, 520);
		cnguyen7_Animator DylanGrade = new cnguyen7_Animator("./txt/DylanGrade.txt", "./img/text10.png", 400, 520);
		cnguyen7_Animator ChickenAttack = new cnguyen7_Animator("./txt/ChickenAttack.txt", "./img/EZChicken.png", 600,
				190);
		cnguyen7_Animator JasonChicken = new cnguyen7_Animator("./txt/JasonChicken.txt", "./img/text9.png", 400, 520);
		cnguyen7_Animator CritHappened = new cnguyen7_Animator("./txt/CritHappened.txt", "./img/text8.png", 400, 520);
		cnguyen7_Animator KamehamehaAttack = new cnguyen7_Animator("./txt/KamehamehaAttack.txt", "./img/kamehameha.png",
				230, 375);
		cnguyen7_Animator DylanKamehameha = new cnguyen7_Animator("./txt/Kamehameha.txt", "./img/text7.png", 400, 520);
		cnguyen7_Animator SwagUp = new cnguyen7_Animator("./txt/Swag.txt", "./img/swag.png", 500, 220);
		cnguyen7_Animator JasonSwag = new cnguyen7_Animator("./txt/SwagUp.txt", "./img/text6.png", 400, 520);
		cnguyen7_Animator JasonVisualization = new cnguyen7_Animator("./txt/Visualization.txt", "./img/text5.png", 400,
				520);
		cnguyen7_Animator RuntimeError = new cnguyen7_Animator("./txt/RuntimeError.txt", "./img/runtimeerror.png", 400,
				220);
		cnguyen7_Animator DylanError = new cnguyen7_Animator("./txt/DylanError.txt", "./img/text4.png", 400, 520);
		cnguyen7_Animator DylanCompile = new cnguyen7_Animator("./txt/DylanCompile.txt", "./img/text3.png", 400, 520);
		cnguyen7_Animator DylanWutDo = new cnguyen7_Animator("./txt/DylanWutDo.txt", "./img/text2.png", 400, 520);
		cnguyen7_Animator WildAppeared = new cnguyen7_Animator("./txt/WildAppears.txt", "./img/text1.png", 400, 520);
		while (true) {
			Dylan.go();
			Jason.go();
			WildAppeared.go();
			DylanWutDo.go();
			DylanCompile.go();
			DylanError.go();
			RuntimeError.go();
			JasonVisualization.go();
			SwagUp.go();
			JasonSwag.go();
			DylanKamehameha.go();
			KamehamehaAttack.go();
			CritHappened.go();
			JasonChicken.go();
			ChickenAttack.go();
			DylanGrade.go();
			JasonPhD.go();
			JasonProj4.go();
			ProjAttack.go();
			SuperEffective.go();
			BlastOff.go();
			Background.go();
			EZ.refreshScreen();
		}

	}

}
