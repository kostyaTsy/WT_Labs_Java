package by.bsuir.task.server.service;

import by.bsuir.task.server.model.Client;
import by.bsuir.task.server.dao.DaoFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;

public class ClientService {
    private static final ClientService INSTANCE = new ClientService();

    private ClientService() {
    }

    public static ClientService getInstance() {
        return INSTANCE;
    }

    public Client createClient(NodeList nodes) {
        int id = 0;
        String first = "";
        String last = "";

        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String text = nodes.item(i).getTextContent();
                switch (nodes.item(i).getNodeName()) {
                    case "id" -> id = Integer.parseInt(text);
                    case "firstName" -> first = text;
                    case "lastName" -> last = text;
                    default -> throw new IllegalArgumentException("No such client exists");
                }
            }
        }

        return new Client(id, first, last);
    }

    public Element createNode(Document doc, Client _client) {
        Element e = doc.createElement("client");
        Element id = doc.createElement("id");
        Element first = doc.createElement("firstName");
        Element last = doc.createElement("lastName");
        id.appendChild(doc.createTextNode(String.valueOf(_client.getId())));
        first.appendChild(doc.createTextNode(_client.getFirstName()));
        last.appendChild(doc.createTextNode(_client.getLastName()));
        e.appendChild(id);
        e.appendChild(first);
        e.appendChild(last);
        return e;
    }

    public List<Client> getAll() {
        return DaoFactory.getInstance().getCaseDao().getAll();
    }

    public boolean containsCase(int id) {
        return DaoFactory.getInstance().getCaseDao().contains(id);
    }

    public void editCase(int id, String firstName, String lastName) {
        DaoFactory.getInstance().getCaseDao().setById(id, new Client(0, firstName, lastName));
    }

    public void addCase(String firstName, String lastName) {
        DaoFactory.getInstance().getCaseDao().add(new Client(0, firstName, lastName));
    }
}