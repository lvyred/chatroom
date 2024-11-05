package com.chat.chatroom.service;

public interface ChatRoomService {
    String joinRoom(String roomId, String userId);
    String leaveRoom(String roomId, String userId);
}
