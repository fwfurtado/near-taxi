package user

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    request {
        url '/1'
        method 'GET'

        headers {
            accept applicationJson()
        }
    }

    response {
        status OK()

        headers {
            contentType applicationJson()
        }

        body([
            id: 1,
            name: "Fernando"
        ])
    }

}