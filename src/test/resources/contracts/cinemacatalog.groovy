package contracts

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            description ("ordering contract")
            name ("cinemacatalog_newMovieOrdering")
            request {
                method ("GET")
                url("/newMovieOrdering") {
                    queryParameters {
                        parameter("userID", "1")
                        parameter("moviesID", "5e0b10fa974ef74883b43403")
                    }
                }
            }
            response {
                body("success")
                status (200)
            }
        }
]