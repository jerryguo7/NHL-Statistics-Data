/* The OrderedListDemo class will demonstrate all the methods that have developed
 * <Jerry Guo> <2019.10.16>
 */
import java.util.Scanner;
import java.io.*;

public class OrderedListDemo {
    //merge method
    public static <T extends Comparable<T>> OrderedList<T>
                merge(OrderedList<T> list1, OrderedList<T> list2){
        OrderedList<T> list3 = new OrderedList<>();

        int i=0, j=0;
        //Compare the items lexicographically and append the items
        while (i<list1.size() && j<list2.size()){
            if (list1.get(i).compareTo(list2.get(j))<0){
                list3.insert(list1.get(i));
                i++;
            } else if (list1.get(i).compareTo(list2.get(j))>0) {
                list3.insert(list2.get(j));
                j++;
            } else {
                list3.insert(list1.get(i));
                i++;
                j++;
            }
        }

        //Append the items from list2 when list1 is empty
        if (i == list1.size()){
            while (j<list2.size()){
                list3.insert(list2.get(j));
                j++;
            }
        }

        //Append the items from list1 when list2 is empty
        if(j == list2.size()){
            while (i<list1.size()){
                list3.insert(list1.get(i));
                i++;
            }
        }

        return list3;
    }

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        try {
            System.out.print("Enter the first filename to read from: ");
            String filename1 = keyboard.nextLine();
            System.out.print("Enter the second filename to read from: ");
            String filename2 = keyboard.nextLine();

            File file = new File(filename1);
            Scanner inputFile = new Scanner(file);
            OrderedList<String> list1 = new OrderedList<String>();

            //Store the names to list1
            while (inputFile.hasNext()) {
                String s = inputFile.nextLine();
                list1.insert(s);
            }

            inputFile.close();

            System.out.println("The Ordered Lists contain the following entries:");
            //Display list1
            System.out.println("List 1:");
            list1.enumerate();

            File file2 = new File(filename2);
            Scanner inputFile2 = new Scanner(file2);
            OrderedList<String> list2 = new OrderedList<String>();

            //Store the names to list2
            while (inputFile2.hasNext()) {
                String s = inputFile2.nextLine();
                list2.insert(s);
            }

            inputFile2.close();

            //Display list2
            System.out.println("List 2:");
            list2.enumerate();

            //Call the marge method
            System.out.println("\nA merged version of the two lists looks like this:");
            merge(list1,list2).enumerate();

        } catch (Exception e) {
            System.out.println("Something went wrong. Please check your input and start over.");
        }
    }
}
