package int101.homework02;

import int101.work03.Account;
import int101.work1.Utilitor;
import int101.work2.Person;

public class Int101Homework02 {

    public static void main(String[] args) {
       work01Utilitor();
       work02Person();
       work03Account();
    }

    static void work01Utilitor() {
       /*
       1.1 Create a public utility class named "Utilitor" in package named "work01Utilitor".
       1.2 Create a public method named "testString" in "Utilitor" class.
           This method receives a parameter of type "String"
           named "value" and it returns the "value" if nothing is wrong.
           However, if the "value" is null, it throws NullPointerException.
           If the "value" is a blank string, it throws IllegalArgumentException.
       1.3 Create a public method named "testPositive" in "Utilitor" class.
           This method receives a parameter of type "double" named "value"
           and it returns the "value" if this "value" is a positive value.
           Otherwise, it throws IllegalArgumentException.
       1.4 Create a public method named "computeIsbn10" in "Utilitor" class.
           This method recieves a parameter of type "long" named "isbn10"
           and it returns the value of "isbn10" whose last digit is modified
           to make it a valid ISBN-10.
           See https://en.wikipedia.org/wiki/Check_digit for ISBN-10 calculation.
           ** You must use loop to calculate the ISBN-10 check-digit. **
       1.5 Show in this "work01Utilitor" method how to use 1.2-1.4 and
           check their correctness. */


        /* Test: testString method */
        System.out.println( "----------1.2----------");

        try {
            System.out.println(Utilitor.testString(""));
        } catch (Exception e) {
            System.out.println("Error appeared: " + e.toString());
        }

        try {
            System.out.printf(Utilitor.testString(null));
        } catch (Exception e) {
            System.out.println("Error appeared: " + e.toString());
        }

        System.out.println("testString method: " + Utilitor.testString("Test string"));

        System.out.println( "----------1.3----------");

        try {
            System.out.printf(Utilitor.testPositive(0) + "");
        } catch (Exception e) {
            System.out.println("Error appeared: " + e.toString());
        }

        System.out.println("testPositive method: " + Utilitor.testPositive(100));
        System.out.println( "----------1.4----------");
        try {
            System.out.printf(Utilitor.computeIsbn10(-1) + "");
        } catch (Exception e) {
            System.out.println("Error appeared: " + e);
        }

        System.out.println("computeIsbn10 method: " + Utilitor.computeIsbn10( 1_000_000_000));



    }

    static void work02Person() {
       /*
       2.1 Create a public class named "Person" in package named "work02Person".
           This class contains the following fields and methods.
       2.2 a private static field of type "int" named "nextId" initialized to 1.
       2.3 a private final field of type "int" named "id".
       2.4 a private field of type "String" named "firstname".
       2.5 a private field of type "String" named "lastname".
       2.6 a public constructor that receives "firstname" and "lastname"
           parameters to set the values of "firstname" and "lastname" fields.
           Check the correctness of the values of "firstname" and "lastname"
           parameters with "Utilitor.testString" method first.
           If nothing is wrong, set the value of "id" field to be the value
           of "nextId" field and increment the value of "nextId" by 1.
       2.7 @Override a public "toString" method that returns
           "Person(id,firstname,lastname)" where id, firstname, and lastname
           are the values of the coresponding fields of this "Person" object.
           Use "StringBuilder" to build the output string.
       2.8 public getters for "id", "firstname", and "lastname" fields.
       2.9 public setters for "firstname" and "lastname" fields.
           Use the "Utilitor.testString" method to check the correctness
           of the parameters first.
       2.10 @Override a public "equals" method that returns true
            if this object is the same as the object in the parameter
            (i.e., the same reference). Otherwise, it returns false.
       2.11 Show in this "work02Person" method how to use 2.6-2.10
            and check their correctness. */
        System.out.println( "----------2.6----------");
        try {
            Person nullPerson = new Person(null, null);
        } catch (Exception e) {
            System.out.println("Error appeared: " + e.toString());
        }
        Person nine = new Person("Teprawin", "Prueksachat");
        Person karn = new Person("Karn", "Zige");

        System.out.println( "----------2.7----------");
        System.out.println(nine.toString());
        System.out.println(karn.toString());
        System.out.println( "----------2.8----------");
        System.out.println("Nine's firstName: " + nine.getFirstName());
        System.out.println("Nine's lastName: " + nine.getLastName());
        System.out.println("Nine's ID: " + nine.getId());
        System.out.println( "----------2.9----------");
        System.out.println("Change Nine's firstName to null: ");
        try {
            nine.setFirstName(null);
        } catch (Exception e) {
            System.out.println("Error appeared: " + e.toString());
        }
        System.out.println("Change Nine's firstName to Sukum: ");
        nine.setFirstName("Sukum");
        System.out.println("Nine's firstName: " + nine.getFirstName());

        System.out.println("Change Nine's lastName to null: ");
        try {
            nine.setLastName(null);
        } catch (Exception e) {
            System.out.println("Error appeared: " + e.toString());
        }
        System.out.println("Change Nine's lastName to Decha: ");
        nine.setLastName("Decha");
        System.out.println("Nine's firstName: " + nine.getLastName());
        System.out.println( "----------2.10----------");
        System.out.println("Nine equals Nine: " + nine.equals(nine));
        System.out.println("Karn equals Karn: " + karn.equals(karn));
        System.out.println("Nine equals Karn: " + nine.equals(karn));
        System.out.println("Karn equals Nine: " + karn.equals(nine));
    }

    static void work03Account() {
       /*
       3.1 Create a public class named "Account" in package named "work03Account".
           This class contains the following fields and methods.
       3.2 a private static field of type "long" named "nextNo"
           initialized to 1_000_000_000.
       3.3 a private final "no" field of type "long".
       3.4 a private "owner" field of type "Person".
       3.5 a private "balance" field of type "double".
       3.6 a public constructor that receives an "owner" parameter of
           type "Person" to set the "owner" field. This method throws
           NullPointerException if the "owner" parameter is null.
           This method sets the value of "no" field to be the result from
           sending the "nextId" field to "Utilitor.computeIsbn10" method;
           and then increments the value of "nextId" by 10.
           This method sets the value of "balance" to 0.0.
       3.7 public getters for "no", "owner", and "balance".
       3.8 a public method named "deposit" that receives a "double" parameter
           named "amount". This method throws IllegalArgumentException
           if "amount" cannot pass "Utilitor.testPositive" method.
           Otherwise, the method adds the "amount" to "balance"
           and then returns the new "balance".
       3.9 a public method named "withdraw" that receives a "double" parameter
           named "amount". This method throws IllegalArgumentException
           if "amount" does not pass "Utilitor.testPositive" method.
           Otherwise, the method subtracts the "amount" from "balance"
           and then returns the new "balance".  However, this method will not
           do so if the new "balance" cannot pass "Utilitor.testPositive" method.
       3.10 a public method named "transfer" that recieves a "double" parameter
            named "amount" and an "Account" parameter named "account".
            This method throws IllegalArgumentException if "account" is null
            or it cannot "withdraw" the "amount" from this object. Otherwise,
            this method "withdraw" the "amount" from this object and "deposit"
            the "amount" to the "account" object.  This method returns nothing.
       3.11 @Override a public "toString" method that returns
            "Account(no,balance)" where "no" and "balance" are
            the "no" and "balance" fields of this object.
       3.12 @Override a public "equals" method that returns true
            if this object is the same as the object in the parameter
            (i.e., the same reference). Otherwise, it returns false.
       3.13 Show in this "work03Account" method how to use 3.6-3.12
            and check their correctness. */
        System.out.println( "----------3.6----------");
        Person nine = new Person("Teprawin", "Prueksachat");
        try {
            new Account(null);
        } catch (Exception e) {
            System.out.println("Error appeared: " + e.toString());
        }
        Account nineAccount = new Account(nine);
        System.out.println("Nine account has been created.");
        System.out.println( "----------3.7----------");
        System.out.println("Nine account's balance: " + nineAccount.getBalance() + "$");
        System.out.println("Nine account's no: " + nineAccount.getNo());
        System.out.println("Nine account's owner: " + nineAccount.getOwner());
        System.out.println( "----------3.8----------");

        try {
            System.out.println(nineAccount.deposit(-1));
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Nine account's balance (deposit 500): " + nineAccount.deposit(500));
        System.out.println( "----------3.9----------");

        try {
            System.out.println(nineAccount.withdraw(-1));
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Nine account's balance (withdraw 100): " + nineAccount.withdraw(100));
        System.out.println( "----------3.10----------");
        Person karn = new Person("Karn", "Zige");
        Account karnAccount = new Account(karn);

        try {
            nineAccount.transfer(100, null);
        } catch (Exception e) {
            System.out.println(e);
        }

        nineAccount.transfer(100, karnAccount);

        System.out.println("Karn account's balance: " + karnAccount.getBalance());
        System.out.println("Nine account's balance: " + nineAccount.getBalance());

        System.out.println( "----------3.11----------");
        System.out.println(nineAccount.toString());

        System.out.println( "----------3.12----------");
        System.out.println("Nine's account equals Nine's account: " + nineAccount.equals(nineAccount));
        System.out.println("Karn's account equals Karn's account: " + karnAccount.equals(karnAccount));
        System.out.println("Nine's account equals Karn's account: " + nineAccount.equals(karnAccount));
        System.out.println("Karn's account equals Nine's account: " + karnAccount.equals(nineAccount));
    }
}
