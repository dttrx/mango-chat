package io.koki.mangochat;

import io.koki.mangochat.config.AppConfig;
import io.koki.mangochat.config.CommunicationMode;
import io.koki.mangochat.controller.LoginController;
import io.koki.mangochat.networking.*;
import io.koki.mangochat.view.LoginView;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MangoChatClient {
    public static void main(String[] args) {
        AppConfig.setCommunicationMode(CommunicationMode.TCP);

        Client client = AppConfig.getCommunicationMode() == CommunicationMode.TCP
                ? new TCPClient()
                : new UDPClient();
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(client, loginView);

        try {
            loginController.setUpServer(InetAddress.getLocalHost(), 1234);
            loginController.show();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
