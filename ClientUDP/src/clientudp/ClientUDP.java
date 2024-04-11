package clientudp;

// Importa le classi necessarie per la comunicazione di rete e la gestione di dati
import java.net.*;
import java.io.*;

public class ClientUDP {

    // Definisce la porta su cui il server è in ascolto
    private static final int PORT = 5000;

    public static void main(String[] args) throws Exception {
        // Crea un socket datagram per la comunicazione UDP
        DatagramSocket clientSocket = new DatagramSocket();

        // Ottiene l'indirizzo IP del server (in esecuzione sulla stessa macchina)
        InetAddress serverAddress = InetAddress.getByName("localhost");

        // Prepara il messaggio da inviare al server
        String message = "Ciao, sono il Client!";

        // Converte il messaggio in un array di byte
        byte[] sendData = message.getBytes();

        // Crea un pacchetto datagram per l'invio, specificando i dati, la lunghezza, 
        // l'indirizzo IP del server e la porta
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, PORT);

        // Invia il pacchetto al server
        clientSocket.send(sendPacket);

        // Crea un buffer per la ricezione della risposta
        byte[] receiveData = new byte[1024];

        // Crea un pacchetto datagram per la ricezione della risposta
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

        // Attende la risposta dal server
        clientSocket.receive(receivePacket);

        // Converte i dati ricevuti in una stringa
        String response = new String(receivePacket.getData());

        // Stampa la risposta
        System.out.println("Risposta dal server: " + response);
    }
}
