package codelab04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StormTrooperTest {
    @Test
    @DisplayName("Adding a friend is bidirectional")
    void addFriend_updatesBothFriendsLists() {
        //given
        StormTrooper s1 = new StormTrooper("Kurt");
        StormTrooper s2 = new StormTrooper("Sarah");
        //when
        s1.addFriend(s2);
        //then
        assertTrue(s2.getFriends().contains(s1));
        assertTrue(s1.getFriends().contains(s2));
    }

    @Test
    @DisplayName("AddFriend does nothing when username is not unique in friendsSet")
    void addFriend_whenFriendNameIsNotUniqueIn_thenDontAdd() {
        //given
        StormTrooper s1 = new StormTrooper("Kurt");
        StormTrooper s2 = new StormTrooper("Sarah");
        StormTrooper s3 = new StormTrooper("Sarah");
        //when
        boolean added2 = s1.addFriend(s2);
        boolean added3 = s1.addFriend(s3);
        //then
        assertTrue(added2);
        assertFalse(added3);
        assertEquals(1, s1.getFriends().size());
        assertEquals(0, s3.getFriends().size());
    }

    @Test
    @DisplayName("sendMessage adds message to recipients messages")
    void sendMessage_updatesRecipientsMessages() {
        //given
        StormTrooper s1 = new StormTrooper("Kurt");
        StormTrooper s2 = new StormTrooper("Sarah");
        s1.addFriend(s2);
        //when
        boolean sent = s1.sendMessage("Test body", s2);
        s1.sendMessage("Test body", s2);
        //then
        assertTrue(sent);
        assertEquals(2, s2.getMessages().size());
    }

    @Test
    @DisplayName("sendMessage doesnt send when recipient is not in friendsSet")
    void sendMessage_whenRecipientNotInFriendsSet_thenDontSend() {
        //given
        StormTrooper s1 = new StormTrooper("Kurt");
        StormTrooper s2 = new StormTrooper("Sarah");
        //when
        boolean sent = s1.sendMessage("Test body", s2);
        //then
        assertFalse(sent);
        assertEquals(0, s2.getMessages().size());
    }

    @Test
    @DisplayName("messages are stored by date, latest message first")
    void getMessages_returnsMessagesSortedByDateDesc() {
        //given
        StormTrooper s1 = new StormTrooper("Kurt");
        StormTrooper s2 = new StormTrooper("Sarah");
        Message message1 = new Message(LocalDateTime.of(2000, 1, 11, 0, 0), s2, "Test Body");
        Message message2 = new Message(LocalDateTime.of(2000, 1, 5, 0, 0), s2, "Test Body");
        Message message3 = new Message(LocalDateTime.of(2000, 1, 20, 0, 0), s2, "Test Body");
        Message message4 = new Message(LocalDateTime.of(1999, 12, 6, 0, 0), s2, "Test Body");
        s1.getMessages().add(message1);
        s1.getMessages().add(message2);
        s1.getMessages().add(message3);
        s1.getMessages().add(message4);
        //when
        List<Message> messages = s1.getMessages();
        //then
        assertEquals(message3, messages.get(0));
        assertEquals(message1, messages.get(1));
        assertEquals(message2, messages.get(2));
        assertEquals(message4, messages.get(3));
    }

    @Test
    @DisplayName("getMessagesFrom returns all messages from friend sorted by date")
    void getMessagesFromFriend_returnsAllMessagesSortedByDate() {
        //given
        StormTrooper s1 = new StormTrooper("Kurt");
        StormTrooper s2 = new StormTrooper("Sarah");
        StormTrooper s3 = new StormTrooper("Bruno");
        assertTrue(s1.addFriend(s3));
        assertTrue(s2.addFriend(s3));
        Message message1 = new Message(LocalDateTime.now(), s1, "Test body");
        Message message2 = new Message(LocalDateTime.now(), s2, "Test body");
        Message message3 = new Message(LocalDateTime.now(), s1, "Test body");
        Message message4 = new Message(LocalDateTime.now(), s2, "Test body");
        Message message5 = new Message(LocalDateTime.now(), s2, "Test body");
        Message message6 = new Message(LocalDateTime.now(), s1, "Test body");
        assertTrue(s1.sendMessage(message1, s3));
        assertTrue(s2.sendMessage(message2, s3));
        s1.sendMessage(message3, s3);
        s2.sendMessage(message4, s3);
        s2.sendMessage(message5, s3);
        s1.sendMessage(message6, s3);
        //when
        System.out.println(s3.getMessages());
        List<Message> messages = s3.getMessagesFrom(s2);
        //then
        assertEquals(3, messages.size());
        assertEquals(s2, messages.get(0).getSender());
        assertEquals(message5, messages.get(0));
        assertEquals(message4, messages.get(1));
        assertEquals(message2, messages.get(2));
    }

    @Test
    @DisplayName("getMessagesFrom returns null when not from a friend")
    void getMessagesFrom_whenNotAFriend_thenReturnsNull() {
        //given
        StormTrooper s1 = new StormTrooper("Kurt");
        StormTrooper s2 = new StormTrooper("Sarah");
        StormTrooper s3 = new StormTrooper("Bruno");
        s1.addFriend(s3);
        s3.addFriend(s2);
        s3.sendMessage("Test body", s1);
        s3.sendMessage("Test body", s1);
        s3.sendMessage("Test body", s1);
        s3.sendMessage("Test body", s2);
        //when
        List<Message> messages = s1.getMessagesFrom(s2);
        //then
        assertNull(messages);
    }

    @Test
    @DisplayName("soldiers can not befriends generals")
    void addFriend_whenSoldierAddsGeneral_thenThrowIllegalArgumentException() {
        //given
        StormTrooper s1 = new StormTrooper("Kurt");
        StormTrooper s2 = new StormTrooper("Sarah");
        //when
        s1.setRank(Rank.SOLDIER);
        s2.setRank(Rank.GENERAL);
        //then
        assertThrows(IllegalArgumentException.class, () -> s1.addFriend(s2));
    }

    @Test
    @DisplayName("generals can not befriend soldiers")
    void addFriend_whenGeneralAddsSoldier_thenThrowIllegalArgumentException() {
        //given
        StormTrooper s1 = new StormTrooper("Kurt");
        StormTrooper s2 = new StormTrooper("Sarah");
        //when
        s1.setRank(Rank.GENERAL);
        s2.setRank(Rank.SOLDIER);
        //then
        assertThrows(IllegalArgumentException.class, () -> s1.addFriend(s2));
    }
}