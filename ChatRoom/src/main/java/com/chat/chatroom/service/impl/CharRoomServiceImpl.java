package com.chat.chatroom.service.impl;

import com.chat.chatroom.service.ChatRoomService;
import com.chat.chatroom.service.impl.utils.ChatRoom;
import com.chat.chatroom.service.impl.utils.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CharRoomServiceImpl implements ChatRoomService {
    private Map<String, ChatRoom> chatRooms = new HashMap<>();

    @Override
    public String joinRoom(String roomId, String userId) {
        ChatRoom chatRoom = chatRooms.get(roomId);
        if (chatRoom == null) {
            List<User> users = new ArrayList<>();
            users.add(new User(userId));
            chatRoom = new ChatRoom(roomId, users);
            chatRooms.put(roomId, chatRoom);
        } else {
            List<User> users = chatRoom.getUsers();
            users.add(new User(userId));
            chatRoom.setUsers(users);
            printChatRoomMembers(chatRoom, userId);
        }
        return "added user " + roomId + " " + userId;
    }

    @Override
    public String leaveRoom(String roomId, String userId) {
        ChatRoom chatRoom = chatRooms.get(roomId);
        if (chatRoom == null) {
            return "room " + roomId + " not found";
        } else {
            List<User> users = chatRoom.getUsers();
            users.remove(new User(userId));
            chatRoom.setUsers(users);
            printChatRoomMembers(chatRoom, userId);
        }
        return "removed user " + roomId + " " + userId;
    }

    private void printChatRoomMembers(ChatRoom chatRoom, String userId) {
        System.out.println("roomMembers: ");
        for (User user : chatRoom.getUsers()) {
            if (!user.getId().equals(userId)) {
                System.out.print(user);
            }
        }
    }
}
