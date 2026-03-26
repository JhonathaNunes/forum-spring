CREATE TABLE course
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    CONSTRAINT pk_course PRIMARY KEY (id)
);

INSERT INTO course VALUES (1, 'Kotlin', 'Programacao')