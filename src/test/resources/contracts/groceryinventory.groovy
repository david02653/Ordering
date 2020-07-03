package contracts

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            description ("ordering contract")
            name ("groceryinventory_newGroceryOrdering")
            request {
                method ("GET")
                url("/newGroceryOrdering") {
                    queryParameters {
                        parameter("userID", "1")
                        parameter("groceryID", "5c49e70e212d8d18c0fccd55")
                        parameter("quantity", "2")
                    }
                }
            }
            response {
                body("success")
                status (200)
            }
        },
        Contract.make {
            description ("ordering contract")
            name("groceryinventory_getGroceryFromOrderList")
            request {
                method ("GET")
                url("/getGroceryFromOrderList") {
                    queryParameters {
                        parameter("userID", "1")
                    }
                }
            }
            response {
                status (200)
            }
        }
]