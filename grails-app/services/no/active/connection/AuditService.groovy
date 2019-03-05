package no.active.connection

import grails.gorm.transactions.NotTransactional
import grails.gorm.transactions.Transactional

@Transactional
class AuditService {

    void logMessageTx(AuditableObject object, String message) {
        log.info("AuditMessage for ${object.class.simpleName}::${object.id}: ${message}")
    }

    void logMessageTxUseConnection(AuditableObject object, String message) {
        log.info("AuditMessage for ${object.class.simpleName}::${object.id}: ${message}")
        def people = Person.list()
        println people*.id
    }

    @NotTransactional
    void logMessageNoTx(AuditableObject object, String message) {
        log.info("AuditMessage for ${object.class.simpleName}::${object.id}: ${message}")
    }

}
