package SetProject;

import java.util.Scanner;

public class setDataType {

    static int setDataType[][];
    static int setsCreated = 0; //Ensures set(s) have been created
    static Scanner input = new Scanner(System.in);

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Create Set
    public static int[][] createSet(int number) {

        setDataType = new int[number][];
        int capacity;
        int count = 0;
        System.out.println("Please input the capacity of your sets:");
        for (int i = setsCreated; i < number; i++) {
            System.out.print("Capacity of set " + (i + 1) + ": "); {
                capacity = input.nextInt();
                setDataType[i] = new int[capacity];
                setsCreated++;
                count++;
            }
        }
        System.out.println(count + " Sets Created.");
        return setDataType;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Add into Set
    public static int[][] add(int key, int set) {
        int flag = 0;
        if (isFull(set) == false) {
            //Duplicates Check For LOOP
            for (int i = 0; i < setDataType[set].length; i++) {
                if (setDataType[set][i] == key) {
                    System.out.println(key + " already exisits in set");
                    flag = 1;
                    break;

                }
            }
            //Insert LOOP
            for (int i = 0; i < setDataType[set].length; i++) {
                if (setDataType[set][i] == 0 && flag != 1) {
                    setDataType[set][i] = key;
                    System.out.println(key + " added to set " + set);
                    break;
                }
            }

        } else {
            System.out.println("Set number " + set + " Is full.");
        }

        return setDataType;

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //IS full use in conjunction with ADD
    public static boolean isFull(int set) {
        boolean full = false;

        for (int i = 0; i < setDataType[set].length; i++) {
            if (setDataType[set][i] == 0) {
                full = false;
                break;
            } else {
                full = true;
            }
        }

        return full;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Contains
    public static boolean contains(int key, int set) {
        boolean contains = false;

        for (int i = 0; i < setDataType[set].length; i++) {
            if (setDataType[set][i] == key)
                contains = true;
        }
        return contains;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //RemoveAll elements contained in REMSET from SET
    public static void removeAll(int remSet, int set) {
        int count = 0;

        for (int i = 0; i < setDataType[set].length; i++) {
            for (int j = 0; j < setDataType[remSet].length; j++) {
                if (setDataType[set][i] == setDataType[remSet][j] && setDataType[set][i] != 0) {
                    setDataType[set][i] = 0;
                    count++;
                }
            }
        }
        System.out.println(count + " element(s) removed from set " + set);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Print The Set
    public static void print(int set) {

        System.out.print("Set " + set + ": ");
        for (int i = 0; i < setDataType[set].length; i++) {
            System.out.print(setDataType[set][i] + " ");
        }
        System.out.println();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Print ALL Sets
    public static void printAll() {
        int count = 0;
        for (int i = 0; i < setDataType.length; i++) {
            System.out.print("Set " + count + ": ");
            count++;
            for (int j = 0; j < setDataType[i].length; j++) {

                System.out.print(setDataType[i][j] + " ");
            }
            System.out.println();
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //returns the intersection of setS and setT.
    public static void intersection(int setS, int setT) {
        int count = 0;
        for (int i = 0; i < setDataType[setS].length; i++) {
            for (int j = 0; j < setDataType[setT].length; j++) {
                if (setDataType[setS][i] == setDataType[setT][j] && setDataType[setS][i] != 0) {
                    System.out.print(setDataType[setT][j] + ",");
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("No Insection found between sets " + setS + " and " + setT);
        }
        System.out.println();
    }

    //Outputs the total sum of a set
    public static void sum(int set) {
        int sum = 0;
        for (int i = 0; i < setDataType[set].length; i++) {
            sum = sum + setDataType[set][i];
        }
        System.out.println("Sum of set " + set + " is " + sum);
    }

    public static void menu() {

        int option = 0;
        do {
            System.out.println("==================");
            System.out.println("SET DATA TYPE");
            System.out.println("==================");
            System.out.println("Please select an option from the menu list below:");
            System.out.println("[1] Create Set - This option will create an empty set or multiple empty sets dependant on needs.");
            System.out.println("[2] Populate Set - Fully populate a set.");
            System.out.println("[3] Add to Set - Add a number to one of your sets.");
            System.out.println("[4] Contains - Search one of your sets for a specfic number, returns true if found.");
            System.out.println("[5] RemoveAll - Used to remove from a target set all of its elements that are contained in the specified set.");
            System.out.println("[6] Sum - Will return the sum of each element of a specfic set.");
            System.out.println("[7] Intersection - Will return the intersection of two target sets.");
            System.out.println("[8] Print - Will output a target set to the screen.");
            System.out.println("[9] PrintAll - Will output all Created sets to the screen");
            System.out.println("[10] EXIT - Will terminate the application");
            System.out.println();
            System.out.print("Please type your selection: ");
            option = input.nextInt();

            switch (option) {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                case 1:
                    if (setsCreated == 0) {
                        System.out.print("How many Sets do you want to create?: ");
                        int number = input.nextInt();
                        createSet(number);
                    } else {
                        System.out.println(setsCreated + " Sets have already been created");
                        System.out.println("Please restart the application to create more sets.");
                    }

                    break;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                case 2:
                    if (setsCreated == 0) {
                        System.out.println("No sets found.");
                        System.out.println("First create atleast one set to continue");
                    } else {
                        System.out.println("Please Note: Use unique values only.");
                        System.out.println("Duplicate values will be ignored.");
                        System.out.print("Which set to Populate?: ");
                        int setId = input.nextInt();
                        if (setId < setsCreated) {
                            for (int i = 0; i < setDataType[setId].length; i++) {
                                System.out.print("Input number to insert: ");
                                int number = input.nextInt();
                                setDataType = add(number, setId);

                            }
                        } else {
                            System.out.println("Set" + setId + " does not exist.");
                            break;
                        }

                    }
                    break;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                case 3:
                    if (setsCreated == 0) {
                        System.out.println("No sets found.");
                        System.out.println("First create atleast one set to continue");
                    } else {

                        System.out.print("What Number to insert?: ");
                        int number = input.nextInt();
                        System.out.print("Which set to insert?: ");
                        int setId = input.nextInt();
                        if (setId < setsCreated) {
                            setDataType = add(number, setId);
                        } else {
                            System.out.println("Set" + setId + " does not exist.");
                            break;
                        }

                    }
                    break;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                case 4:
                    System.out.print("What Number are you looking for?: ");
                    int number = input.nextInt();
                    System.out.print("Which set would you like to search?: ");
                    int setId = input.nextInt();

                    if (setId < setsCreated) {
                        System.out.print("Does " + number + " exisit in the set " + setId + "?: " + contains(number, setId));
                        System.out.println();
                    } else {
                        System.out.println("Set" + setId + " does not exist.");
                        break;
                    }

                    break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////// ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                case 5:
                    int setS = 0,
                        setT = 0;

                    System.out.print("Which set do you wish to use as a base?: ");
                    setS = input.nextInt();
                    if (setS < setsCreated) {
                        System.out.print("Which set would you like to use as a target?: ");
                        setT = input.nextInt();
                        if (setT < setsCreated) {
                            removeAll(setS, setT);
                        } else {
                            System.out.println("Set" + setS + " does not exist.");
                        }
                    } else {
                        System.out.println("Set" + setT + " does not exist.");
                        break;
                    }
                    break;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                case 6:

                    setS = 0;

                    System.out.print("Which set would you like to use as a target?: ");
                    number = input.nextInt();
                    if (number < setsCreated) {
                        
                        sum(number);
                    } else {
                        System.out.println("Set" + setS + " does not exist.");
                    }
                    break;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                case 7:
                    System.out.print("Which set would you like to use as Set(1): ");
                    setS = input.nextInt();
                    if (setS < setsCreated) {
                        System.out.print("Which set would you like to use as Set(2): ");
                        setT = input.nextInt();
                        if (setT < setsCreated) {
                            System.out.print("(setS n setT: "); 
                            intersection(setS, setT);
                            System.out.println();
                        } else {
                            System.out.println("Set" + setT + " does not exist.");
                        }
                    } else {

                        System.out.println("Set" + setS + " does not exist.");
                    }

                    break;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                case 8:
                    if (setsCreated == 0) {
                        System.out.println("No sets found.");
                        System.out.println("First create atleast one set to continue");
                    } else {
                        System.out.print("Which set would you like to output: ");
                        number = input.nextInt();
                        if (number < setsCreated) {
                            print(number);
                        } else {

                            System.out.println("Set" + number + " does not exist.");
                        }
                    }

                    break;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                case 9:
                    if (setsCreated == 0) {
                        System.out.println("No sets found.");
                        System.out.println("First create atleast one set to continue");
                    } else {
                        printAll();
                    }
                    break;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////                  
                case 10:

                    System.exit(0);
                    break;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                default:
                    System.out.println("System error please selection and option from 1-9");
                    menu();
                    break;
            }
        } while (option != 10);
    }

    public static void main(String[] args) {
      
        menu();
    }

}
