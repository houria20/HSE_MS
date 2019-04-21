/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.sonatrach.hse.sessionbeans;

import dz.sonatrach.hse.entities.Analyste;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pc
 */
@Stateless
public class AnalysteFacade extends AbstractFacade<Analyste> {

    @PersistenceContext(unitName = "dz.sonatrach_test-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnalysteFacade() {
        super(Analyste.class);
    }
    
}
