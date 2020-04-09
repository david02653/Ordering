package contracts

import org.springframework.cloud.contract.spec.Contract

// HTTP request method (GET/POST/PUT/DELETE).

[
        Contract.make {
            description ("ordering contract")
            name ("validate_prime-number")
            request {
                method ("GET")
                url("/validate/prime-number") {
                    queryParameters {
                        parameter("number", "2")
                    }
                }
            }
            response {
                body("Even")
                status (200)
            }
        },
        Contract.make {
            description ("ordering contract")
            name ("newMovieOrdering")
            request {
                method ("GET")
                url("/newMovieOrdering") {
                    queryParameters {
                        parameter("moviesID", "5e0b10fa974ef74883b43403")
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
            name ("newGroceryOrdering")
            request {
                method ("GET")
                url("/newGroceryOrdering") {
                    queryParameters {
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
            name ("getMovieFromOrderList")
            request {
                method ("GET")
                url("/getMovieFromOrderList") {
                    queryParameters {
                        parameter("userID", "1")
                    }
                }
            }
            response {
                status (200)
            }
        },
        Contract.make {
            description ("ordering contract")
            name("getGroceryFromOrderList")
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