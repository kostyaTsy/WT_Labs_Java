package by.bsuir.task.client.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientInputController extends Thread {
    private final ClientController client;

    public ClientInputController(ClientController client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            var reader = new BufferedReader(new InputStreamReader(System.in));
            while (client.isRunning()) {
                var response = reader.readLine();
                client.sendMessage(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
