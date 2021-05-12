FROM ubuntu:latest

RUN apt update
RUN apt install -y default-jdk default-jre maven


COPY . /app

WORKDIR /app
RUN mvn clean install
RUN mvn compile
ENTRYPOINT ["mvn","exec:java", "-Dexec.mainClass=com.pulse.desafio.ecommerce.checkout.CheckoutApplication"]
