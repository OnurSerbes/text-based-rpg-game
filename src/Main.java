import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Create lists for choices

        ArrayList<ChoiceItem> firstChoiceItems = new ArrayList<>();
        ArrayList<ChoiceItem> secondChoiceItems = new ArrayList<>();
        ArrayList<ChoiceItem> thirdChoiceItems = new ArrayList<>();
        ArrayList<ChoiceItem> fourthChoiceItems = new ArrayList<>();
        ArrayList<ChoiceItem> fifthChoiceItems = new ArrayList<>();

        //Initialize all the storySteps with adding the list of choices

        StoryItem firstStep = new StoryItem(1,"Level 1 \n Agile Oversized Cave Rat",firstChoiceItems);
        firstStep.addChoice("A","Crossbow",0);
        firstStep.addChoice("B","Spear",200);
        firstStep.addChoice("C","Sword",300);
        firstStep.addChoice("D","Dagger",500);

        StoryItem secondStep = new StoryItem(2,"Level 2 \n Skeleton Army of 3", secondChoiceItems);
        secondStep.addChoice("A","Staff",0);
        secondStep.addChoice("B","Leather Whip",200);
        secondStep.addChoice("C","Chains",300);
        secondStep.addChoice("D","Axe",500);

        StoryItem thirdStep = new StoryItem(3,"Level 3 \n Medium Rock Golem", thirdChoiceItems);
        thirdStep.addChoice("A","Sword",0);
        thirdStep.addChoice("B","Axe",200);
        thirdStep.addChoice("C","Iron Mace",300);
        thirdStep.addChoice("D","Iron Hammer",500);

        StoryItem fourthStep = new StoryItem(4,"Level 4 \n Big Hog Monster", fourthChoiceItems);
        fourthStep.addChoice("A","Chains",0);
        fourthStep.addChoice("B","Crossbow",200);
        fourthStep.addChoice("C","Dagger",300);
        fourthStep.addChoice("D","Axe",500);

        StoryItem fifthStep = new StoryItem(5,"Level 5 ** THE BOSS **\n Armored Large Minotaur ", fifthChoiceItems);
        fifthStep.addChoice("A","Dagger",0);
        fifthStep.addChoice("B","Spear",200);
        fifthStep.addChoice("C","Big Axe",300);
        fifthStep.addChoice("D","Sword",500);


        //create LinkedList for storyline

        LinkedList<StoryItem> storyList = new LinkedList<>();
        storyList.add(firstStep);
        storyList.add(secondStep);
        storyList.add(thirdStep);
        storyList.add(fourthStep);
        storyList.add(fifthStep);

        //this function will make us to be able to move back and forward between the nodes of linkedlist

        int totalScore = 0;

        //this function will create the story text
        createDialogs();

        System.out.println("\nPlayer One's Turn\n");
        int scoreOne = visit(storyList,totalScore); //for player 1


        System.out.println("\nPlayer Two's Turn\n");
        int scoreTwo = visit(storyList,totalScore); //for player 2


        System.out.println("\nPlayer Three's Turn\n");
        int scoreThree = visit(storyList,totalScore); //for player 3



        //We will create players to assign scores

        Player playerOne = new Player(1,"Player One",scoreOne);
        Player playerTwo = new Player(2,"Player Two",scoreTwo);
        Player playerThree = new Player(3,"Player Three",scoreThree);

        //BinarySearchTree will be used to sort the players by their scores

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(playerOne);
        bst.insert(playerTwo);
        bst.insert(playerThree);

        System.out.println("\n*************** SCOREBOARD *************** \n ");
        bst.inorder();
        System.out.println("\n****************************************** ");

    }

    private static void createDialogs() {
        System.out.println("——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————" +
                "\n" +
                "You are a brave adventurer roaming land to land offering your help to those who seek help. This time, you stumble upon a village nearby a cave ridden with monsters that terrorize the villagers. \n" +
                "\n" +
                "You are welcomed with great hostility as your presence fill the villagers with peace. \n" +
                "\n" +
                "Village Elder: Brave warrior! You are the help we have been asking from the gods. Our village is being attacked every night by the gang of monsters that lurk in the cave. \nWill you be our hero and slay those beasts and save our village? \n" +
                "\n" +
                "You look at the many weapons you have in your disposal as you humbly accept the Elder’s request and head straight to the cave.\n" +
                        "\n" +
                "——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————\n" +
                        "\n" +
                "Gameplay: Pick a weapon for slaying the monster in each level but be careful,the weapon you choose may have one of the 4 effects; best effective to kill the monster, \nlethally wound the monster with high chance of resulting in its death, lightly wound the monster with low chance of resulting in its death or have no effect on the monster at all. \n" +
                "\n" +
                "Think of the monsters’ size, condition and ability when picking your weapon and pick wisely.\n" +
                "——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————" +
                "\n");
    }

    private static void endingIntervals(int score){
        if(score >= 0 && score <= 500 ){
            System.out.println("Poor Performance :" +
                    "You did your best but you couldn’t save the village entirely. You may or may not have slain only a single monster. " +
                    "\nThe village still thanks you regardless for trying. ");
        }else if(score >= 500 && score <= 1200){
            System.out.println("Average Performance:" +
                    "\nNice Effort! You slayed some of the monsters making the village a tad bit safer. The village thanks you regardless.");
        }else if(score >= 1200 && score <= 2000 ){
            System.out.println("Good Performance:" +
                    "\nGreat Effort! You slayed most of the monsters, alleviating the danger imposed on the village greatly. The village thanks you.");
        }else if(score >= 2000 && score <= 2500){
            System.out.println("Awesome Performance :" +
                    "\nAwesome Effort! You managed to slay all, if not almost all of the monsters. " +
                    "\nThe village is forever grateful to you for your bravery. You receive the honorable title “Hero of The Village”.");
        }
    }

    private static int visit(LinkedList storyLine, int score){

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;

        ListIterator<StoryItem> listIterator = storyLine.listIterator();

        if(storyLine.isEmpty()){
            System.out.println("You are at the end of the story");

        }else{
            System.out.println(listIterator.next());
            printMenu();
        }


        //iterative switch-case block

        while (!quit) {
            String action = scanner.nextLine();
            switch (action) {
                case "A" -> {
                    score += 0;
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println(listIterator.next());
                    } else {
                        System.out.println(
                                "Reached the end of the story\n");
                        endingIntervals(score);
                        quit = true;
                        goingForward = false;
                        return score;

                    }
                }
                case "B" -> {
                    score += 200;
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println(listIterator.next());
                    } else {
                        System.out.println(
                                "Reached the end of the story\n");
                        endingIntervals(score);
                        quit = true;
                        goingForward = false;
                        return score;
                    }
                }
                case "C" -> {
                    score += 300;
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println(listIterator.next());
                    } else {
                        System.out.println(
                                "Reached the end of the story\n");
                        endingIntervals(score);
                        quit = true;
                        goingForward = false;
                        return score;
                    }
                }
                case "D" -> {
                    score += 500;
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println(listIterator.next());
                    } else {
                        System.out.println(
                                "Reached the end of the story\n");
                        endingIntervals(score);
                        quit = true;
                        goingForward = false;
                        return score;

                    }
                }
                case "0" -> {
                    System.out.println("You are quiting the game");
                    quit = true;
                }
                case "1" -> {
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;

                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println(listIterator.previous());
                    } else {
                        System.out.println("You are at the beginning of this journey. Are you ready to start ? ");
                        goingForward = true;
                    }
                }
                case "2" -> printMenu();
            }
        }
        return score;
    }

    private static void printMenu() {
        System.out.println("");
        System.out.println(
                "*********************************\n" +
                "* A, B, C or D - to select path\n"+
                "* 0 - to quit\n" +
                "* 1 - go to previous level\n" +
                "* 2 - show the menu\n" +
                "*********************************\n");
    }

}
