# coding=utf-8

from py.thrift.generated import ttypes


class PersonServiceImpl:

    def getPersonByUsername(self, username):
        print "Get client param:" + username
        person = ttypes.Person()
        person.username = username
        person.age = 12
        person.married = False
        return person

    def savePerson(self, person):
        print "Get client param:"
        print person.username
        print person.age
        print person.married
