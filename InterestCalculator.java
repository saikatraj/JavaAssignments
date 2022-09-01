import java.util.Scanner;

abstract class Account 
{
    double interestRate;
    double amount;

    abstract double calculateInterest();
}

class FDAccount extends Account 
{
    int noOfDays;
    int ageOfACHolder;

    double calculateInterest() 
    {
        if (amount < 10000000) 
        {
            if (noOfDays >= 7 && noOfDays <= 14) 
            {
                if (ageOfACHolder >= 60) 
                {
                    interestRate = 5.00;
                } 
                else 
                {
                    interestRate = 4.50;
                }
            } 
            else if (noOfDays >= 15 && noOfDays <= 29) 
            {
                if (ageOfACHolder >= 60) 
                {
                    interestRate = 5.25;
                } 
                else 
                {
                    interestRate = 4.75;
                }
            } 
            else if (noOfDays >= 30 && noOfDays <= 45) 
            {
                if (ageOfACHolder >= 60) 
                {
                    interestRate = 6.00;
                } 
                else 
                {
                    interestRate = 5.50;
                }
            } 
            else if (noOfDays >= 45 && noOfDays <= 60) 
            {
                if (ageOfACHolder >= 60) 
                {
                    interestRate = 7.50;
                } 
                else 
                {
                    interestRate = 7.00;
                }
            } 
            else if (noOfDays >= 61 && noOfDays <= 184) 
            {
                if (ageOfACHolder >= 60) 
                {
                    interestRate = 8.00;
                } 
                else 
                {
                    interestRate = 7.50;
                }
            } 
            else if (noOfDays >= 185 && noOfDays <= 365) 
            {
                if (ageOfACHolder >= 60) 
                {
                    interestRate = 8.50;
                } 
                else 
                {
                    interestRate = 8.00;
                }
            }
        } 
        else 
        {
            if (noOfDays >= 7 && noOfDays <= 14) 
            {
                interestRate = 6.50;
            } 
            else if (noOfDays >= 15 && noOfDays <= 29) 
            {
                interestRate = 6.75;
            }
            else if (noOfDays >= 30 && noOfDays <= 45) 
            {
                interestRate = 6.75;
            } 
            else if (noOfDays >= 45 && noOfDays <= 60) 
            {
                interestRate = 8.00;
            } 
            else if (noOfDays >= 61 && noOfDays <= 184) 
            {
                interestRate = 8.50;
            } 
            else if (noOfDays >= 185 && noOfDays <= 365) 
            {
                interestRate = 10.00;
            }
        }
        return (amount * interestRate) / 100;
    }
}

class SBAccount extends Account 
{
    double interestRate = 4.00;
    double calculateInterest() 
    {
        return (amount * interestRate) / 100;
    }
}

class RDAccount extends Account 
{
    int noOfMonths;
    double monthlyAmount;
    int ageOfACHolder;

    double calculateInterest() 
    {
        if (noOfMonths == 6)
        {
            if(ageOfACHolder >= 60)
            {
                interestRate = 8.00;
            }
            else
            {
                interestRate = 7.50;
            }
        }
        else if (noOfMonths == 9)
        {
            if(ageOfACHolder >= 60)
            {
                interestRate = 8.25;
            }
            else
            {
                interestRate = 7.75;
            }
        }
        else if (noOfMonths == 12)
        {
            if(ageOfACHolder >= 60)
            {
                interestRate = 8.50;
            }
            else
            {
                interestRate = 8.00;
            }
        }
        else if (noOfMonths == 15)
        {
            if(ageOfACHolder >= 60)
            {
                interestRate = 8.75;
            }
            else
            {
                interestRate = 8.25;
            }
        }
        else if (noOfMonths == 18)
        {
            if(ageOfACHolder >= 60)
            {
                interestRate = 9.00;
            }
            else
            {
                interestRate = 8.50;
            }
        }
        else if (noOfMonths == 21)
        {
            if(ageOfACHolder >= 60)
            {
                interestRate = 9.25;
            }
            else
            {
                interestRate = 8.75;
            }
        }
        return (monthlyAmount * interestRate) / 100;
    }
}

class InterestCalculator 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        do 
        {
            System.out.println("MAIN MENU");
            System.out.println("---------");
            System.out.println("1. Interest Calculator - SB");
            System.out.println("2. Interest Calculator - FD");
            System.out.println("3. Interest Calculator - RD");
            System.out.println("4. Exit");
            System.out.print("Enter your option (1..4): ");
            choice = sc.nextInt();
            switch (choice) 
            {
                case 1:
                    System.out.print("Enter the Average amount in your account: ");
                    double amount = sc.nextDouble();
                    if(amount < 0)
                    {
                        System.out.println("Invalid amount. Please enter non-negative values.");
                    }
                    else
                    {
                        SBAccount sb = new SBAccount();
                        sb.amount = amount;
                        System.out.println("Interest gained is: Rs. " + sb.calculateInterest());
                    }
                    break;
                case 2:
                    System.out.print("Enter the FD amount: ");
                    double fdAmount = sc.nextDouble();
                    if(fdAmount < 0)
                    {
                        System.out.println("Invalid amount. Please enter non-negative values.");
                    }
                    else
                    {
                        System.out.print("Enter the number of days: ");
                        int noOfDays = sc.nextInt();
                        if(noOfDays < 0)
                        {
                            System.out.println("Invalid number of days. Please enter non-negative values.");
                        }
                        else
                        {
                            System.out.print("Enter the age of the account holder: ");
                            int ageOfACHolder = sc.nextInt();
                            if(ageOfACHolder < 0)
                            {
                                System.out.println("Invalid age. Please enter non-negative values.");
                            }
                            else
                            {
                                FDAccount fd = new FDAccount();
                                fd.amount = fdAmount;
                                fd.noOfDays = noOfDays;
                                fd.ageOfACHolder = ageOfACHolder;
                                System.out.println("Interest gained is: Rs. " + fd.calculateInterest());
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter the RD amount: ");
                    double rdAmount = sc.nextDouble();
                    if(rdAmount < 0)
                    {
                        System.out.println("Invalid amount. Please enter non-negative values.");
                    }
                    else
                    {
                        System.out.print("Enter the number of months: ");
                        int noOfMonths = sc.nextInt();
                        if(noOfMonths < 0)
                        {
                            System.out.println("Invalid number of months. Please enter non-negative values.");
                        }
                        else
                        {
                            System.out.print("Enter the age of the account holder: ");
                            int ageOfACHolder = sc.nextInt();
                            if(ageOfACHolder < 0)
                            {
                                System.out.println("Invalid age. Please enter non-negative values.");
                            }
                            else
                            {
                                RDAccount rd = new RDAccount();
                                rd.amount = rdAmount;
                                rd.noOfMonths = noOfMonths;
                                rd.ageOfACHolder = ageOfACHolder;
                                System.out.println("Interest gained is: Rs. " + rd.calculateInterest());
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Thank you");
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 4);
    }
}
