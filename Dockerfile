FROM docker.io/library/eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /src/bookubehistory
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew clean bootjar

FROM docker.io/library/eclipse-temurin:21-jre-alpine AS runner

ARG USER_NAME=bookubehistory
ARG USER_UID=1000
ARG USER_GID=${USER_UID}

RUN addgroup -g ${USER_GID} ${USER_NAME} \
&& adduser -h /opt/bookubehistory -D -u ${USER_UID} -G ${USER_NAME} ${USER_NAME}

USER ${USER_NAME}
WORKDIR /opt/bookubehistory
COPY --from=builder --chown=${USER_UID}:${USER_GID} /src/bookubehistory/build/libs/*.jar app.jar

EXPOSE 8000

ENTRYPOINT ["java"]
CMD ["-jar", "app.jar"]