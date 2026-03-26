CREATE TABLE answer
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    message     VARCHAR(255) NOT NULL,
    created_at  datetime     NOT NULL,
    updated_at  datetime     NOT NULL,
    author_id   BIGINT NULL,
    topic_id    BIGINT NULL,
    is_solution BIT(1)       NOT NULL,
    CONSTRAINT pk_answer PRIMARY KEY (id)
);

ALTER TABLE answer
    ADD CONSTRAINT FK_ANSWER_ON_AUTHOR FOREIGN KEY (author_id) REFERENCES users (id);

ALTER TABLE answer
    ADD CONSTRAINT FK_ANSWER_ON_TOPIC FOREIGN KEY (topic_id) REFERENCES topic (id);