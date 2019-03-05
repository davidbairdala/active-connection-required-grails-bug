package no.active.connection

import grails.gorm.transactions.Transactional

@Transactional
class TestController {

    def testService

    def index() {

    }

    def willFail1() {
        def p = testService.createFail1("first", "last")
        println p
        render(view: 'index', model:[person: p])
    }

    def willFail2() {
        def p = testService.createFail2("first", "last")
        render(view: 'index', model:[person: p])
    }

    def willSucceed1() {
        def p = testService.createSucceed1("first", "last")
        println p
        render(view: 'index', model:[person: p])
    }

    def willSucceed2() {
        def p = testService.createSucceed2("first", "last")
        render(view: 'index', model:[person: p])
    }

    def willSucceed3() {
        def p = testService.createSucceed3("first", "last")
        render(view: 'index', model:[person: p])
    }

}
