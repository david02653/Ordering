package contracts

import org.springframework.cloud.contract.spec.Contract
[
        Contract.make {
            description "Ordering contract"
            name("cinemacatalog_validate_primeNumber")
            request {
                method GET()
                url("/validate/prime-number") {
                    queryParameters {
                        parameter("number", "2")
                    }
                }
            }
            response {
                body("Even")
                status 200
            }
        },
        Contract.make {
            description "Ordering contract"
            name("newMovieOrdering")
            request {
                method GET()
                url("/newMovieOrdering") {
                    queryParameters {
                        parameter("moviesID", "5e0b10fa974ef74883b43403")
                    }
                }
            }
            response {
                body("success")
                status 200
            }
        },
        Contract.make {
            description "Ordering contract"
            name("newGroceryOrdering")
            request {
                method GET()
                url("/newGroceryOrdering") {
                    queryParameters {
                        parameter("groceryID", "5c49e70e212d8d18c0fccd55")
                        parameter("quantity", "2")
                    }
                }
            }
            response {
                body("success")
                status 200
            }
        },
        Contract.make {
            description "Ordering contract"
            name("getMovieFromOrderList")
            request {
                method GET()
                url("/getMovieFromOrderList") {
                    queryParameters {
                        parameter("userID", "1")
                    }
                }
            }
            response {
                status 200
            }
        },
        Contract.make {
            description "Ordering contract"
            name("getGroceryFromOrderList")
            request {
                method GET()
                url("/getGroceryFromOrderList") {
                    queryParameters {
                        parameter("userID", "1")
                    }
                }
            }
            response {
                status 200
            }
        }
]

// 多個寫法
// [Contract.make{}, Contract.make{}]