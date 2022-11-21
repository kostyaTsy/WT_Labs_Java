package by.bsuir.task.server.dao;

import by.bsuir.task.server.model.Client;
import by.bsuir.task.server.service.ServiceFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CaseDao {
    private static final CaseDao INSTANCE = new CaseDao();
    private static final String CASES_PATH = "./src/resources/clients.xml";

    private final ReadWriteLock lock;
    private final Map<Integer, Client> clients;

    private CaseDao() {
        lock = new ReentrantReadWriteLock();
        clients = new HashMap<>();
        init();
    }

    private void init() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(CASES_PATH));
            doc.getDocumentElement().normalize();
            NodeList nodes = doc.getDocumentElement().getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    var _case = ServiceFactory.getInstance().getClientService().createClient(node.getChildNodes());
                    clients.put(_case.getId(), _case);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException ignored) {
        }
    }

    public static CaseDao getInstance() {
        return INSTANCE;
    }

    public boolean contains(int id) {
        return clients.containsKey(id);
    }

    public List<Client> getAll() {
        try {
            lock.readLock().lock();
            return new ArrayList<>(clients.values());
        } finally {
            lock.readLock().unlock();
        }
    }

    public void add(Client _client) {
        try {
            lock.writeLock().lock();
            _client.setId(clients.keySet().stream().max(Comparator.comparingInt(a -> a)).get() + 1);
            clients.put(_client.getId(), _client);
            update();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void setById(int id, Client _client) {
        try {
            lock.writeLock().lock();
            _client.setId(id);
            clients.put(id, _client);
            update();
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void update() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            Element rootEle = doc.createElement("clients");
            for(var _case : getAll()) {
                Element caseEle = ServiceFactory.getInstance().getClientService().createNode(doc, _case);
                rootEle.appendChild(caseEle);
            }

            doc.appendChild(rootEle);

            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(CASES_PATH)));

            } catch (IOException | TransformerException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}