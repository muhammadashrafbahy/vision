//package service
//
//import spock.lang.Specification
//import vision.army.entity.user
//import  vision.army.exception.*
//import vision.army.reprositery.userRepository
//import vision.army.service.userService
//import vision.army.service.validation.userValidator
//
//
//class userServiceTest extends  Specification {
//    def  user_validator =Mock(userValidator)
//    def  user_repository = Mock(userRepository)
//    def  user_Service =new userService(userRepository,userValidator)
//
//    def "should get all users"(){
//        setup:
//        def returned = ArrayList()
//
//        when:
//        def result = user_Service.getAllUsers()
//
//        then:
//        1*user_repository.findAll() >> returned
//        result == returned
//
//    }
//}
