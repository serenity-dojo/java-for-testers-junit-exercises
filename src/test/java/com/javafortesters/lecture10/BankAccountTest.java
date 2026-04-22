package com.javafortesters.lecture10;

import com.javafortesters.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Lecture 10 Exercise — Putting It All Together
 *
 * This exercise covers everything from the module:
 *   @Test, @BeforeEach, @Nested, @DisplayName, @Tag, assertThrows, and AssertJ assertions.
 *
 * The BankAccount class has:
 *   - BankAccount(owner, initialBalance) — throws IllegalArgumentException if balance is negative
 *   - deposit(amount)  — throws IllegalArgumentException if amount is zero or negative
 *   - withdraw(amount) — throws IllegalArgumentException if amount is zero or negative
 *                      — throws IllegalStateException if there are insufficient funds
 *   - getBalance()
 *   - getOwner()
 *   - isEmpty()        — returns true when balance is 0.0
 *
 * Complete all the TODO items below.
 * All 10 tests should go green once you're done.
 */
@DisplayName("BankAccount")
class BankAccountTest {

    // ─────────────────────────────────────────────────────────────────────────
    @Nested
    @DisplayName("When a new account is created")
    class WhenNewAccountIsCreated {

        private BankAccount account;

        @BeforeEach
        void setUp() {
            // TODO: Create a BankAccount with owner "Alice" and initial balance 100.0
            //       Assign it to 'account'
        }

        @Test
        @Tag("smoke")
        @DisplayName("Owner name is set correctly")
        void ownerIsSetCorrectly() {
            // TODO: Assert that account.getOwner() equals "Alice"
        }

        @Test
        @Tag("smoke")
        @DisplayName("Initial balance is set correctly")
        void initialBalanceIsSetCorrectly() {
            // TODO: Assert that account.getBalance() is close to 100.0
            //       Hint: use isCloseTo(100.0, within(0.01))
        }

        @Test
        @DisplayName("Account is not empty when balance is positive")
        void accountIsNotEmpty() {
            // TODO: Assert that account.isEmpty() returns false
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    @Nested
    @DisplayName("When depositing money")
    class WhenDepositing {

        private BankAccount account;

        @BeforeEach
        void setUp() {
            account = new BankAccount("Bob", 50.0);
        }

        @Test
        @DisplayName("Balance increases by the deposited amount")
        void balanceIncreasesAfterDeposit() {
            // TODO: Deposit 25.0 into the account
            // TODO: Assert the balance is close to 75.0
        }

        @Test
        @Tag("regression")
        @DisplayName("Depositing zero throws IllegalArgumentException")
        void depositingZeroThrowsException() {
            // TODO: Use assertThrows to verify depositing 0.0 throws IllegalArgumentException
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    @Nested
    @DisplayName("When withdrawing money")
    class WhenWithdrawing {

        private BankAccount account;

        @BeforeEach
        void setUp() {
            account = new BankAccount("Carol", 100.0);
        }

        @Test
        @DisplayName("Balance decreases by the withdrawn amount")
        void balanceDecreasesAfterWithdrawal() {
            // TODO: Withdraw 30.0 from the account
            // TODO: Assert the balance is close to 70.0
        }

        @Test
        @DisplayName("Account isEmpty when balance reaches zero")
        void accountIsEmptyWhenBalanceIsZero() {
            // TODO: Withdraw the full balance (100.0)
            // TODO: Assert that account.isEmpty() returns true
        }

        @Test
        @Tag("regression")
        @DisplayName("Withdrawing more than balance throws IllegalStateException")
        void withdrawingMoreThanBalanceThrowsException() {
            // TODO: Use assertThrows to verify that withdrawing 200.0
            //       (more than the 100.0 balance) throws IllegalStateException
        }

        @Test
        @Tag("regression")
        @DisplayName("Creating account with negative balance throws IllegalArgumentException")
        void creatingAccountWithNegativeBalanceThrowsException() {
            // TODO: Use assertThrows to verify that:
            //       new BankAccount("Dave", -50.0) throws IllegalArgumentException
        }
    }
}
