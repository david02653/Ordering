package contracts

import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description "cinemacatalog contract"
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
}

// 多個寫法
// [Contract.make{}, Contract.make{}]