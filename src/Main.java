import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] names = new String[4];

        for(int i = 0; i < names.length; ++i) {
            System.out.print("Candidate: ");
            names[i] = scan.nextLine();
        }

        System.out.print("Voters: ");
        Integer voters = scan.nextInt();
        double percOne = Math.random() * 5.0 + 97.5;
        double percTwo = 100.0 + (100.0 - percOne);
        double percThree = Math.random() * 5.0 + 97.5;
        double percFour = 100.0 + (100.0 - percThree);
        int[] votes = new int[]{(int)(percOne * (double)(voters / 4)) / 100, (int)(percTwo * (double)(voters / 4)) / 100, (int)(percThree * (double)(voters / 4)) / 100, (int)(percFour * (double)(voters / 4)) / 100 + 2};
        System.out.println(Arrays.toString(votes));
        percOne = Math.random() * 5.0 + 97.5;
        percTwo = Math.random() * 5.0 + 97.5;
        percThree = Math.random() * 5.0 + 97.5;

        while(percOne + percTwo + percThree != 100.0) {
            percOne = (double)((int)(Math.random() * 6.0 + 30.0));
            percTwo = (double)((int)(Math.random() * 6.0 + 30.0));
            percThree = (double)((int)(Math.random() * 6.0 + 30.0));
        }

        int loser = 0;

        for(int i = 0; i < 4; ++i) {
            if (votes[i] <= votes[0] && votes[i] <= votes[1] && votes[i] <= votes[2] && votes[i] <= votes[3]) {
                loser = votes[i];
                votes[i] = 0;
            }
        }

        for (int k=0; k < 4; ++k) {
            if(votes[k] != 0) {
                votes[k] += loser/3;
            }
        }

        for (int i = 0; i < 4; ++i) {
            if ((votes[i] <= votes[0] || votes[0] == 0) && (votes[i] <= votes[1] || votes[1] == 0) && (votes[i] <= votes[2] || votes[2] == 0) && (votes[i] <= votes[3] || votes[3] == 0) && votes[i] != 0) {
                loser = votes[i];
                votes[i] = 0;
            }
        }

        for (int k=0;k<4; k++) {
            if(votes[k] != 0) {
                votes[k] += loser/2;
            }        }

        for (int i = 0; i < 4; ++i) {
            if ((votes[i] <= votes[0] || votes[0] == 0) && (votes[i] <= votes[1] || votes[1] == 0) && (votes[i] <= votes[2] || votes[2] == 0) && (votes[i] <= votes[3] || votes[3] == 0) && votes[i] != 0) {
                loser = votes[i];
                votes[i] = 0;
            }
        }

        for (int k=0;k<4; k++) {
            if(votes[k] != 0) {
                votes[k] += loser;
                System.out.println("Winner: " + names[k]);            }        }

        System.out.println(Arrays.toString(votes));

    }
}
