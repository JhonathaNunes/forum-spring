CREATE TABLE users
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

INSERT INTO users (name, email) VALUES ('John Doe', 'john.doe@test.com')