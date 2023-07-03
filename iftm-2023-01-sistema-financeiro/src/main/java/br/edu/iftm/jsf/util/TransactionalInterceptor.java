package br.edu.iftm.jsf.util;

import java.io.Serializable;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Interceptor
@Transacional
@Priority(Interceptor.Priority.APPLICATION)
public class TransactionalInterceptor implements Serializable {
        
     
    @Inject
    private EntityManager manager;
    
    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        EntityTransaction transaction = manager.getTransaction();
        boolean criador = false;
        
        try {
            if(!transaction.isActive()) {
                transaction.begin();
                transaction.rollback();
                
                transaction.begin();
                criador = true;
            }
            return context.proceed();
        } catch(Exception e){
            if(transaction != null && criador) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if(transaction != null && transaction.isActive() && criador) {
                transaction.commit();
            }
            manager.clear();
        }
    }
    
}
