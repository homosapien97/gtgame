package com.sleepyheads.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;
import com.badlogic.gdx.net.Socket;
import com.sleepyheads.game.world.World;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Server implements ApplicationListener {
    private Set<Client> clients;
    private Set<Event> events;
    World world;
    String address = ""; //TODO

    public Server() {
        ConcurrentHashMap<Client, Object> dummy1;
        ConcurrentHashMap<Event, Object> dummy2;
        dummy1 = new ConcurrentHashMap<>();
        dummy2 = new ConcurrentHashMap<>();
        clients = dummy1.newKeySet();
        events = dummy2.newKeySet();
        world = new World();
        List<String> addresses = new ArrayList<>();
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            for(NetworkInterface ni : Collections.list(interfaces)){
                for(InetAddress address : Collections.list(ni.getInetAddresses()))
                {
                    if(address instanceof Inet4Address){
                        addresses.add(address.getHostAddress());
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        address = addresses.get(0);
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void addEvents(Set<Event> events) {
        this.events.addAll(events);
    }

    public void doEvents() {
        for(Event e : events) {
            e.happen(world);
        }
        //TODO
    }

    @Override
    public void create() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Starting server");
                ServerSocketHints serverSocketHint = new ServerSocketHints();
                // 0 means no timeout.  Probably not the greatest idea in production!
                serverSocketHint.acceptTimeout = 0;

                /*
                 Create the socket server using TCP protocol and listening on 9021
                 Only one app can listen to a port at a time, keep in mind many ports are reserved
                 especially in the lower numbers ( like 21, 80, etc )
                */
                ServerSocket serverSocket = Gdx.net.newServerSocket(Net.Protocol.TCP, 9021, serverSocketHint);
                Socket socket = serverSocket.accept(null);
                ObjectInputStream inputStream = null;
                try {
                    inputStream = new ObjectInputStream(socket.getInputStream());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                assert inputStream != null;
                // Loop forever
                while (true) {
                    try {
                        while (inputStream.available() > 0) {
                            Event event = (Event) inputStream.readObject();
                            events.add(event);
                        }
                        doEvents();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
//        }).run();
        });
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
