package com.tobiascode.server;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.*;
import java.util.logging.Logger;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class BeanTransaction {
    private Logger log = Logger.getLogger(this.getClass().getName());

    @Resource
    private UserTransaction userTransaction;

    public String doWork(boolean commitWork) {
        log.info("Doing some work");
        String result = null;

        try {
            if(userTransaction.getStatus() == Status.STATUS_ACTIVE) log.info("Transaction started 1");

            userTransaction.begin();

            if(userTransaction.getStatus() == Status.STATUS_ACTIVE) log.info("Transaction started 2");

            if (commitWork) {
                result = "My work is committed";
                log.info("Committing work");
                userTransaction.commit();
            } else {
                result = "My work is rolled back";
                log.info("Rolling back work");
                userTransaction.rollback();
            }
        } catch (NotSupportedException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
