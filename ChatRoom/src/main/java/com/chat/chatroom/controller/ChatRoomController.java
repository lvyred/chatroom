package com.chat.chatroom.controller;

import com.chat.chatroom.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChatRoomController {
    @Autowired
    private ChatRoomService chatRoomService;

    @PostMapping("/chatroom/join/")
    public String joinRoom(@RequestParam Map<String, String> data) {
        String roomId = data.get("roomId");
        String userId = data.get("userId");
        return chatRoomService.joinRoom(roomId, userId);
    }

    @PostMapping("/chatroom/leave/")
    public String leaveRoom(@RequestParam Map<String, String> data) {
        String roomId = data.get("roomId");
        String userId = data.get("userId");
        return chatRoomService.leaveRoom(roomId, userId);
    }
}
