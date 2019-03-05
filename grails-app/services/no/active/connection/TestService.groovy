package no.active.connection

import grails.gorm.transactions.Transactional

@Transactional
class TestService {

    def auditService

    /**
     * This will fail because the auditService method it uses is transactional and is inside a withNewSession
     */
    Person createFail1(String firstName, String surname) {
        Person.withNewSession {
            def p = new Person(firstName: firstName, surname: surname, createdOn: new Date())
            p.save(flush: true, failOnError: true)
            auditService.logMessageTx(p, "Person created")
            return p
        }
    }

    /**
     * This will fail because the auditService method it uses is transactional and is inside a withNewSession,
     * it demonstrates that there is an active connection in this service, and the audit service
     */
    Person createFail2(String firstName, String surname) {
        Person.withNewSession {
            def p = new Person(firstName: firstName, surname: surname, createdOn: new Date())
            p.save(flush: true, failOnError: true)
            auditService.logMessageTxUseConnection(p, "Person created")
            return p
        }
    }


    /**
     * This will work because the auditService message is marked as NotTransactional
     */
    Person createSucceed1(String firstName, String surname) {
        Person.withNewSession {
            def p = new Person(firstName: firstName, surname: surname, createdOn: new Date())
            p.save(flush: true, failOnError: true)
            auditService.logMessageNoTx(p, "Person created")
            return p
        }
    }

    /**
     * This will work because it is not executed within a new session
     */
    Person createSucceed2(String firstName, String surname) {
        def p = new Person(firstName: firstName, surname: surname, createdOn: new Date())
        p.save(flush: true, failOnError: true)
        auditService.logMessageTx(p, "Person created")
        return p
    }

    /**
     * This will work because the call to the audit service is omitted
     */
    Person createSucceed3(String firstName, String surname) {
        Person.withNewSession {
            def p = new Person(firstName: firstName, surname: surname, createdOn: new Date())
            p.save(flush: true, failOnError: true)
            return p
        }
    }

}
