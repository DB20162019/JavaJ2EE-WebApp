/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo.service;

import fr.utbm.projetlo.entity.Client;
import fr.utbm.projetlo.repository.ClientDAO;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author dainahb
 */
public class ClientService implements Serializable{
    private Client client = new Client();

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public void register(Client cli){
        ClientDAO dao = new ClientDAO();
        dao.insert(cli);
    }
    
    public ArrayList<Client> liste(Integer idSession) {
        ClientDAO dao = new ClientDAO();
        return dao.select(idSession);
    }
}
