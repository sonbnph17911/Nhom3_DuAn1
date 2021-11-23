/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
/**
 *
 * @author DuongNVPH
 */
public interface HairSalonDAO<EntityType,KeyType>{
    public void insert(EntityType model);
    public void update(EntityType model);
    public void delete( KeyType id);
    public EntityType selectByID(KeyType id);
    public ArrayList<EntityType> selectAll();
}
