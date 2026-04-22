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

@DisplayName("BankAccount")
class BankAccountTest {

    @Nested
    @DisplayName("When a new account is created")
    class WhenNewAccountIsCreated {

        private BankAccount account;

        @BeforeEach
        void setUp() {
            account = new BankAccount("Alice", 100.0);
        }

        @Test
        @Tag("smoke")
        @DisplayName("Owner name is set correctly")
        void ownerIsSetCorrectly() {
            assertThat(account.getOwner()).isEqualTo("Alice");
        }

        @Test
        @Tag("smoke")
        @DisplayName("Initial balance is set correctly")
        void initialBalanceIsSetCorrectly() {
            assertThat(account.getBalance()).isCloseTo(100.0, within(0.01));
        }

        @Test
        @DisplayName("Account is not empty when balance is positive")
        void accountIsNotEmpty() {
            assertThat(account.isEmpty()).isFalse();
        }
    }

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
            account.deposit(25.0);
            assertThat(account.getBalance()).isCloseTo(75.0, within(0.01));
        }

        @Test
        @Tag("regression")
        @DisplayName("Depositing zero throws IllegalArgumentException")
        void depositingZeroThrowsException() {
            assertThrows(IllegalArgumentException.class, () ->
                account.deposit(0.0)
            );
        }
    }

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
            account.withdraw(30.0);
            assertThat(account.getBalance()).isCloseTo(70.0, within(0.01));
        }

        @Test
        @DisplayName("Account isEmpty when balance reaches zero")
        void accountIsEmptyWhenBalanceIsZero() {
            account.withdraw(100.0);
            assertThat(account.isEmpty()).isTrue();
        }

        @Test
        @Tag("regression")
        @DisplayName("Withdrawing more than balance throws IllegalStateException")
        void withdrawingMoreThanBalanceThrowsException() {
            assertThrows(IllegalStateException.class, () ->
                account.withdraw(200.0)
            );
        }

        @Test
        @Tag("regression")
        @DisplayName("Creating account with negative balance throws IllegalArgumentException")
        void creatingAccountWithNegativeBalanceThrowsException() {
            assertThrows(IllegalArgumentException.class, () ->
                new BankAccount("Dave", -50.0)
            );
        }
    }
}
