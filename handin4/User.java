public class User {
    
    private Message[] inbox;
    private int messageCount;


    public User() {
        this.inbox = new Message[20];
        this.messageCount = 0;
    }

    public String addMessage(Message msg) {
        if (this.messageCount == this.inbox.length) {
            return "Sorry, the inbox is full!";
        }
        this.inbox[this.messageCount] = msg;
        this.messageCount++;
        return "Message is added!";
    }

    public boolean sendMessage(Message msg) {
        return msg.getReceiver().addMessage(msg).equals("Message is added!");
    }

    public String readMessage() {
        if (this.messageCount == 0) {
            return "There is no message to read!";
        }

        Message[] oldMsg = this.inbox.clone();

        for (int i=0; i<oldMsg.length; i++) {

            this.inbox[i] = ((i+1)<oldMsg.length) ? oldMsg[i+1] : null;
        }
        this.messageCount--;
        return oldMsg[0].getText();
    }

}
