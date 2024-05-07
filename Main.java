/* The Game is a Multiplayer Game where N players roll a 6 faced dice in a round-robin fashion. 
Each time a player rolls the dice their points increase by the number (1 to 6) achieved by the 
roll. */ 

import java.util.*;
class Player
{
    int pid, score;
    boolean turn;
    Player(int i) 
    { 
        this.pid = i+1;
        this.score = 0;
        this.turn = false;
    }
}

class DiceGame
{
    int N, M;
    Player[] A, shuffledPlayers;

    DiceGame(int N, int M)
    {
        this.N = N; // N: No. of Players
        this.M = M; // M: No. of Points
        A = new Player[N];
        for (int i=0; i<N; i++)
        A[i] = new Player(i);
    }

    void shufflePlayer()
    {
        // Convert the Array to a List
        List<Player> playerList = new ArrayList<>();
        for (Player player : A)
            playerList.add(player);
        // Shuffle the List
        Collections.shuffle(playerList);
        // Convert the List back to an Array
        shuffledPlayers = new Player[N];
        shuffledPlayers = playerList.toArray(new Player[playerList.size()]);
    }

    int diceRoll()
    {
        Random random = new Random();
        int dice = random.nextInt(6) + 1;
        return dice;
    }

    void display()
    {
        System.out.println("CURRENT RANK TABLE");
        System.out.println("PLAYER\tSCORE");
        for (Player p : shuffledPlayers)
        {
            if (p.score >= M)
            System.out.println(p.pid+"\t"+p.score+"\tCompleted");
            else
            System.out.println(p.pid+"\t"+p.score);
        }
        System.out.println();
    }

    // Play the Game
    void game()
    {
        Scanner input = new Scanner(System.in);
        char ans;
        int dice=0;
        while(true)
        {
            int complete = 1 ;
            for (Player currentPlayer : shuffledPlayers)
            {
                if (currentPlayer.score < M)
                {
                    complete = 0;
                    display();
                    if (currentPlayer.turn){
                        currentPlayer.turn = false;
                        continue;
                    }
                    System.out.println("Player - "+currentPlayer.pid+" it's your turn.");
                    System.out.print("Press 'r' to Roll the Dice : ");
                    ans = input.next().charAt(0);
                    if (ans == 'r')
                    dice = diceRoll();
                    if (dice == 6)
                    {
                        System.out.println("Another Chance!!!");
                        System.out.print("Press 'r' to Roll the Dice : ");
                        ans = input.next().charAt(0);
                        if (ans == 'r')
                        dice = diceRoll();
                        currentPlayer.score += (6+dice);
                    }
                    else if (dice==1)
                    {
                        System.out.println("Penalty for Rolling 1!!!");
                        System.out.println("You Rolled 2 1's!!!");
                        System.out.println("Player - " + currentPlayer.pid + " will miss next turn.");
                        currentPlayer.score += 2;
                        currentPlayer.turn = true;
                    }
                    else
                        currentPlayer.score += dice;
                }
            }
            if (complete==1)
            break;              
        }
    }
}

public class Main
{
    public static void main(String[] args) 
    {
        int N = Integer.parseInt(args[0]); // N: No. of Players
        int M = Integer.parseInt(args[1]); // M: No. of Points
        DiceGame game = new DiceGame(N, M);
        game.shufflePlayer();
        game.game();
        game.display();
    }
}