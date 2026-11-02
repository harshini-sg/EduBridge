package chapter1.program5;

public class BankTest {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("1234567890", 5000);
        BankAccount a2 = new BankAccount("9876543210", 1000);

        System.out.println("Account ID: " + a1.getAccountId());
        a1.deposit(1500);
        a1.deposit(-200);      // rejected
        a1.withdraw(2000);
        a1.withdraw(-50);      // rejected
        a1.withdraw(99999);    // rejected: exceeds balance
        System.out.println("Balance: " + a1.getBalance());
        System.out.println("Accounts created: " + BankAccount.getTotalAccounts());

        // Challenge 1: direct access
        // System.out.println(a1.balance);
        //   -> COMPILE ERROR: 'balance' has private access in BankAccount

        // Challenge 4: final reference
        final BankAccount ref = a1;
        // ref = a2;   // COMPILE ERROR: cannot assign a value to final variable 'ref'
        ref.deposit(100);   // allowed: the OBJECT can still change, only the reference is fixed
    }

    /*
     * CHALLENGE ANSWERS
     * 1. Accessing balance directly gives a compile-time error (private access).
     * 2. private protects the balance because it can only change through deposit()
     *    and withdraw(), which validate every change (encapsulation).
     * 3. static is appropriate because the number of accounts belongs to the class,
     *    not to any single account.
     * 4. No. A final reference cannot be re-assigned to a different object, but the
     *    state of the object it points to can still be modified.
     */
}
