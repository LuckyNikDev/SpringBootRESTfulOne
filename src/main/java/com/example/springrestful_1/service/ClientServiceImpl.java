package com.example.springrestful_1.service;

import com.example.springrestful_1.model.Client;
import com.example.springrestful_1.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void create(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> readAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client read(int id) {
        return clientRepository.getOne(id);
    }

    @Override
    public boolean update(Client client, int id) {
        if (clientRepository.existsById(id)) {
            client.setId(id);
            clientRepository.save(client);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


//логика работы с мапой
//@Service
//public class ClientServiceImpl implements ClientService {
//    private static final Map<Integer, Client> ClIENT_REPOSITORY_MAP = new HashMap<>();
//    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();
//
//    @Override
//    public void create(Client client) {
//        final int clientId = CLIENT_ID_HOLDER.incrementAndGet();
//        client.setId(clientId);
//        ClIENT_REPOSITORY_MAP.put(clientId, client);
//    }
//
//    @Override
//    public List<Client> readAll() {
//        return new ArrayList<>(ClIENT_REPOSITORY_MAP.values());
//    }
//
//    @Override
//    public Client read(int id) {
//        return ClIENT_REPOSITORY_MAP.get(id);
//    }
//
//    @Override
//    public boolean update(Client client, int id) {
//        if (ClIENT_REPOSITORY_MAP.containsKey(id)) {
//            client.setId(id);
//            ClIENT_REPOSITORY_MAP.put(id,client);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean delete(int id) {
//        return ClIENT_REPOSITORY_MAP.remove(id) != null;
//    }
//}
