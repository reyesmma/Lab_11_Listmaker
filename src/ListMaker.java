import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<String>();
        String itemToAdd;
        int indexToInsert;


        boolean done = false;
        String cmdRegEx = "[AaDdIiPpQq]";

        do{
            showList(lines);
            String cmd = SafeInput.getRegExString(in, "Enter a command (A, D, I, P, Q)", cmdRegEx);

            switch (cmd.toUpperCase())
            {
                case "A":
                    itemToAdd = SafeInput.getNonZeroLenString(in,"Enter an item to add");
                    lines.add(itemToAdd);
                    break;
                case "D":
                    if(lines.size()>0){
                        int indexToDelete = SafeInput.getRangedInt(in,"Enter the index of the item to delete", 0, lines.size());
                        lines.remove(indexToDelete);
                        break;
                    }
                    else{
                        System.out.println("List is empty");
                        break;
                    }
                case "I":
                    if(lines.size()>0){
                        indexToInsert = SafeInput.getRangedInt(in,"Enter the index of item to insert", 0, lines.size());
                        itemToAdd = SafeInput.getNonZeroLenString(in,"Enter an item to add");
                        lines.add(indexToInsert, itemToAdd);
                        break;
                    }
                    else{
                        System.out.println("List is empty");
                        break;
                    }
                case "P":

                    break;
                case "Q":
                    boolean confirmQuit = SafeInput.getYNConfirm(in, "Are you sure? ");
                    if(confirmQuit==true)
                        done = true;
                        break;
            }

        }while(!done);
    }

    private static void showList(ArrayList<String> lines)
    {
        showMenu();
        System.out.println("=====================================");
        for(int i = 0; i < lines.size(); i++)
        {
            System.out.println((i + 1) + ": " + lines.get(i));
        }
        System.out.println("=====================================");
    }

    private static void showMenu()
    {
        System.out.println("\t\t\t\tMENU");
        System.out.println("=====================================");
        System.out.println("A – Add an item to the list");
        System.out.println("D – Delete an item from the list");
        System.out.println("I – Insert an item into the list");
        System.out.println("P – Print the list");
        System.out.println("Q – Quit the program");
    }
}

