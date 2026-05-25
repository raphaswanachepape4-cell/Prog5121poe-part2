import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;              
import java.time.LocalDateTime;
import org.json.JSONArray;
import org.json.JSONObject;

public class Part2project{

    private static ArrayList<String> sentMessages = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static String filePath = "messages.json";

    public static void main(String[] args) {
        System.out.println("Hello, welcome to QuickChat"); //Welcoming the user into the QuickChat.

        System.out.print("How many messages do you want to enter? "); //prompting the user to enter their message.
        int count = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < count; i++) {
            System.out.println("\n--- Message " + (i + 1) + " of " + count + " ---");

            System.out.print("Enter recipient number: "); //reciving the recipient's number.
            String recipient = scanner.nextLine();

            if (!checkRecipientCell(recipient).equals("Valid")) {
                System.out.println(checkRecipientCell(recipient));
                i--;
                continue;
            }

            System.out.print("Enter your message: ");
            String message = scanner.nextLine();

            if (!checkMessageId(message).equals("Valid")) {
                System.out.println(checkMessageId(message));
                i--;
                continue;
            }

            sentMessage(message, recipient);
        }
    }
//Making sure that the message entered does not exit 250.
    public static String checkMessageId(String message) {
        if (message == null || message.isEmpty()) {
            return "Invalid. No message entered";
        }
        if (message.length() > 250) {
            return "Invalid. Please enter a message of max 250 characters";
        }
        return "Valid";
    }
//checking the if recipient's numbers meets the requirements
    public static String checkRecipientCell(String recipientCell) {
        if (recipientCell == null || recipientCell.length()!= 12) {
            return "Invalid. Number must be 12 characters: +27 followed by 9 digits";
        }
        if (!recipientCell.startsWith("+27")) {
            return "Invalid. Number must start with +27";
        }
        return "Valid";
    }

    public static void sentMessage(String message, String recipient) {
        while (true) {
            System.out.println("\n--- QuickChat Menu ---"); //QuickChat message options.
            System.out.println("1: Send Message");
            System.out.println("2: Store Message");
            System.out.println("3: Disregard Message");
            System.out.println("4: View Stored Messages");
            System.out.println("5: Go to Next Message");
            System.out.println("6: Quit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    String fullMsg = "To: " + recipient + " | Message: " + message;
                    addSentMessage(fullMsg);
                    System.out.println("To: "+ recipient + "\nMessage: "+message);
                    System.out.println("Message sent successfully");
                    break;

                case 2:
                    storeMessageInJSON(recipient, message);
                    break;

                case 3:
                    System.out.println("Message disregarded");
                    return;

                case 4:
                    loadMessagesFromJSON();
                    break;

                case 5:
                    System.out.println("Moving to next message...");
                    return;

                case 6:
                    System.out.println("Total messages sent: " + returnTotalMessage());
                    System.out.println("Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a correct choice");
            }
        }
    }

    public static void storeMessageInJSON(String recipient, String message) {
        JSONArray messagesArray = new JSONArray();

        // Load existing messages if file exists
        try {
            File file = new File(filePath);
            if (file.exists()) {
                FileReader reader = new FileReader(file);
                StringBuilder sb = new StringBuilder();
                int i;
                while ((i = reader.read()) != -1) {
                    sb.append((char) i);
                }
                reader.close();
                if (!sb.toString().isEmpty()) {
                    messagesArray = new JSONArray(sb.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Create new message object
        JSONObject msgObj = new JSONObject();
        msgObj.put("recipient", recipient);
        msgObj.put("message", message);
        msgObj.put("timestamp", LocalDateTime.now().toString());

        messagesArray.put(msgObj);

        // Write back to file
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(messagesArray.toString(4)); // 4 = pretty print
            System.out.println("Message stored in messages.json");
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
//saving the message into the Json.
    public static void loadMessagesFromJSON() {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("No stored messages found");
            return;
        }

        try {
            FileReader reader = new FileReader(file);
            StringBuilder sb = new StringBuilder();
            int i;
            while ((i = reader.read()) != -1) {
                sb.append((char) i);
            }
            reader.close();

            JSONArray messagesArray = new JSONArray(sb.toString());

            if (messagesArray.length() == 0) {
                System.out.println("No stored messages found");
                return;
            }

            System.out.println("\n--- Stored Messages ---");
            for (int j = 0; j < messagesArray.length(); j++) {
                JSONObject msg = messagesArray.getJSONObject(j);
                System.out.println((j + 1) + ". To: " + msg.getString("recipient"));
                System.out.println("   Message: " + msg.getString("message"));
                System.out.println("   Time: " + msg.getString("timestamp"));
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
//adding message detail to the sent message.
    public static void addSentMessage(String messageDetails) {
        sentMessages.add(messageDetails);
    }
//counting the message's total.
    public static int returnTotalMessage() {
        return sentMessages.size();
    }
}
    

