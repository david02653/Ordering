//package contracts
//
//import org.springframework.cloud.contract.spec.Contract
//Contract.make {
//    description "should return success"
//    request{
//        method GET()
//        url("/") {
//            /*queryParameters {
//                parameter("number", "2")
//            }*/
//        }
//    }
//    response {
//        body("success")
//        status 200
//    }
//}