import org.springframework.cloud.contract.spec.Contract

Contract.make {

    label 'publish_car'

    input {
        triggeredBy("publish()")
    }


    outputMessage {
        sentTo("cars")

        body([
                ownerId: 1,
                model: "Uno",
                brand: "FIAT",
                modelYear: 2019,
                releaseYear: 2019,
                licensePlate: "ABC-1234",
                color: "Black"
        ])

    }

}
