package no.active.connection

class Person implements AuditableObject {

    String firstName
    String surname
    Date createdOn

    static constraints = {
    }
}
