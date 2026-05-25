/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author rapha
 */
public class Part2projectTest {
    
    public Part2projectTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class Part2project.
     */
    @org.junit.jupiter.api.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Part2project.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMessageId method, of class Part2project.
     */
    @org.junit.jupiter.api.Test
    public void testCheckMessageId() {
        System.out.println("checkMessageId");
        String message = "";
        String expResult = "";
        String result = Part2project.checkMessageId(message);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkRecipientCell method, of class Part2project.
     */
    @org.junit.jupiter.api.Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        String recipientCell = "";
        String expResult = "";
        String result = Part2project.checkRecipientCell(recipientCell);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sentMessage method, of class Part2project.
     */
    @org.junit.jupiter.api.Test
    public void testSentMessage() {
        System.out.println("sentMessage");
        String message = "";
        String recipient = "";
        Part2project.sentMessage(message, recipient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeMessageInJSON method, of class Part2project.
     */
    @org.junit.jupiter.api.Test
    public void testStoreMessageInJSON() {
        System.out.println("storeMessageInJSON");
        String recipient = "";
        String message = "";
        Part2project.storeMessageInJSON(recipient, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadMessagesFromJSON method, of class Part2project.
     */
    @org.junit.jupiter.api.Test
    public void testLoadMessagesFromJSON() {
        System.out.println("loadMessagesFromJSON");
        Part2project.loadMessagesFromJSON();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSentMessage method, of class Part2project.
     */
    @org.junit.jupiter.api.Test
    public void testAddSentMessage() {
        System.out.println("addSentMessage");
        String messageDetails = "";
        Part2project.addSentMessage(messageDetails);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnTotalMessage method, of class Part2project.
     */
    @org.junit.jupiter.api.Test
    public void testReturnTotalMessage() {
        System.out.println("returnTotalMessage");
        int expResult = 0;
        int result = Part2project.returnTotalMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
