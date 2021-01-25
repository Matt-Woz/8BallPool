import java.util.ArrayList;
/**
 * This class holds the table and the logic of the game
 * @author Mateusz Wozakowski
 * @version 1.0
 */


public class Board
{
    /**Used for detecting if a potted ball results in a turn change or not*/
    private Ball pottedBall;
    /**A list of red balls*/
    private ArrayList<Ball> redBalls = new ArrayList<>();
    /**A list of blue balls*/
    private ArrayList<Ball> blueBalls = new ArrayList<>();
    /** A list of all balls, used for ball mechanics*/
    private ArrayList<Ball> allBalls = new ArrayList<>();
    /** A list of moving balls, used for switching turns*/
    private ArrayList<Ball> movingBalls = new ArrayList<>();
    /** A list used for storing the table pockets, used for potting balls*/
    private ArrayList<Ball> pockets = new ArrayList<>();
    /** Checks if the white ball has been potted*/
    private boolean whiteBallPotted = false;
    /** A counter of blue balls still on the table*/
    private int blueBallCount = 7;
    /** A counter of red balls still on the table*/
    private int redBallCount = 7;
    /**Creates the game arena*/
    private GameArena game = new GameArena(1000, 700);
    /**Creates the cue ball*/
    private Ball whiteBall = new Ball(300, 340, 20, "WHITE", 1);
    /**Creates the 8 ball*/
    private Ball blackBall = new Ball(636, 340, 20, "BLACK", 1);
    /**Creates a line which shows the direction of the cue ball*/
    private Line ballTracer = new Line(whiteBall.getXPosition(), whiteBall.getYPosition(), 400, 400, 2, "WHITE", 2);
    /**Determines whether the right ball has been potted, used for changing turns*/
    private boolean rightBallPotted = false;
    /**Ball indicating the current turn*/
    Ball turnBall = new Ball(490, 650, 50, "RED", 2);
    /**Text indicating when a foul has occured*/
    Text Foul = new Text("Foul! Place ball with right click.", 20, 350, 610, "WHITE", 3);
    /**Check if a foul has occured*/
    boolean isFoul = false;
    /**Checks if a ball has been hit, used for foul detection*/
    boolean ballHit = false;
    /**Checks if the right ball has been hit, used for foul detection*/
    boolean rightBallHit = true;
    /**Used for adding foul text*/
    boolean textAdded = false;
    /**Used for detecting what colour ball has been hit first*/
    String firstBallHit = "NULL";

    /**
     * This creates the table
     */

    public Board(){
        Rectangle innerTable = new Rectangle(90, 90, 800, 500, "GREEN", 0);
        Rectangle topStrip = new Rectangle(90, 90, 800, 30, "#663300", 1);
        Rectangle bottomStrip = new Rectangle(90, 560, 800, 30, "#663300", 1);
        Rectangle leftStrip = new Rectangle(90, 90, 30, 500, "#663300", 1);
        Rectangle rightStrip = new Rectangle(860, 90, 30, 500, "#663300", 1);
        Ball topLeft = new Ball(130, 130, 50, "BLACK", 0);
        Ball topMiddle = new Ball(490, 120, 50, "BLACK", 0);
        Ball topRight = new Ball(850, 130, 50, "BLACK", 0);
        Ball bottomLeft = new Ball(130, 550, 50, "BLACK", 0);
        Ball bottomMiddle = new Ball(490, 560, 50, "BLACK", 0);
        Ball bottomRight = new Ball(850, 550, 50, "BLACK", 0);
        Line tableLine = new Line(300, 121, 300, 559, 1, "WHITE", 1);
        game.addRectangle(innerTable);
        game.addRectangle(topStrip);
        game.addRectangle(bottomStrip);
        game.addRectangle(leftStrip);
        game.addRectangle(rightStrip);
        game.addBall(topLeft);
        game.addBall(topMiddle);
        game.addBall(topRight);
        game.addBall(bottomLeft);
        game.addBall(bottomMiddle);
        game.addBall(bottomRight);
        game.addLine(tableLine);
        pockets.add(topLeft);
        pockets.add(topMiddle);
        pockets.add(topRight);
        pockets.add(bottomLeft);
        pockets.add(bottomMiddle);
        pockets.add(bottomRight);
        Balls();
        }
    /**
     * This creates a and places all balls necessary for the game, and places them inside their respective arrays
     */
    private void Balls() {
        Ball redBall0 = new Ball(600, 340, 20, "RED", 1);
        Ball blueBall0 = new Ball(618, 351, 20, "BLUE", 1);
        Ball redBall1 = new Ball(618, 329, 20, "RED", 1);
        Ball redBall2 = new Ball(636, 361, 20, "RED", 1);
        Ball blueBall1 = new Ball(636, 319, 20, "BLUE", 1);
        Ball redBall3 = new Ball(654, 350, 20, "RED", 1);
        Ball blueBall2 = new Ball(654, 329, 20, "BLUE", 1);
        Ball redBall4 = new Ball(654, 308, 20, "RED", 1);
        Ball blueBall3 = new Ball(654, 373, 20, "BLUE", 1);
        Ball blueBall4 = new Ball(672, 340, 20, "BLUE", 1);
        Ball redBall5 = new Ball(672, 319, 20, "RED", 1);
        Ball blueBall5 = new Ball(672, 298, 20, "BLUE", 1);
        Ball blueBall6 = new Ball(672, 361, 20, "BLUE", 1);
        Ball redBall6 = new Ball(672, 382, 20, "RED", 1);
        Ball phantom = new Ball(900, 600, 1, "BLACK", 1);
        Text Player1 = new Text("Player 1", 50, 50, 40, "BLUE", 3);
        Text Player2 = new Text("Player 2", 50, 750,40, "RED", 3);
        game.addText(Player1);
        game.addText(Player2);
        game.addBall(turnBall);
        game.addBall(whiteBall);
        game.addBall(blackBall);
        redBalls.add(0, redBall0);
        redBalls.add(1, redBall1);
        redBalls.add(2, redBall2);
        redBalls.add(3, redBall3);
        redBalls.add(4, redBall4);
        redBalls.add(5, redBall5);
        redBalls.add(6, redBall6);
        blueBalls.add(0, blueBall0);
        blueBalls.add(1, blueBall1);
        blueBalls.add(2, blueBall2);
        blueBalls.add(3, blueBall3);
        blueBalls.add(4, blueBall4);
        blueBalls.add(5, blueBall5);
        blueBalls.add(6, blueBall6);
        allBalls.add(0, whiteBall);
        allBalls.add(1, redBall0);
        allBalls.add(2, redBall1);
        allBalls.add(3, redBall2);
        allBalls.add(4, redBall3);
        allBalls.add(5, redBall4);
        allBalls.add(6, redBall5);
        allBalls.add(7, redBall6);
        allBalls.add(8, blueBall0);
        allBalls.add(9, blueBall1);
        allBalls.add(10, blueBall2);
        allBalls.add(11, blueBall3);
        allBalls.add(12, blueBall4);
        allBalls.add(13, blueBall5);
        allBalls.add(14, blueBall6);
        allBalls.add(15, blackBall);
        allBalls.add(16, phantom);
        for (int i = 0; i < 7; i++) {
            game.addBall(redBalls.get(i));
            game.addBall(blueBalls.get(i));
        }
        positionWhiteBall();
        gameLogic();
        }

    /**
     * This contains most of the logic used for all the mechanics and rules of the game
     */
    private void gameLogic() {
        int ballCount = 16;
        ballTracer.setArrowSize(5);
        game.addLine(ballTracer);
        Text moveBall = new Text ("Right click on the table to re-position the cue ball", 20, 265, 610, "WHITE", 3);
        game.addText(moveBall);
        boolean gameStarted = false;
        boolean ballPotted = false;
        boolean whiteBallShot = false;
        boolean turnCompleted = false;
        boolean turnSwitched = false;
        boolean gameFinished = false;
        boolean firstBallStored = false;
        while (!gameFinished) { //While loop continues until game is finished
            ballTracer.setLinePosition(whiteBall.getXPosition(), whiteBall.getYPosition(), game.getMousePositionX(), game.getMousePositionY()); //Sets position of the ball tracer continuously
            if (!gameStarted)
            {
                positionWhiteBall();
            }

            for (int i = 0; i < ballCount; i++) { //For all balls
                allBalls.get(i).setXPosition(allBalls.get(i).getXPosition() + allBalls.get(i).getxMovement()); //Continuous movement of balls depending on speed from .getxMovement
                allBalls.get(i).setYPosition(allBalls.get(i).getYPosition() + allBalls.get(i).getyMovement());
                allBalls.get(i).setxMovement(allBalls.get(i).getxMovement() * 0.99); //Friction calculation
                allBalls.get(i).setyMovement(allBalls.get(i).getyMovement() * 0.99);
                if (allBalls.get(i).getXPosition() <= 120 || allBalls.get(i).getXPosition() >= 860) { //If a ball hits the left/right cushions
                    allBalls.get(i).setxMovement(allBalls.get(i).getxMovement() * -1); //Make ball move in opposite direction
                }
                if (allBalls.get(i).getYPosition() >= 560 || allBalls.get(i).getYPosition() <= 120) { //If ball hits upper/lower cushions
                    allBalls.get(i).setyMovement(allBalls.get(i).getyMovement() * -1); //Make ball move in opposite direction
                }
                if (allBalls.get(i).getxMovement() >= -0.5 && allBalls.get(i).getxMovement() <= 0.5 && allBalls.get(i).getyMovement() >= -0.5 && allBalls.get(i).getyMovement() <= 0.5 && (allBalls.get(i).getxMovement() != 0 || allBalls.get(i).getyMovement() != 0)) {
                    allBalls.get(i).setxMovement(0); //Sets speed to 0 once it's below a certain amount
                    allBalls.get(i).setyMovement(0);
                    if (allBalls.get(i) == whiteBall && !whiteBallPotted)
                    {
                        game.addLine(ballTracer); //adds a tracer back once the cue ball has stopped
                    }
                }
                if (allBalls.get(i).getxMovement() == 0 && allBalls.get(i).getyMovement() == 0) {
                    movingBalls.remove(allBalls.get(i)); //Removes balls from movingBalls if their speed is 0
                    }
                for (int k = 0; k < 6; k++) //For all pockets
                {
                    if (allBalls.get(i).collides(pockets.get(k)) && allBalls.get(i) != whiteBall && allBalls.get(i) != blackBall) //If coloured ball is pocketed
                    {
                        pottedBall = allBalls.get(i);
                        movingBalls.remove(allBalls.get(i));
                        game.removeBall(allBalls.get(i));
                        ballPotted = true;
                        ballCount--;
                        ballPotted();
                        allBalls.get(i).setxMovement(0);
                        allBalls.get(i).setyMovement(0);
                        allBalls.remove(i);
                    }
                    else if(allBalls.get(i).collides(pockets.get(k)) && allBalls.get(i) == whiteBall) //If cue ball is potted
                    {
                        allBalls.get(i).setxMovement(0);
                        allBalls.get(i).setyMovement(0);
                        game.removeBall(allBalls.get(i));
                        whiteBallPotted = true;
                    }
                    else if(allBalls.get(i).collides(pockets.get(k)) && allBalls.get(i) == blackBall) //If  black ball is potted
                    {
                        gameFinished = true;
                        blackBallPotted();
                    }
                }
                }
            if (!turnSwitched && turnCompleted && (!rightBallPotted || !ballPotted)) //Conditions for switching the turn
            {
                switchTurn();
                turnSwitched = true;
            }
            for (int x = 0; x < ballCount; x++) {
                for (int y = 0; y < ballCount; y++) { //Double for loop for collisions between all balls
                    if (allBalls.get(y).collides(allBalls.get(x)) && allBalls.get(x) != allBalls.get(y) && (allBalls.get(x).getxMovement() != 0 || allBalls.get(x).getyMovement() != 0 || allBalls.get(y).getxMovement() != 0 || allBalls.get(y).getyMovement() != 0)) {
                        if (!firstBallStored && (allBalls.get(y) == whiteBall || allBalls.get(x) == whiteBall)) //For storing the first ball hit, allows a foul
                        {
                            if(allBalls.get(y) == whiteBall)
                            {
                                firstBallHit = allBalls.get(x).getColour();
                            }
                            else if (allBalls.get(x) == whiteBall)
                            {
                                firstBallHit = allBalls.get(y).getColour();
                            }
                        }
                        ballHit = true;
                        firstBallStored = true;
                        deflect(allBalls.get(x), allBalls.get(y)); //Calls the deflect method taking in 2 balls
                    }
                }
            }
            if (game.leftMousePressed() && movingBalls.size() == 0 && !whiteBallPotted && !whiteBallShot) { //Used for moving the ball once left click is pressed and balls are stationary
                ballHit = false;
                gameStarted = true;
                game.removeText(moveBall);
                game.removeLine(ballTracer);
                movingBalls.add(whiteBall);
                isFoul = false;
                textAdded = false;
                firstBallStored = false;
                turnCompleted = false;
                whiteBallShot = true;
                ballPotted = false;
                whiteBallMovement();
            }
            if (ballHit && !rightBallHit && whiteBallShot) //Used for detecting 'Wrong ball hit' foul
            {
                isFoul = true;
            }
            if (!ballHit && whiteBallShot && whiteBall.getxMovement() == 0 && whiteBall.getyMovement() == 0) //Used for detecting 'Ball not hit' foul
            {
                isFoul = true;
            }
            if (whiteBallPotted) //Used for detecting 'Potting cue ball' foul
            {
                isFoul = true;
            }
            if (isFoul && !whiteBallShot) //Used for calling the foul method
            {
                Foul();
            }
            if(!firstBallHit.equals("NULL") && !turnBall.getColour().equals(firstBallHit)) //Used for determining if the right ball was hit
            {
                if(turnBall.getColour().equals("RED") && redBallCount > 0)
                {
                    rightBallHit = false;
                }
                else if(turnBall.getColour().equals("BLUE") && blueBallCount > 0)
                {
                    rightBallHit = false;
                }
            }
            if (movingBalls.size() == 0 && whiteBallShot) { //Finished the turn
                firstBallHit = "NULL";
                turnCompleted = true;
                whiteBallShot = false;
                turnSwitched = false;
            }

            game.pause();

        }
    }
    /**
     * This is used to switch the turn once the conditions are met
     */
    private void switchTurn()
    {
        if (turnBall.getColour().equals("BLUE"))
        {
            turnBall.setColour("RED");
            rightBallPotted = true;
        }
        else if (turnBall.getColour().equals("RED"))
        {
            turnBall.setColour("BLUE");
            rightBallPotted = true;
        }
    }

    /**
     * This determines what to do if the black ball has been potted, resulting in the end of the game
     */
    private void blackBallPotted()
    {
        if (redBallCount == 0 && blueBallCount == 0) //In case both players have no balls left
        {
            if(turnBall.getColour().equals("RED"))
            {
                redVictory();
            }
            else if(turnBall.getColour().equals("BLUE"))
            {
                blueVictory();
            }
        }
        if (redBallCount == 0)
        {
            redVictory();
        }
        else {
            blueVictory();
        }
    }
    /**
     * Deflection algorithm
     */
    public void deflect(Ball ball1, Ball ball2)
    {
        // The position and speed of each of the two balls in the x and y axis before collision.
        // YOU NEED TO FILL THESE VALUES IN AS APPROPRIATE...
        double xPosition1 = ball1.getXPosition();
        double xPosition2 = ball2.getXPosition();
        double yPosition1 = ball1.getYPosition();
        double yPosition2 = ball2.getYPosition();
        double xSpeed1 = ball1.getxMovement();
        double xSpeed2 = ball2.getxMovement();
        double ySpeed1 = ball1.getyMovement();
        double ySpeed2 = ball2.getyMovement();
        // Calculate initial momentum of the balls... We assume unit mass here.
        double p1InitialMomentum = Math.sqrt(xSpeed1 * xSpeed1 + ySpeed1 * ySpeed1);
        double p2InitialMomentum = Math.sqrt(xSpeed2 * xSpeed2 + ySpeed2 * ySpeed2);
        // calculate motion vectors
        double[] p1Trajectory = {xSpeed1, ySpeed1};
        double[] p2Trajectory = {xSpeed2, ySpeed2};
        // Calculate Impact Vector
        double[] impactVector = {xPosition2 - xPosition1, yPosition2 - yPosition1};
        double[] impactVectorNorm = normalizeVector(impactVector);
        // Calculate scalar product of each trajectory and impact vector
        double p1dotImpact = Math.abs(p1Trajectory[0] * impactVectorNorm[0] + p1Trajectory[1] * impactVectorNorm[1]);
        double p2dotImpact = Math.abs(p2Trajectory[0] * impactVectorNorm[0] + p2Trajectory[1] * impactVectorNorm[1]);
        // Calculate the deflection vectors - the amount of energy transferred from one ball to the other in each axis
        double[] p1Deflect = { -impactVectorNorm[0] * p2dotImpact, -impactVectorNorm[1] * p2dotImpact };
        double[] p2Deflect = { impactVectorNorm[0] * p1dotImpact, impactVectorNorm[1] * p1dotImpact };
        // Calculate the final trajectories
        double[] p1FinalTrajectory = {p1Trajectory[0] + p1Deflect[0] - p2Deflect[0], p1Trajectory[1] + p1Deflect[1] - p2Deflect[1]};
        double[] p2FinalTrajectory = {p2Trajectory[0] + p2Deflect[0] - p1Deflect[0], p2Trajectory[1] + p2Deflect[1] - p1Deflect[1]};
        // Calculate the final energy in the system.
        double p1FinalMomentum = Math.sqrt(p1FinalTrajectory[0] * p1FinalTrajectory[0] + p1FinalTrajectory[1] * p1FinalTrajectory[1]);
        double p2FinalMomentum = Math.sqrt(p2FinalTrajectory[0] * p2FinalTrajectory[0] + p2FinalTrajectory[1] * p2FinalTrajectory[1]);

        // Scale the resultant trajectories if we've accidentally broken the laws of physics.
        double mag = (p1InitialMomentum + p2InitialMomentum) / (p1FinalMomentum + p2FinalMomentum);
        // Calculate the final x and y speed settings for the two balls after collision.
        xSpeed1 = p1FinalTrajectory[0] * mag;
        ySpeed1 = p1FinalTrajectory[1] * mag;
        xSpeed2 = p2FinalTrajectory[0] * mag;
        ySpeed2 = p2FinalTrajectory[1] * mag;
        ball1.setxMovement(xSpeed1);
        ball1.setyMovement(ySpeed1);
        ball2.setxMovement(xSpeed2);
        ball2.setyMovement(ySpeed2);
    }
    /**
     * Converts a vector into a unit vector.
     * Used by the deflect() method to calculate the resultnt direction after a collision.
     */
    private double[] normalizeVector(double[] vec) {
        double mag = 0.0;
        int dimensions = vec.length;
        double[] result = new double[dimensions];
        for (int i = 0; i < dimensions; i++)
            mag += vec[i] * vec[i];
        mag = Math.sqrt(mag);
        if (mag == 0.0) {
            result[0] = 1.0;
            for (int i = 1; i < dimensions; i++)
                result[i] = 0.0;
        } else {
            for (int i = 0; i < dimensions; i++)
                result[i] = vec[i] / mag;
        }
        return result;
    }
    /**
     * This determines what happens once a foul has occured
     */
    private void Foul()
    {
        if (!textAdded)
        {
            game.addText(Foul);
            textAdded = true;
        }
        if (game.rightMousePressed() && whiteBallPotted) //White ball potted foul
        {
            game.addBall(whiteBall);
            whiteBall.setxMovement(0);
            whiteBall.setyMovement(0);
            if (game.getMousePositionX() >= 125 && game.getMousePositionX() <= 850 && game.getMousePositionY() >= 125 && game.getMousePositionY() <= 550) //If inside range
            {
                whiteBall.setXPosition(game.getMousePositionX());
                whiteBall.setYPosition(game.getMousePositionY());
                game.addLine(ballTracer);
                game.removeText(Foul);
                whiteBallPotted = false;
                isFoul = false;
            }

        }
        else if (game.rightMousePressed() && !rightBallHit && firstBallHit.equals("NULL")) //Wrong first ball hit
    {
        if (game.getMousePositionX() >= 125 && game.getMousePositionX() <= 850 && game.getMousePositionY() >= 125 && game.getMousePositionY() <= 550)
        {
            whiteBall.setXPosition(game.getMousePositionX());
            whiteBall.setYPosition(game.getMousePositionY());
            game.removeText(Foul);
            rightBallHit = true;
            isFoul = false;
        }

    }
        else if (game.rightMousePressed() && !ballHit) //If no ball hit
        {
            if (game.getMousePositionX() >= 125 && game.getMousePositionX() <= 850 && game.getMousePositionY() >= 125 && game.getMousePositionY() <= 550)
            {
                whiteBall.setXPosition(game.getMousePositionX());
                whiteBall.setYPosition(game.getMousePositionY());
                game.removeText(Foul);
                isFoul = false;
            }
        }
    }
    /**
     * This allows the white ball to be placed to the left of the white line at the start of the game
     */
    private void positionWhiteBall()
    {
        if (game.rightMousePressed() && game.getMousePositionX() <= 300 && game.getMousePositionX() >= 125) //if left of line and inside range
        {
            if (game.getMousePositionX() >= 167 && game.getMousePositionY() >= 125 && game.getMousePositionY() <= 550)
            {
                whiteBall.setXPosition(game.getMousePositionX());
                whiteBall.setYPosition(game.getMousePositionY());
            }
            else if ( game.rightMousePressed() && game.getMousePositionX() < 167 && game.getMousePositionY() >= 170 && game.getMousePositionY() <= 510)
            {
                whiteBall.setXPosition(game.getMousePositionX());
                whiteBall.setYPosition(game.getMousePositionY());
            }
        }
    }
    /**
     * This detects what ball has been potted, and determines if the ball potted was right for the turn
     */
    private void ballPotted() {
        int x = 0;
        int y = 0;
        try {
            while (pottedBall != redBalls.get(x)) { //Detects what colour ball has been potted
                x++;
            }
        } catch (Exception e) {
            while (pottedBall != blueBalls.get(y)) {
                y++;
            }
        }
        try {
            if (pottedBall == redBalls.get(x)) { //If red ball was potted
                if (turnBall.getColour().equals("RED")) {
                    rightBallPotted = true;
                } else if (turnBall.getColour().equals("BLUE")) {
                    rightBallPotted = false;
                }
                redBalls.remove(x);
                redBallCount--;
            }
    } catch (Exception e){
            if (pottedBall == blueBalls.get(y)) { //If blue ball was potted
               if (turnBall.getColour().equals("BLUE")) {
                   rightBallPotted = true;
               }
               else if (turnBall.getColour().equals("RED")) {
                   rightBallPotted = false;
               }
               blueBalls.remove(y);
               blueBallCount--;
           }
       }
    }

    private void redVictory()
    {
        game.clearGameArena(); //Remove table and balls
        Text redVictoryText = new Text("Red wins!", 50, 375, 350, "RED", 3);
        game.addText(redVictoryText);

    }
    private void blueVictory()
    {
        game.clearGameArena();
        Text blueVictoryText = new Text("Blue wins!", 50, 375, 350, "BLUE", 3);
        game.addText(blueVictoryText);
    }
    /**
     * Allows movement of the cue ball after it has been shot
     */
    private void whiteBallMovement()
    {
        game.removeText(Foul);
        double directionX = (game.getMousePositionX() - whiteBall.getXPosition()); //Gets direction of where ball will go depending where clicked
        double directionY = (game.getMousePositionY() - whiteBall.getYPosition());
        double lineLength = Math.sqrt(Math.pow(game.getMousePositionX() - whiteBall.getXPosition(), 2) + Math.pow(game.getMousePositionY() - whiteBall.getYPosition(), 2)); //Determines power using line length
        double[] vector = new double[2];
        vector[0] = directionX;
        vector[1] = directionY;
        vector = normalizeVector(vector);
        double velocityX = (vector[0] * lineLength)/25; //Determines velocity using length of line
        double velocityY = (vector[1] * lineLength)/25;
        whiteBall.setxMovement(velocityX); //Sets movement of white ball once clicked
        whiteBall.setyMovement(velocityY);
        }
    }



